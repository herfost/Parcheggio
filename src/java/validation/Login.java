package validation;

import configuration.Configuration;
import domain.CredenzialiUtente;
import domain.Utente;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.CredenzialiUtenteFacadeREST;
import service.UtenteFacadeREST;

@javax.ws.rs.ApplicationPath("/login")
@Path("")
public class Login extends Application {

    @EJB
    private UtenteFacadeREST utenteFacadeREST;
    @EJB
    private CredenzialiUtenteFacadeREST credenzialiUtenteFacadeREST;

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@QueryParam("username") String username, @QueryParam("password") String password, @Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException {
        if (isValidLogin(username, password)) {
            HttpSession session = request.getSession(true);

            Utente utente = utenteFacadeREST.find(username);
            session.setAttribute("utente", utente);
            response.sendRedirect(request.getContextPath() + "/" + Configuration.getREDIRECT_FROM_LOGIN_PAGE());
            return null;
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private boolean isValidLogin(String username, String password) {
        CredenzialiUtente credenzialiUtente = credenzialiUtenteFacadeREST.find(username);
        return credenzialiUtente != null && credenzialiUtente.getPassword().equals(password);
    }
}
