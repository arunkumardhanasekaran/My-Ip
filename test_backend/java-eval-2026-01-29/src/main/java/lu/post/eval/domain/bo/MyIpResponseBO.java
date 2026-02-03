package lu.post.eval.domain.bo;

public class MyIpResponseBO {
    private String myIp;

    // Default constructor
    public MyIpResponseBO() {}

    // Constructor with parameter
    public MyIpResponseBO(String myIp) {
        this.myIp = myIp;
    }

    // Getter and Setter
    public String getMyIp() {
        return myIp;
    }

    public void setMyIp(String myIp) {
        this.myIp = myIp;
    }
}