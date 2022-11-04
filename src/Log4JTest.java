import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Log4JTest extends HttpServlet {
    private static Logger logger = Logger.getLogger(Log4JTest.class);


    public Log4JTest() {
    }

    public void init(ServletConfig config) throws ServletException {


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ��¼info�������Ϣ
        logger.info("This is info message.");
        // ��¼error�������Ϣ
        logger.error("This is error message.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}