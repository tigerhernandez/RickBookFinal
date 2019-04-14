/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxrs;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author c0592682
 */
//@Path("post")
//@ApplicationScoped
public class CommentREST {
    
//    @PersistenceContext(unitName = "rickAndMorty")
//    private EntityManager em;
//    
//    @Inject
//    private UserTransaction transaction;
//    
//    @GET
//    @Produces({"application/json"})
//    public List<Comment> getAll() {
//        List<Comment> comment = em.createQuery("SELECT c FROM Comment c").getResultList();
//        return comment;
//    }
    
}
