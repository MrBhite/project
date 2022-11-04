package CSUSoftWare21.web.projectJPetStore;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Log4JTest extends HttpServlet {
    /*1.得到记录器*/
    private static Logger logger = Logger.getLogger(Log4JTest.class);


    public Log4JTest() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 记录info级别的信息
        logger.info("info message.");
        // 记录error级别的信息
        logger.error("error message.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

