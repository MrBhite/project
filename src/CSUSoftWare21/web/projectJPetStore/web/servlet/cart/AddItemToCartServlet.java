package CSUSoftWare21.web.projectJPetStore.web.servlet.cart;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import CSUSoftWare21.web.projectJPetStore.domain.Cartt;
import CSUSoftWare21.web.projectJPetStore.domain.Itemm;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;
import CSUSoftWare21.web.projectJPetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddItemToCartServlet extends HttpServlet {
    private static final String CART_FORM = "cart";
    private CatalogService catalogService;

    public AddItemToCartServlet(){
        this.catalogService = new CatalogService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String workingItemId = (String) req.getParameter("workingItemId");
        Account account;
        HttpSession session = req.getSession();
        Cartt cart = (Cartt) session.getAttribute("cart");
        account = (Account)session.getAttribute("account");
        if(cart==null){
            cart = new Cartt();
        }

        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
            if(account != null){
                HttpServletRequest httpRequest= (HttpServletRequest) req;
                String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                Itemm item = catalogService.getItem(workingItemId);
                String logInfo = logService.logInfo(" ") + strBackUrl + " " + item + "count+1 ";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }
        } else {
            // isInStock is a "real-time" property that must be updated
            // every time an item is added to the cart, even if other
            // item details are cached.
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Itemm item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
            session.setAttribute("cart",cart);
            if(account != null){
                HttpServletRequest httpRequest= req;
                String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " Add the product " + item + " to the cart";
                logService.insertLogInfo(account.getUsername(), logInfo);
            }
        }
        resp.sendRedirect(CART_FORM);
    }
}
