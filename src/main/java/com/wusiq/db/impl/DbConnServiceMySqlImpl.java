package com.wusiq.db.impl;

import com.wusiq.db.DbConnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * mysql的数据库连接服务
 */
public class DbConnServiceMySqlImpl implements DbConnService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbConnServiceMySqlImpl.class);
    private static String DBC_URL=null;
    private static String DBC_USER=null;
    private static String DBC_PWD=null;
    private static String DBC_DRIVER_NAME=null;
    private static Connection conn;
    private static ResourceBundle rb = ResourceBundle.getBundle("DbConfig", Locale.ENGLISH);

    //单例，所以在类加载的时候直接获取连接
    static {
        DBC_URL=rb.getString("mysql_dbc_url");
        DBC_USER=rb.getString("mysql_dbc_user");
        DBC_PWD=rb.getString("mysql_dbc_pwd");
        DBC_DRIVER_NAME = rb.getString("mysql_dbc_driver_name");

        try {
            Class.forName(DBC_DRIVER_NAME);
            conn = DriverManager.getConnection(DBC_URL,DBC_USER,DBC_PWD);
        } catch (ClassNotFoundException e) {
            LOGGER.error("获取Mysql数据库连接驱动失败",e);
        } catch (SQLException e) {
            LOGGER.error("获取Mysql数据库连接失败",e);
        }
    }

    @Override
    public Connection getConn() {
        return conn;
    }
/*    public static void main(String args[]){
        DbConnServiceMySqlImpl di = new DbConnServiceMySqlImpl();
        Connection conn = di.getConn();
        System.out.println(conn);

    }*/
}
