package CSUSoftWare21.web.projectJPetStore.web.servlet.account;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import CSUSoftWare21.web.projectJPetStore.service.AccountService;
import CSUSoftWare21.web.projectJPetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = req.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String checkcode= req.getParameter("checkCode");
        Account account = accountService.getAccount(userName,password);
        if(account != null){
            HttpServletRequest httpRequest= req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
            String logInfo = logService.logInfo(" ") + strBackUrl + " User login";
            logService.insertLogInfo(account.getUsername(), logInfo);
        }
        if(userName==null||userName.equals("")||password==null||password.equals("")){
            req.setAttribute("errorMsg","Blank Input Detected");
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }else if(account == null){
            req.setAttribute("errorMsg","Wrong Username Or Password");
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }else if(!checkcode.equals(checkCode)){
            req.setAttribute("errorMsg","Wrong CheckCode");
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }else {
            req.getSession().setAttribute("account",account);
            req.getRequestDispatcher(MAIN_FORM).forward(req,resp);
        }
    }
}
