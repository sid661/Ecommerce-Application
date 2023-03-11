package mishra.sidharth.userservice.configRegister;

import mishra.sidharth.userservice.requestmodel.RequestModel;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
   // @Qualifier("login")
    private RabbitTemplate rabbitTemplatelogin;
    @Autowired
  //  @Qualifier("login")
    private DirectExchange directExchangelogin;
  /*  @Autowired
    @Qualifier("admin")
    private RabbitTemplate rabbitTemplateadmin;
    @Autowired
    @Qualifier("admin")
    private DirectExchange directExchangeadmin;
*/



    public void rabbitMQTransfer(RequestModel requestModel){
        rabbitTemplatelogin.convertAndSend(directExchangelogin.getName(),"userlogin_key",requestModel);
    }

   /* public void rabbitMQadminTransfer(RequestModel requestModel){
        rabbitTemplateadmin.convertAndSend(directExchangeadmin.getName(),"adminlogin_key",requestModel);
    }*/

}
