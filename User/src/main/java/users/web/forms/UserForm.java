package users.web.forms;

import users.UsersEntity;

public class UserForm
{
    private int userId;
    private String firstName;
    private String surName;
    private String number;

    public void initFromUser(UsersEntity st) {
        this.userId = st.getUserId();
        this.firstName = st.getFirstName();
        this.surName = st.getSurName();
        this.number = st.getNumber();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
