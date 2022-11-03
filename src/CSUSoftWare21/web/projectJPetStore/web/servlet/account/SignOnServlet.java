package CSUSoftWare21.web.projectJPetStore.web.servlet.account;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import CSUSoftWare21.web.projectJPetStore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignOnServlet extends HttpServlet {
    private static final String MAIN_FORM = "/WEB-INF/jsp/catalog/main.jsp";
    private static final String SIGN_ON_FORM = "/WEB-INF/jsp/account/signOn.jsp";

    private AccountService accountService;

    public SignOnServlet(){
        this.accountService = new AccountService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = accountService.getAccount(userName,password);
        if(account == null){
            req.setAttribute("errorMsg","Invalid username or password.  Signon failed.");
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }else {
            req.getSession().setAttribute("account",account);
            req.getRequestDispatcher(MAIN_FORM).forward(req,resp);
        }
    }
}
