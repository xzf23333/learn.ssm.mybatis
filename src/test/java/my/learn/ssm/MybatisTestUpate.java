package my.learn.ssm;


import my.learn.ssm.pojo.News;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisTestUpate {

    private static final Logger logger = LoggerFactory.getLogger(MybatisTestUpate.class);
    @Test
    public static void main(String[] args) throws IOException {


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        News news =new News();
        news.setTitle("rr");
        news.setContent("rr");
        news.setId(4);
        session.update("update",news);


        listAll(session);
        session.commit();
        session.close();

    }

    private static void listAll(SqlSession session) {

        List<News> ns = session.selectList("listNews");

        for (News n : ns) {
            logger.info(n.toString());
        }
    }




}
