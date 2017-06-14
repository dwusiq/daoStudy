package com.wusiq.db;

import java.sql.Connection;

/**
 * 数据库连接接口
 */
public interface DbConnService {
    Connection getConn();
}
