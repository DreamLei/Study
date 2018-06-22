/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HelloServlet
 * Author:   tell
 * Date:     2018/6/22 14:06
 * Description: HelloServlet
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.smart4j.chapter1;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈HelloServlet〉
 *
 * @author tell
 * @create 2018/6/22
 * @since 1.0.0
 */
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletRequest resp)throws ServletException,IOException{
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime=dateFormat.format(new Date());
        req.setAttribute("currentTime",currentTime);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, (ServletResponse) resp);
    }
}