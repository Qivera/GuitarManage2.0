package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DAOFactory;

@WebServlet("/GuitarServlet")
public class GuitarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuitarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 {  
			       this.doPost(request,response) ;  
			   }  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		request.setCharacterEncoding("GB2312") ;
		String path = "index.jsp" ;
		// 接收要操作的参数值
		String status = request.getParameter("status") ;
		
		if(status!=null)
		{	
			// 模糊查询
			if("selectbylike".equals(status))
			{
				String keyword = request.getParameter("keyword").toUpperCase() ;
				try
				{
					request.setAttribute("all",DAOFactory.getGuitarDAOInstance().queryByLike(keyword)) ;
				}
				catch (Exception e)
				{
				}
				path = "index.jsp" ;
			}
		}
		else
		{
			
		}	
		request.getRequestDispatcher(path).forward(request,response) ;
	}
}