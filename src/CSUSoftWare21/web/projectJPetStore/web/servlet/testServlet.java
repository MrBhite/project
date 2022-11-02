package CSUSoftWare21.web.projectJPetStore.web.servlet;

import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.domain.Sequence;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class testServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sequence sequence = new Sequence();
        System.out.println(sequence.getName());

        Productt productt = new Productt();
        System.out.println(productt.getName());
        req.getRequestDispatcher("/WEB-INF/jsp/catalog/main.jsp").forward(req,resp);
    }
}
