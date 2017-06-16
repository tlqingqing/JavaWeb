package com.servlet;

import java.io.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminServlet extends HttpServlet 
{
    
       public void init() throws ServletException
       {
           super.init();
       }
       public void destroy()
       {
        super.destroy();
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    ///public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {

        ServletConfig config=getServletConfig();
        //创建ServletConfig对象
        String value=config.getInitParameter("name");
        //获得路径
        Properties properties=new Properties();
        //加载文本 获得流资源
        properties.load(config.getServletContext().getResourceAsStream(value));
        // 获得属性文件中的name和pass的值
      
       
        String name=properties.getProperty("name");
        String pass=properties.getProperty("pass");
        System.out.println(name+pass);
        // 从界面中获取用户输入的值
        String username=request.getParameter("Username");
        String password= request.getParameter("password");
        // 将获得的值与属性文件的值进行比较   
        if(username.equals(name)&&password.equals(pass))
        {
             request.getRequestDispatcher("adminMain.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("adminfaild.jsp").forward(request,response);
        }
       
    
    }

}
