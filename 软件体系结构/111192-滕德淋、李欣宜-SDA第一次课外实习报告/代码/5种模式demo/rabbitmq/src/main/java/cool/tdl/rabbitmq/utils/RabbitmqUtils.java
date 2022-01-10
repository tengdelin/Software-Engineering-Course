package cool.tdl.rabbitmq.utils;

import com.rabbitmq.client.*;

/**
 * @Author li
 * @Date 2021/12/13 15:28
 * @description 封装工具类
 * @Version 1.0
 */

public class RabbitmqUtils {
    private static ConnectionFactory factory;
    static{
        factory= new ConnectionFactory();
        //设置连接属性
        factory.setHost("112.124.33.37");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("admin");
        factory.setPassword("admin");
    }

    //提供连接对象的方法
    public static Connection getConnection(){
        try{
            Connection connection=factory.newConnection();
            return connection;
        }catch (Exception e){
            e.printStackTrace();;
            System.out.println("error");
            return null;
        }
    }

    //提供关闭连接的方法
    public static void closeConnection(Connection conn,Channel channel){
        if(channel!=null&& channel.isOpen()){
            try{
                channel.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
