package CSUSoftWare21.web.projectJPetStore.web.servlet.account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewAccountFormServlet extends HttpServlet {
    private static final String NEW_ACCOUNT_FORM = "/WEB-INF/jsp/account/newAccount.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        req.getRequestDispatcher(NEW_ACCOUNT_FORM).forward(req,resp);


    }
}
