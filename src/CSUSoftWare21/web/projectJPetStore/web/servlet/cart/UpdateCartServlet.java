package CSUSoftWare21.web.projectJPetStore.web.servlet.cart;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import CSUSoftWare21.web.projectJPetStore.domain.CartItem;
import CSUSoftWare21.web.projectJPetStore.domain.Cartt;
import CSUSoftWare21.web.projectJPetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

public class UpdateCartServlet extends HttpServlet {
    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cartt cart = (Cartt) session.getAttribute("cart");

        if(cart==null){
            cart = new Cartt();
        }

        Iterator<CartItem> cartItemIterator = cart.getCartItems();
        while (cartItemIterator.hasNext()) {
            CartItem cartItem = (CartItem) cartItemIterator.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                String quantityStr = req.getParameter(itemId);
                int quantity = Integer.parseInt(quantityStr);
                cart.setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItemIterator.remove();
                }
            } catch (Exception e) {
                //ignore parse exceptions on purpose
            }
        }
        Account account = (Account)session.getAttribute("account");

        if(account != null){
            HttpServletRequest httpRequest= req;
            String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
            String logInfo = logService.logInfo(" ") + strBackUrl + " Update the number of items in the cart";
            logService.insertLogInfo(account.getUsername(), logInfo);
        }
        req.getRequestDispatcher(CART_FORM).forward(req,resp);
    }
}
