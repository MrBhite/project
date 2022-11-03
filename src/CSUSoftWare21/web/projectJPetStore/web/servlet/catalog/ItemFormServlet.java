package CSUSoftWare21.web.projectJPetStore.web.servlet.catalog;

import CSUSoftWare21.web.projectJPetStore.domain.Itemm;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ItemFormServlet extends HttpServlet {
    private static final String ITEM_FORM = "/WEB-INF/jsp/catalog/item.jsp";

    CatalogService catalogService;

    public ItemFormServlet(){
        this.catalogService = new CatalogService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemID = req.getParameter("itemID");
        Itemm item = catalogService.getItem(itemID);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("item",item);
        req.getRequestDispatcher(ITEM_FORM).forward(req,resp);
    }
}
