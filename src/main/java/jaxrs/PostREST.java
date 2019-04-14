/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxrs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author c0592682
 */
@Path("post")
@ApplicationScoped
public class PostREST {
    
//    @PersistenceContext(unitName = "rickBook")
    private EntityManager em;
    
    @Inject
    private UserTransaction transaction;
    
    @GET
    @Produces({"application/json"})
    public List<Post> getAll() {
        List<Post> post = em.createQuery("SELECT p FROM Post p").getResultList();
        return post;
    }

    /**
     * Uses a JPA Named Query to return a specific entity as a list.
     * @param id the Product Code (ID)
     * @return 
     */
//    @GET
//    @Path("{id}")
//    @Produces({"application/json"})
//    public List<Post> getOne(@PathParam("id") String id) {
//        Query q = em.createNamedQuery("findPost");
//        q.setParameter("post", id);
//        List<Post> post = q.getResultList();
//        return post;
//    }

    /**
     * Saves an object received as a JSON payload.
     * @param productCode 
     */
    @POST
    @Consumes("application/json")
    public void addOne(Post post) {
        try {
            transaction.begin();
            em.persist(post);
            transaction.commit();
        } catch (Exception ex) {
            Logger.getLogger(PostREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates an existing Product Code based on an incoming JSON payload.
     * @param productCode
     * @param id 
     */
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void editOne(Post post, @PathParam("id") String id) {
        try {
            Query p = em.createQuery("SELECT p FROM ProductCode p WHERE p.prodCode = :id");
            p.setParameter("id", id);
            Post savedP = (Post) p.getSingleResult();
            savedP.setPostContent(post.getPostContent());
            savedP.setTimeOfPost(post.getTimeOfPost());
            transaction.begin();
            em.merge(savedP);
            transaction.commit();
        } catch (Exception ex) {
            Logger.getLogger(PostREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Finds and deletes an existing record using the JPA's find method.
     * @param id 
     */
    @DELETE
    @Path("{id}")
    public void deleteOne(@PathParam("id") String id) {
        try {
            transaction.begin();
            Post found = em.find(Post.class, id);
            em.remove(found);
            transaction.commit();
        } catch (Exception ex) {
            Logger.getLogger(PostREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
