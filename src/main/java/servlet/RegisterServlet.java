package servlet;

import controller.UserController;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "Registration",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {

    UserController uc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        uc = new UserController(req, resp);

        if (uc.estaLogado()) {
            resp.sendRedirect("image");
        } else {
            uc.Dispatch("/register.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        uc = new UserController(req, resp);

        if (uc.estaLogado()) {
            resp.sendRedirect("image");
            return;
        }

        if (uc.Registrar()) {
            resp.sendRedirect("image");
        } else {
            resp.sendRedirect("register");
        }
    }

}
