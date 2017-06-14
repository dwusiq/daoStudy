package com.wusiq.db;

import com.wusiq.db.impl.DbConnServiceMySqlImpl;

/**
 * 数据库连接工厂类
 */
public class DbConnFactory {
    //获取mysql的数据库连接
    public static DbConnService getMysqlDbC(){
        return new DbConnServiceMySqlImpl();
    }
}
