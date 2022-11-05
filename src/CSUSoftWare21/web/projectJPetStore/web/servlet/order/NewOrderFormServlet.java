package CSUSoftWare21.web.projectJPetStore.web.servlet.order;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import CSUSoftWare21.web.projectJPetStore.domain.Cartt;
import CSUSoftWare21.web.projectJPetStore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderFormServlet extends HttpServlet {
    private static final String NEW_ORDER_FORM = "/WEB-INF/jsp/order/newOrder.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cartt cart = (Cartt) session.getAttribute("cart");
        Account account = (Account) session.getAttribute("account");

        Order order = new Order();
        order.initOrder(account,cart);
        session.setAttribute("order",order);

        req.getRequestDispatcher(NEW_ORDER_FORM).forward(req,resp);
    }
}
