package com.test;

import java.sql.*;


public final class JDBconne 
{
    
  private static Connection connection = null;
  
      public static Connection getConnetion()
      {	
          String url = "jdbc:mysql://localhost:3306/testhangban";
          String user = "root";
          String password = "fan3394";

                    try
                    {
                            // ע������
                            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                            // ������Ӷ���
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
