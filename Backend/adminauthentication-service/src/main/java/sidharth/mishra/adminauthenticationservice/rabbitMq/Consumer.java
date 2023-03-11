package sidharth.mishra.adminauthenticationservice.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sidharth.mishra.adminauthenticationservice.domain.AdminAuth;
import sidharth.mishra.adminauthenticationservice.requestemodel.RequestModel;
import sidharth.mishra.adminauthenticationservice.service.AdminAuthServiceImpl;
@Component
public class Consumer {
    @Autowired
    private AdminAuthServiceImpl adminService;
    @RabbitListener(queues = "admindata")
    public void rabbitLoginReceiver(RequestModel requestedModel)
    {
        System.out.println("inside rabbit");
        AdminAuth adminAuth = new AdminAuth();
        adminAuth.setEmail(requestedModel.getEmail());
        adminAuth.setPassword(requestedModel.getPassword());
        adminAuth.setCompanyName(requestedModel.getCompanyName());
        System.out.println(requestedModel.getEmail()+"     ");
        adminService.saveAdmin(adminAuth);
        System.out.println(" saving IN MYSQL");

    }
}
