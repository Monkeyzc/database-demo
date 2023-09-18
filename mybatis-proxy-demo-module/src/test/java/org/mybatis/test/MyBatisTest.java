package org.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.mybatisproxydemo.mapper.BrandMapper;
import org.mybatisproxydemo.mapper.OrderItemMapper;
import org.mybatisproxydemo.mapper.OrderMapper;
import org.mybatisproxydemo.mapper.UserMapper;
import org.mybatisproxydemo.pojo.Brand;
import org.mybatisproxydemo.pojo.Order;
import org.mybatisproxydemo.pojo.OrderItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    private static final Logger logger = LogManager.getLogger(MyBatisTest.class);

    @Test
    public void testUserUpdateById() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateById(1, "MonkeyZ");
        sqlSession.commit();
    }

    @Test
    public void testBrandSelectAll() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        logger.debug(brands);
    }

    @Test
    public void testBrandSelectById() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectAllById(1);
        logger.debug(brand);
    }
    @Test
    public void testBrandSelectByCondition() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        String companyNameQueryParam = "%" + companyName + "%";
        String brandNameQueryParam = "%" + brandName + "%";

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        /*
            参数列表 @Param 注解
            Brand brand = mapper.selectByCondition(status, companyNameQueryParam, brandNameQueryParam);
        */

        /*
            利用 Map 传递 参数
                HashMap hashMap = new HashMap();
                hashMap.put("status", status);
                hashMap.put("companyNme", companyNameQueryParam);
                hashMap.put("brandName", brandNameQueryParam);
                Brand brand = mapper.selectByCondition(hashMap);
        */

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyNameQueryParam);
        brand.setBrandName(brandNameQueryParam);
        Brand brand1 = mapper.selectByCondition(brand);

        logger.debug(brand1);
    }

    @Test
    public void testBrandAdd() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setBrandName("iPhone 15");
        brand.setCompanyName("Apple");
        brand.setStatus(1);
        brand.setOrdered(0);
        brand.setDescription("苹果-iPhone15");

        sqlSession.rollback();
        mapper.add(brand);
        sqlSession.commit();
    }

    @Test
    public void testBrandUpdateById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setId(2);
        brand.setBrandName("iPhone 15");
        brand.setCompanyName("Apple");
        brand.setStatus(1);
        brand.setOrdered(1);
        brand.setDescription("苹果-iPhone15");

        mapper.updateById(brand);
        sqlSession.commit();
    }

    @Test
    public void testBrandDeleteById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(2);
        sqlSession.commit();
    }

    @Test
    public void testBrandDeleteByIds() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(3);
        ids.add(8);

        mapper.deleteByIds(ids);
        sqlSession.commit();
    }

    @Test
    public void testOrderAdd() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

            Order order = new Order();
            order.setPayment(100.00);
            order.setStatus(0);
            order.setPaymentType(0);
            // 新增订单
            mapper.addOrder(order);

            // 订单id
            int orderId = order.getId();

            OrderItemMapper mapper1 = sqlSession.getMapper(OrderItemMapper.class);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setGoodsName("iPhone 12");
            orderItem.setGoodsPrice(8000);
            orderItem.setCount("1");
            mapper1.addOrderItem(orderItem);
            // 提交事务
            sqlSession.commit();

        } catch (Error error) {
            logger.error(error);
            // 回滚事务
            sqlSession.rollback();
        }
    }
}
