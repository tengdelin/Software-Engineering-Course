package java1;

public class USER_TABLE {
    private String name=null;
    private String phone=null;
    private String email=null;
    private String password=null;

    public USER_TABLE(String name ,String phone,String password) {
        this.name=name;
        this.phone=phone;
        this.password=password;
    }

    public USER_TABLE(String name, String phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
