package iaulife.entity;


public class User  {
    private String mail;
    private String password;
    private int roleId;

    public User(){}
    public User(String mail, String password, int roleId) {
        this.mail = mail;
        this.password = password;
        this.roleId = roleId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }



}
