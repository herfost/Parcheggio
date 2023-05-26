/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Permesso;
import domain.Utente;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Joe Biden
 */
@Stateless
@Path("domain.permesso")
public class PermessoFacadeREST extends AbstractFacade<Permesso> {

    @EJB
    private UtenteFacadeREST utenteFacadeREST;

    @PersistenceContext(unitName = "ApplicazioneParcheggioPU")
    private EntityManager em;

    public PermessoFacadeREST() {
        super(Permesso.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Permesso entity) {
        super.create(entity);
    }

    @POST
    @Path("byForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createByForm(@FormParam("targa") String plateNumber, @Context HttpServletRequest request) {
        Utente utente = (Utente) request.getSession().getAttribute("utente");
        Permesso permesso = new Permesso(plateNumber, LocalDateTime.now(), LocalDateTime.now().plusDays(7), utente);
        utente.getPermessi().add(permesso);
        utenteFacadeREST.edit(utente.getUsername(), utente);
        request.getSession().setAttribute("utente", utenteFacadeREST.find(utente.getUsername()));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Permesso entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Permesso find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Permesso> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Permesso> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
