package mishra.sidharth.userauthentication.config;

import mishra.sidharth.userauthentication.domain.UserAuth;

import mishra.sidharth.userauthentication.exception.EmailExitException;
import mishra.sidharth.userauthentication.exception.UserNotFoundException;
import mishra.sidharth.userauthentication.requestedmodel.RequestModel;



import mishra.sidharth.userauthentication.services.UserAuthServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    @Autowired
    private UserAuthServiceImpl userAuthService;


    @RabbitListener(queues = "logindata")
    public void rabbitMqReceiver(RequestModel requestedModel)throws EmailExitException
    {   UserAuth userAuth = new UserAuth();
        userAuth.setEmail(requestedModel.getEmail());
        userAuth.setPassword(requestedModel.getPassword());
        System.out.println(requestedModel.getEmail()+"     ");
        userAuthService.registerData(userAuth);
        System.out.println(" SAVING DATA IN MYSQL");

    }
/*    @RabbitListener(queues = "admindata")
    public void rabbitLoginReceiver(RequestModel requestedModel)
    {
        System.out.println("inside rabbit");
        UserAuth userAuth = new UserAuth();
        userAuth.setEmail(requestedModel.getEmail());
        userAuth.setPassword(requestedModel.getPassword());
        System.out.println(requestedModel.getEmail()+"     ");
        userAuthService.loginData(userAuth);
        System.out.println(" fetching IN MYSQL");

    }*/

}
