/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.ImageController;
import controller.UserController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(
        name = "Feed",
        urlPatterns = {"/feed"}
)
public class FeedServlet extends HttpServlet {
    
    UserController uc;
    ImageController ic;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        uc = new UserController(req, resp);

        if (!uc.estaLogado()) {
            resp.sendRedirect("login");
            return;
        }

        ic = new ImageController(req, resp);

        req.setAttribute("user", uc.getLoggedUser());
        req.setAttribute("images", ic.getAllPhotos());

        ic.Dispatch("/feed.jsp");
    }
}
