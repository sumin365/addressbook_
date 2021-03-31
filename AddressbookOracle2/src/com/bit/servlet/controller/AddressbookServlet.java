package com.bit.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.servlet.dao.AddressbookDao;
import com.bit.servlet.dao.AddressbookDaoOrclImpl;
import com.bit.servlet.model.AddressbookVo;
@WebServlet("/AddressbookServlet")
public class AddressbookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
										throws ServletException, IOException {
		
		String action = req.getParameter("a");
		
		if ("register".equals(action)) {
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/page/register.jsp");
			rd.forward(req, resp);
			
		} else if ("delete".equals(action)){
			Long no = Long.valueOf(req.getParameter("no"));
			AddressbookDao dao = new AddressbookDaoOrclImpl();
			dao.delete(no);

			resp.sendRedirect(req.getContextPath()+ "");
			
		} else if ("search".equals(action)){
			String toSearch = req.getParameter("key");
			AddressbookDao addressbookdao = new AddressbookDaoOrclImpl();
			List<AddressbookVo> list = addressbookdao.search(toSearch);
			req.setAttribute("list", list);
			
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/WEB-INF/page/index.jsp");
			rd.forward(req, resp);
			
		} else {
			AddressbookDao dao = new AddressbookDaoOrclImpl();
			List<AddressbookVo> list = dao.getList();
			req.setAttribute("list", list);
			
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/WEB-INF/page/index.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
										throws ServletException, IOException {
		String action = req.getParameter("a");
		
		if("insert".equals(action)) {
			String name = req.getParameter("name");
			String tel = req.getParameter("tel");
			String hp = req.getParameter("hp");
			AddressbookVo vo = new AddressbookVo(name, tel,hp );
			AddressbookDao dao = new AddressbookDaoOrclImpl();
			dao.insert(vo);
			
			resp.sendRedirect(req.getContextPath()+ "/el");
		} else {
			doGet(req, resp);
		}
	}
}
////