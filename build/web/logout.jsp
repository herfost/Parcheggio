<%@page import="configuration.Configuration"%>
<%@page import="utility.Authentication"%>
<%@page import="domain.Utente"%>
<%
    Utente utente = (Utente) session.getAttribute("utente");
    if (!Authentication.isAuthenticated(utente)) {
        response.sendRedirect(request.getContextPath() + "/" + Configuration.getLOGIN_PAGE());
    } else {
        session.setAttribute("utente", null);
        response.sendRedirect(request.getContextPath() + "/" + Configuration.getINDEX_PAGE());
    }
%>