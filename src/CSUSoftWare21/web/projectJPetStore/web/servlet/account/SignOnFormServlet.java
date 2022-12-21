package CSUSoftWare21.web.projectJPetStore.web.servlet.account;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import CSUSoftWare21.web.projectJPetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOnFormServlet extends HttpServlet {
    private static final String SIGN_ON_FORM = "/WEB-INF/jsp/account/signOn.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
    }
}
