/*
package CSUSoftWare21.web.projectJPetStore.persistence;

import CSUSoftWare21.web.projectJPetStore.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //1.加载核心配置文件
        //定义配置文件路径
        String resource = "mybatis-config.xml";
        //获取InputStream
        //Resources是mybatis提供的资源加载类
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //通过SqlSessionFactoryBuilder对象的build方法把流传进来
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象,用它执行sql语句
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.执行sql
        List<Account> accounts=sqlSession.selectList("test.selectAll");

        System.out.println(accounts);

        sqlSession.close();
    }
}
*/