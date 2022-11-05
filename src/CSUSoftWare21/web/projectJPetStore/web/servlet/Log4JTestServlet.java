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
        System.out.println("��ʼ�� log4j��־������Ϣ");
        /*���������ļ���Ȼ�����configure������
        һ���ļ�����
        ������ȷ���ļ�����*/
        String log4jLocation = config.getInitParameter("log4j-properties");

        ServletContext sc = config.getServletContext();

        if (log4jLocation == null) {
            System.err.println("û�� log4j-properties ��ʼ�����ļ�, ʹ�� BasicConfigurator��ʼ��");
            BasicConfigurator.configure();
        } else {
            String webAppPath = sc.getRealPath("/");
            String log4jProp = webAppPath + log4jLocation;
            File ori = new File(log4jProp);
            System.out.println(log4jProp);
            if (ori.exists()) {
                System.out.println("ʹ��: " + log4jProp+"��ʼ����־������Ϣ");
                PropertyConfigurator.configure(log4jProp);
            } else {
                System.err.println(log4jProp + " �ļ�δ�ҵ�,ʹ�� BasicConfigurator��ʼ��");
                BasicConfigurator.configure();
            }
        }
        super.init(config);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ��¼��ͬ�������Ϣ
        if (logger.isDebugEnabled()){//���ж��������
            logger.debug("This is debug message.");
        }
        if (logger.isInfoEnabled()){
            logger.info("This is info message.");
        }
        //ERROR�������ϼ����log��Ϣ��һ���ᱻ�����
        //����ֻ��logger.isDebugEnabled��logger.isInfoEnabled
        //û��logger.isErrorEnabled����
        logger.error("This is error message.");





    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
