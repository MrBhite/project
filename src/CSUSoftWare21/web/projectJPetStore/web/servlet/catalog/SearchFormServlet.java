package CSUSoftWare21.web.projectJPetStore.web.servlet.catalog;

import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchFormServlet extends HttpServlet {
    private static final String  SEARCH_FORM = "/WEB-INF/jsp/catalog/search.jsp";

    CatalogService catalogService;

    public  SearchFormServlet(){
        this.catalogService = new CatalogService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Productt> productList  = catalogService.searchProductList(keyword);
        req.getSession().setAttribute("productList",productList);

        req.getRequestDispatcher(SEARCH_FORM).forward(req,resp);
    }
}
