package CSUSoftWare21.web.projectJPetStore.web.servlet;
/*1031 这里一直报错，按提示导入了javax里的*/
/*import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
*/
import CSUSoftWare21.web.projectJPetStore.domain.Productt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainFormServlet extends HttpServlet {
    private static final String MAIN_FORM = "/WEB-INF/jsp/catalog/main.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Productt productt = new Productt();
        System.out.println(productt.getName());
        req.getRequestDispatcher(MAIN_FORM).forward(req,resp);
    }
}
