import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


public class Log4JInit extends HttpServlet {
    public Log4JInit(){
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
            if (ori.exists()) {
                System.out.println("ʹ��: " + log4jProp+"��ʼ����־������Ϣ");
                PropertyConfigurator.configure(log4jProp);
            } else {
                System.err.println(log4jProp + " �ļ�δ�ҵ��� ʹ�� BasicConfigurator��ʼ��");
                BasicConfigurator.configure();
            }
        }
        super.init(config);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
