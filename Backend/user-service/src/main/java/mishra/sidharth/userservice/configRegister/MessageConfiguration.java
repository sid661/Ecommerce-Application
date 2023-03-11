package mishra.sidharth.userservice.configRegister;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
public class MessageConfiguration {
    private String queueName="logindata";

  //  private String registerQue="admindata";
    private String exchangeName="login_service";

//    private String adminexchange="admin_service";


    @Bean
  //  @Qualifier("login")
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }
    @Bean
//    @Qualifier("login")
    public Queue queue(){
        return new Queue(queueName);
    }
    @Bean
 //   @Qualifier("login")
    public Binding adminBinding(DirectExchange directExchange, Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with("userlogin_key");}

    //*********************************************************************************//
   /* @Bean
    @Qualifier("admin")
    public DirectExchange adminserviceExchange(){
        return new DirectExchange(adminexchange);
    }
    @Bean
    @Qualifier("admin")
    public Queue adminloginqueue(){
        return new Queue(registerQue);
    }
    @Bean
    @Qualifier("admin")
    public Binding loginBinding(DirectExchange adminexchange, Queue adminqueue ){
        return BindingBuilder.bind(adminqueue).to(adminexchange).with("adminlogin_key");}
*/
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
