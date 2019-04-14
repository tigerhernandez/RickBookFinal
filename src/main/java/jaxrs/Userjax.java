/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxrs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author c0592682
 */
@NamedQueries (
    @NamedQuery(name = "findUser", query = "SELECT u FROM User WHERE u.userId = :userId"))
@Entity
@Table(name = "USER")
public class Userjax {
    @Id
    @Column(name = "USER_ID")
    private String userId;
     @Column(name = "USER_NAME")
    private String userName;
     @Column(name = "USER_BIO")
    private String userBio;
     
//    @Column(name = "profilePicture")
//   private  profilePicture

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
