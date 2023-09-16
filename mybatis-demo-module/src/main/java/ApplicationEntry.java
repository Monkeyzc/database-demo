import org.mybatisdemo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ApplicationEntry {
    private static final Logger logger = LogManager.getLogger(ApplicationEntry.class);
    public static void main(String[] args) throws IOException {

        logger.debug("mybatis demo module");

        // 加载mybatis配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sessionFactory.openSession();
        // 执行mapper文件的sql
        List<User> users = sqlSession.selectList("UserMapper.selectAll");

        logger.debug(users);
    }
}
