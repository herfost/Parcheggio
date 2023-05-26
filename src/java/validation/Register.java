package validation;

import configuration.Configuration;
import domain.CredenzialiUtente;
import domain.Utente;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import service.CredenzialiUtenteFacadeREST;
import service.UtenteFacadeREST;

@ApplicationPath("/register")
@Path("")
public class Register extends Application {

    @EJB
    private UtenteFacadeREST utenteFacadeREST;
    @EJB
    private CredenzialiUtenteFacadeREST credenzialiUtenteFacadeREST;

    @POST
    public Response register(
            @FormParam("username") String username, @FormParam("password") String password,
            @FormParam("phone") String phone, @FormParam("email") String email,
            @Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException {
        if (isValidUsername(username)) {
            CredenzialiUtente credenzialiUtente = new CredenzialiUtente(username, password);
            Utente utente = new Utente(username, phone, email);

            credenzialiUtenteFacadeREST.create(credenzialiUtente);
            utenteFacadeREST.create(utente);

            HttpSession session = request.getSession(true);
            session.setAttribute("utente", utente);

            response.sendRedirect(request.getContextPath() + "/" + Configuration.getINDEX_PAGE());
            return null;
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private boolean isValidUsername(String username) {
        CredenzialiUtente credenzialiUtente = credenzialiUtenteFacadeREST.find(username);
        return credenzialiUtente == null;
    }
}
