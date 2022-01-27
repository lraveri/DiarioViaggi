package it.units;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //if(find()!=null)
        if(username.equals("MarcoRaveri") && password.equals("Marco")) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("http://localhost:8081/");
        } else {
            resp.sendRedirect("login/login.jsp");
        }
        

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <title>Servlet BasicServlet</title>");
            out.println("  </head>");
            out.println("  <body>");

            String s = getPreAuthenticatedPrincipalName(request);

            Date d = new Date();
            out.println("    <h1>Servlet BasicServlet at " + s + "</h1>");

            Enumeration<String> params = request.getParameterNames();
            out.println("<h2>Parametri:</h2><ul>");
            while (params.hasMoreElements()) {
                String paramName = params.nextElement();
                out.println("<li>" + paramName + ": ");
                out.println(request.getParameter(paramName) + "</li>");
            }
            out.println("</ul>");

            Enumeration<String> headers = request.getHeaderNames();
            out.println("<h2>Headers:</h2><ul>");
            while (headers.hasMoreElements()) {
                String headerName = headers.nextElement();
                out.println("<li>" + headerName + ": ");
                out.println(request.getHeader(headerName) + "</li>");
            }
            out.println("</ul>");

            out.println("  </body>");
            out.println("</html>");;

        } finally {
            out.close();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet basilare";
    }// </editor-fold>

    protected String getPreAuthenticatedPrincipalName(HttpServletRequest request) {
        return request.getUserPrincipal() == null ? null : request.getUserPrincipal().getName();
    }

}
