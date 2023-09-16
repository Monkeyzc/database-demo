import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatisproxydemo.mapper.UserMapper;
import org.mybatisproxydemo.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ApplicationEntryMybatisProxy {

    private static final Logger logger = LogManager.getLogger(ApplicationEntryMybatisProxy.class);
    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectAll();
        logger.debug(users);

        User user = mapper.selectById(1);
        logger.debug(user);

        sqlSession.close();

    }
}
