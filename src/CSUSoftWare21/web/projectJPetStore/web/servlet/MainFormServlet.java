package CSUSoftWare21.web.projectJPetStore.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MainFormServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/main.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(MAIN).forward(req,resp);
    }
}
