package JDBCDemo;

import JDBCDemo.models.User;

import java.sql.*;

public class main {
    public static void main(String[] args) throws Throwable {
        System.out.println("Hello world");

        // 注册 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/testdb?useSSL=false";
        String username = "root";
        String password = "zhaofeifsp";
        // 连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        // 创建sql语句
        Statement statement = connection.createStatement();
        // 查询
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            User user = new User(id, name);
            System.out.println(user);
        }

        // 更新 防止sql注入
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET name = ? WHERE id = ?");
        preparedStatement.setString(1, "WangWu");
        preparedStatement.setInt(2, 1);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);

        statement.close();
        connection.close();
    }


}
