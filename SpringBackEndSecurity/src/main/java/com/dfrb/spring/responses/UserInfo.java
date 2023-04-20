package com.dfrb.spring.responses;

/**
 * @author dfrb@ne
 */

public class UserInfo {
    public UserInfo() {
    
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getRoles() {
        return roles;
    }

    public void setRoles(Object roles) {
        this.roles = roles;
    }
    
    
    private String firstName;
    private String lastName;
    private String userName;	
    private Object roles;
}
