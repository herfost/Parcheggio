<%@page import="utility.Authentication"%>
<%@page import="libCrittografia.Rsa"%>
<%@page import="certificazione.EnteCertificazione"%>
<%@page import="configuration.Configuration"%>
<%@page import="java.io.IOException"%>
<%@page import="libCrittografia.EccezioneCripto"%>
<%@page import="libCrittografia.Aes"%>
<%@page import="utility.ObjectsBytes"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.security.NoSuchAlgorithmException"%>
<%@page import="domain.Permesso"%>
<%@page import="java.util.List"%>
<%@page import="domain.Utente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Autenticazione utente tramite sesssione
    Utente utente = (Utente) session.getAttribute("utente");
    if (!Authentication.isAuthenticated(utente)) {
        response.sendRedirect(request.getContextPath() + "/index.html");
    } else {
        try {
            List<Permesso> permessi = utente.getPermessi();
%>

<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdn.tailwindcss.com"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Permessi</title>
    </head>
    <body>
        <nav class="bg-white border-gray-200 dark:bg-gray-900">
            <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
                <a class="flex items-center">
                    <img class="h-8 mr-3" src=<%= Configuration.getLOGO_URL()%> />
                </a>
                <button data-collapse-toggle="navbar-default" type="button" class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-default" aria-expanded="false">
                    <span class="sr-only">Open main menu</span>
                    <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path></svg>
                </button>
                <div class="hidden w-full md:block md:w-auto" id="navbar-default">
                    <ul class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
                        <li>
                            <a class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-blue-500" href=<%= request.getContextPath() + "/" + Configuration.getINDEX_PAGE()%> >
                                Homepage
                            </a>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>
        <div class="flex flex-col mx-auto md:h-screen lg:py-0">
            <%-- Form permessi --%>
            <% if (permessi.size() < 3) {%>
            <div class="w-full bg-white shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
                <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                    <form id="permesso-form"action=<%= request.getContextPath() + "/resources/domain.permesso/byForm"%> method="post" class="space-y-4 md:space-y-6">
                        <div><input type="text" name="targa" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Targa" required=""></div>
                        <div><input type="submit" name="RichiediPermesso" value="Richiedi Permesso" class="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"></div>
                    </form>
                </div>
            </div>
        </form>

        <% } %>

        <%-- Elenco permessi --%>
        <div id="qr-permessi">
            <% for (Permesso permesso : permessi) {
                    String permessoFirmato;
                    try {
                        permessoFirmato = EnteCertificazione.getInstance().firmaDigitalmente(permesso);
                    } catch (EccezioneCripto ex) {
                        permessoFirmato = EnteCertificazione.getInstance().getPermessoControllo(permesso);
                    } catch (IOException ex) {
                        permessoFirmato = EnteCertificazione.getInstance().getPermessoControllo(permesso);
                    }
            %>
            <div id=<%= "qrcode-permesso-" + permesso.getId()%>  >
                <img src=<%= request.getContextPath() + "/qrcode/" + permessoFirmato%> id=<%= "qrcode-" + permesso.getId()%> width="125" height="125" alt=<%= "qr-permesso-" + permesso.getId()%>>
                <p><b>Id</b>: <%= permesso.getId()%></p>
                <p><b>Targa</b>: <%= permesso.getPlateNumber()%></p>
                <p><b>Data rilascio</b>: <%= permesso.getReleaseDate().format(DateTimeFormatter.ISO_DATE)%></p>
                <p><b>Data scadenza</b>: <%= permesso.getExpirationDate().format(DateTimeFormatter.ISO_DATE)%></p>
            </div>  
            <div>

                <p><b>Permesso Firmato Digitalmente</b>: <%= permessoFirmato%></p>
                <p><b>Permesso Controllo</b>: <%= EnteCertificazione.getInstance().contenutoFirma(permessoFirmato)%></p>
                <p><b>Dati utente</b>: <%= EnteCertificazione.getInstance().getDatiUtente(permessoFirmato)%></p>
            </div>

            <% }%>
        </div>
    </div>
</body>
</html>
<%} catch (EccezioneCripto ex) {
            ex.printStackTrace(System.out);
        }
    }
%>
