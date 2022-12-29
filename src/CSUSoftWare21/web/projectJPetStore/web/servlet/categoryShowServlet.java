package CSUSoftWare21.web.projectJPetStore.web.servlet;

import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class categoryShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        System.out.println("categotyId= "+categoryId);
        CatalogService catelogService = new CatalogService();
        List<Productt> productList = catelogService.getProductListByCategory(categoryId);
        String response = "ProductID            Name\n";
        int i = 0 ;
        for(;i<productList.size();i++)
        {
            Productt product = productList.get(i);
            response+=product.getProductId()+"        "+product.getName()+"\n";

        }
        System.out.println(response);
        resp.setContentType("text/xml");
        PrintWriter out = resp.getWriter();
        out.write(response);
    }
}
