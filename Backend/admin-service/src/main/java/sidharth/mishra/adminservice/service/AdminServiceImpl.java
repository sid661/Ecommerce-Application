package sidharth.mishra.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sidharth.mishra.adminservice.domain.Admin;
import sidharth.mishra.adminservice.exception.AdminNotFoundException;
import sidharth.mishra.adminservice.exception.FeildsEmptyException;
import sidharth.mishra.adminservice.rabbitMq.Producer;
import sidharth.mishra.adminservice.repository.AdminRepository;
import sidharth.mishra.adminservice.requestmodel.RequestModel;


@Component
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private Producer producer;

    @Override
    public Admin registeradmin(Admin admin) throws FeildsEmptyException {
        if(admin==null){
            throw new FeildsEmptyException();
        }else{
            RequestModel requestModel = new RequestModel();
            requestModel.setEmail(admin.getEmail());
            requestModel.setPassword(admin.getPassword());
            requestModel.setCompanyName(admin.getCompanyName());
            producer.rabbitMQTransfer(requestModel);
            return adminRepository.save(admin);
        }}

    @Override
    public Admin loginAdmin(Admin admin) throws AdminNotFoundException {
        String email= admin.getEmail();
        String password = admin.getPassword();
        Admin check = new Admin();
        check = adminRepository.findByEmailAndPassword(email,password);
        if(check==null){throw new AdminNotFoundException();}
        else{return check;
        }




    }
}
