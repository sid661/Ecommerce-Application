package sidharth.mishra.adminservice.rabbitMq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sidharth.mishra.adminservice.requestmodel.RequestModel;
@Component
public class Producer {
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void rabbitMQTransfer(RequestModel requestModel){
        rabbitTemplate.convertAndSend(directExchange.getName(),"admin_key",requestModel);
    }
}
