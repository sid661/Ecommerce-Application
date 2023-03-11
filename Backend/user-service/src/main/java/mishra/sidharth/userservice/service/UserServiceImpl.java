package mishra.sidharth.userservice.service;


import mishra.sidharth.userservice.configRegister.Producer;
import mishra.sidharth.userservice.domain.User;
import mishra.sidharth.userservice.exception.FeildsEmptyException;
import mishra.sidharth.userservice.repository.UserRepository;
import mishra.sidharth.userservice.requestmodel.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    private Producer producer;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User registerNewUser(User user) throws FeildsEmptyException {
        if ((user.getEmail() != null)&&(user.getPassword()!=null)) {
            RequestModel requestModel = new RequestModel();
            requestModel.setEmail(user.getEmail());
            requestModel.setPassword(user.getPassword());
            producer.rabbitMQTransfer(requestModel);//rabbit mq

            userRepository.save(user);//mongo db
            return user;}
        else {throw new FeildsEmptyException();}


    }

   /* @Override
    public User loginUser(User user) {
        RequestModel requestModeladmin = new RequestModel();
        requestModeladmin.setEmail(user.getEmail());
        requestModeladmin.setPassword(user.getPassword());
        producer.rabbitMQadminTransfer(requestModeladmin);
        return user;
    }*/
}
