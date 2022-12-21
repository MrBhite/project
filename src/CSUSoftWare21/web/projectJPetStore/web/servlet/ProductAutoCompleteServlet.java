package CSUSoftWare21.web.projectJPetStore.web.servlet;

import CSUSoftWare21.web.projectJPetStore.domain.Productt;
import CSUSoftWare21.web.projectJPetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class ProductAutoCompleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword=req.getParameter("keyword");
        CatalogService service=new CatalogService();
        List<Productt>producttList=service.searchProductList(keyword);

        String result=JSON.toJSONString(producttList);
        System.out.println(result);


        resp.setContentType("text/json");
        resp.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter out=resp.getWriter();
        out.println(result);
    }
}
