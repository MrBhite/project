package CSUSoftWare21.web.projectJPetStore.web.servlet.cart;

import CSUSoftWare21.web.projectJPetStore.domain.Cartt;
import CSUSoftWare21.web.projectJPetStore.domain.Itemm;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddItemToCartServlet extends HttpServlet {
    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String workingItemId = (String) req.getParameter("workingItemId");
        HttpSession session = req.getSession();
        Cartt cart = (Cartt) session.getAttribute("cart");

        if(cart==null){
            cart = new Cartt();
        }

        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
        } else {
            // isInStock is a "real-time" property that must be updated
            // every time an item is added to the cart, even if other
            // item details are cached.
            CatalogService catalogService = new CatalogService();
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Itemm item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
        }

        session.setAttribute("cart",cart);
        req.getRequestDispatcher(CART_FORM).forward(req,resp);
    }


}
