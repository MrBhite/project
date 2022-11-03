package CSUSoftWare21.web.projectJPetStore.web.servlet.catalog;

import CSUSoftWare21.web.projectJPetStore.domain.Category;
import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CategoryFormServlet extends HttpServlet {
    private static final String CATEGORY_FORM = "/WEB-INF/jsp/catalog/category.jsp";

    private CatalogService catalogService;

    public CategoryFormServlet(){
        this.catalogService = new CatalogService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        Category category = catalogService.getCategory(categoryId);
        List<Productt> producttList = catalogService.getProductListByCategory(categoryId);

        HttpSession session = req.getSession();
        session.setAttribute("category",category);
        session.setAttribute("producttList", producttList);
        req.getRequestDispatcher(CATEGORY_FORM).forward(req,resp);
    }
}
