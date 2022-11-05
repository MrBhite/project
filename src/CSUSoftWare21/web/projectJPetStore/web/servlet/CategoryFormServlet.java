package CSUSoftWare21.web.projectJPetStore.web.servlet;

import CSUSoftWare21.web.projectJPetStore.domain.Category;
import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.service.CatelogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CategoryFormServlet extends HttpServlet {
    private static final String CATEGORY_FORM = "/WEB-INF/jsp/catalog/category.jsp";

    private CatelogService catelogService;

    public CategoryFormServlet(){
        this.catelogService = new CatelogService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Productt productt = new Productt();
        System.out.println(productt.getName());
        String categoryId = req.getParameter("categoryId");
        Category category = catelogService.getCategory(categoryId);
        /*System.out.println(categoryId);
        System.out.println(category);*/
        List<Productt> producttList = catelogService.getProductListByCategory(categoryId);
        System.out.println(producttList);
        HttpSession session = req.getSession();
        session.setAttribute("category",category);
        session.setAttribute("productList", producttList);
        req.getRequestDispatcher(CATEGORY_FORM).forward(req,resp);
    }
}
