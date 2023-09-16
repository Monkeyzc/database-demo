package org.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.mybatisproxydemo.mapper.BrandMapper;
import org.mybatisproxydemo.pojo.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private static final Logger logger = LogManager.getLogger(MyBatisTest.class);

    @Test
    public void testSelectAll() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        logger.debug(brands);
    }

    @Test
    public void testSelectById() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectAllById(1);
        logger.debug(brand);
    }

}
