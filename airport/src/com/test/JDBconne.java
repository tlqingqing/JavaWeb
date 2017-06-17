package com.test;

import java.sql.*;


public final class JDBconne 
{
    
  private static Connection connection = null;
  
      public static Connection getConnetion()
      {	
          String url = "jdbc:mysql://localhost:3306/testhangban?characterEncoding=gb2312";
          String user = "root";
          String password = "fan3394";

                    try
                    {
                            // 娉ㄩ���ゆ�烽���ゆ�烽���ゆ��
                            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                            // ���ゆ�烽���ゆ�烽���ゆ�蜂剑���ゆ�烽��锟�
                            connection = DriverManager.getConnection(url, user, password);
                    }
                    catch (SQLException e)
                    {
                    }
                    return connection;
      }
      public static void closeConnection()
	{
		try
		{
			if(connection != null) connection.close();
		}
		catch (SQLException e)
		{
		}
	}
    
}
