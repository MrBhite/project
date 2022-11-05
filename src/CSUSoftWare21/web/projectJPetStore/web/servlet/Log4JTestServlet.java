package CSUSoftWare21.web.projectJPetStore.web.servlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class Log4JTestServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(Log4JTestServlet.class);


    public Log4JTestServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化 log4j日志设置信息");
        /*读出配置文件，然后调用configure函数。
        一、文件在哪
        二、正确的文件类型*/
        String log4jLocation = config.getInitParameter("log4j-properties");

        ServletContext sc = config.getServletContext();

        if (log4jLocation == null) {
            System.err.println("没有 log4j-properties 初始化的文件, 使用 BasicConfigurator初始化");
            BasicConfigurator.configure();
        } else {
            String webAppPath = sc.getRealPath("/");
            String log4jProp = webAppPath + log4jLocation;
            File ori = new File(log4jProp);
            System.out.println(log4jProp);
            if (ori.exists()) {
                System.out.println("使用: " + log4jProp+"初始化日志设置信息");
                PropertyConfigurator.configure(log4jProp);
            } else {
                System.err.println(log4jProp + " 文件未找到,使用 BasicConfigurator初始化");
                BasicConfigurator.configure();
            }
        }
        super.init(config);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 记录不同级别的信息
        if (logger.isDebugEnabled()){//加判断提高性能
            logger.debug("This is debug message.");
        }
        if (logger.isInfoEnabled()){
            logger.info("This is info message.");
        }
        //ERROR及其以上级别的log信息是一定会被输出的
        //所以只有logger.isDebugEnabled和logger.isInfoEnabled
        //没有logger.isErrorEnabled方法
        logger.error("This is error message.");





    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
