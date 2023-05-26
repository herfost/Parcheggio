<%@page import="utility.Authentication"%>
<%@page import="configuration.Configuration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.Utente"%>


<%
    Utente utente = (Utente) session.getAttribute("utente");
    if (!Authentication.isAuthenticated(utente)) {
        response.sendRedirect(request.getContextPath() + "/" + Configuration.getLOGIN_PAGE());
    } else {
%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdn.tailwindcss.com"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parcheggio Index</title>
    </head>
    <body class="bg-gray-50 dark:bg-gray-900">
        <nav class="bg-white border-gray-200 dark:bg-gray-900">
            <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
                <a class="flex items-center">
                    <img class="h-8 mr-3" src=<%= Configuration.getLOGO_URL()%> />
                    <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Retefagioli</span>
                </a>
                <button data-collapse-toggle="navbar-default" type="button" class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-default" aria-expanded="false">
                    <span class="sr-only">Open main menu</span>
                    <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path></svg>
                </button>
                <div class="hidden w-full md:block md:w-auto" id="navbar-default">
                    <ul class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
                        <li>
                            <a class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-blue-500" href=<%= request.getContextPath() + "/" + Configuration.getPERMESSI_PAGE()%> >
                                Permessi
                            </a>

                        </li>
                        <li>
                            <a class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-blue-500" href=<%= request.getContextPath() + "/" + Configuration.getLOGOUT_PAGE()%> >
                                Logout
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>

<% }%>