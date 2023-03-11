package mishra.sidharth.userauthentication.requestedmodel;



public class RequestModel {
    private String email;
    private String password;


    public RequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RequestModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
