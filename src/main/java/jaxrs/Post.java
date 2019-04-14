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
@NamedQueries(
    @NamedQuery(name = "findPost", query = "SELECT p FROM postId p WHERE p.post = :post"))
@Entity
@Table(name = "POST")
public class Post {
    @Id
    @Column(name = "POST_ID")
    private int postId;
    @Column(name = "POST_CONTENT")
    private String postContent;
    @Column(name = "TIME_OF_POST")
    private String timeOfPost;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getTimeOfPost() {
        return timeOfPost;
    }

    public void setTimeOfPost(String timeOfPost) {
        this.timeOfPost = timeOfPost;
    }
    
    
}
