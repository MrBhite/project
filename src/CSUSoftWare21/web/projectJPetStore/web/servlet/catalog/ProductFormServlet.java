package CSUSoftWare21.web.projectJPetStore.web.servlet.catalog;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import CSUSoftWare21.web.projectJPetStore.domain.Itemm;
import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;
import CSUSoftWare21.web.projectJPetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProductFormServlet extends HttpServlet {
    private static final String  PRODUCT_FORM = "/WEB-INF/jsp/catalog/product.jsp";

    private CatalogService catalogService;

    public ProductFormServlet(){
        this.catalogService = new CatalogService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        Productt productt = catalogService.getProduct(productId);
        List<Itemm> itemList = catalogService.getItemListByProduct(productId);

        HttpSession session = req.getSession();
        session.setAttribute("product",productt);
        session.setAttribute("itemList", itemList);
        Account account = (Account)session.getAttribute("account");

        if(account != null){
            HttpServletRequest httpRequest= req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
            String logInfo = logService.logInfo(" ") + strBackUrl + " View the product " + productt;
            logService.insertLogInfo(account.getUsername(), logInfo);
        }

        req.getRequestDispatcher(PRODUCT_FORM).forward(req,resp);
    }
}
