package main.java.iaulife.entity;

public class User {
    private String mail;
    private String password;
    private int roleId;
    private int personId;

    public User(String mail, String password, int roleId, int personId) {
        this.mail = mail;
        this.password = password;
        this.roleId = roleId;
        this.personId = personId;
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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
