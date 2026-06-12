package controller;

import model.claseUsuario;
import service.metodosUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletVerificar", urlPatterns = {"/login"})
public class ServletVerificar extends HttpServlet {
    private metodosUsuario metodosUsuario = new metodosUsuario();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreusuario = request.getParameter("nombreusuario");
        String password = request.getParameter("password");

        claseUsuario usuario = metodosUsuario.validarUsuario(nombreusuario, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            session.setAttribute("idusuario", usuario.getIdusuario());
            session.setAttribute("nombreusuario", usuario.getNombreusuario());
            session.setAttribute("rol", usuario.getRol());
            response.sendRedirect("menuPrincipal.jsp");
        } else {
            request.setAttribute("mensaje", "Usuario o password incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
//hola señor