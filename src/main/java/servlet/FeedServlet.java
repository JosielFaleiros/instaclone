/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.service.ImagemService;

/**
 *
 * @author lucas
 */
@WebServlet(
        name = "Feed",
        urlPatterns = {"/feed"}
)
public class FeedServlet extends HttpServlet {

    Context context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        if (!context.estaLogado()) {
            resp.sendRedirect("login");
            return;
        }

        req.setAttribute("user", context.getLoggedUser());
        req.setAttribute("images", ImagemService.getAllPhotos());
        context.Dispatch("/feed.jsp");

    }

}