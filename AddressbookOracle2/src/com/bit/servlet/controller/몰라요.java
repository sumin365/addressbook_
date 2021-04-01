package com.bit.servlet.controller;

public class 몰라요 {

}
//private static final long serialVersionUID = 1L;
//AddressbookDao addressbookdao = new AddressbookDaoOrclImpl();
//   
//
//
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	AddressbookDao addressbookdao = new AddressbookDaoOrclImpl();
//
//String action = req.getParameter("a");
//
//System.out.println(action);
//
//if("register".equals(action)) {
//	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/page/register.jsp");
//	rd.forward(req, resp);
//}else if ("delete".equals(action)) {
//	Long no = Long.valueOf(req.getParameter("no"));
//	addressbookdao.delete
//		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/page/register.jsp");
//		rd.forward(req, resp);
//	
//	String a = req.getParameter("a");
//	List<AddressbookVo> list = .search(a);
//	req.setAttribute("list", list);
//	req.setAttribute("a", a);
//	RequestDispatcher rd = req.getRequestDispatcher("/");
//	rd.forward(req, resp);
//}else if("register".equals(action)){
//	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/register.jsp");
//	rd.forward(req, resp);
//}else {
//	List<AddressbookVo> list = addressbookdao.getList();
//	req.setAttribute("list", list);
//	RequestDispatcher rd = req.getRequestDispatcher("/");
//	rd.forward(req, resp);
//}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	AddressbookDao addressbookdao = new AddressbookDaoOrclImpl();
//	String action = req.getParameter("a");
//	if("insert".equals(action)) {
//		String name = req.getParameter("name");
//		String hp = req.getParameter("hp");
//		String tel = req.getParameter("tel");
//		
//		AddressbookVo vo = new AddressbookVo(name,hp,tel);
//		if(addressbookdao.insert(vo)) {
//			doGet(req, resp);
//		}else {
//			req.setAttribute("action", "insertform");
//			doGet(req, resp);
//		}
//	}else if("delete".equals(action)){
//		System.out.println(req.getParameter("id"));
//		Long id = Long.parseLong(req.getParameter("id"));
//		System.out.println(id);
//		if(addressbookdao.delete(id)) {
//			doGet(req, resp);
//		}else {
//			doGet(req, resp);
//		}
//		
//	}
//}
//
//
//
//}


//while (rs.next()) {
//	Long no = rs.getLong(1);
//	String name = rs.getString(2);
//	String tel = rs.getString(3);
//	String hp = rs.getString(4);
//	
//	AddressVo vo = new AddressVo();
//	vo.setId(rs.getLong(1));
//	vo.setName(rs.getString(2));
//	vo.setPhone(rs.getString(3));
//	vo.setTel(rs.getString(4));
//	
//	list.add(vo);
//
//	while(rs.next()) {
//		AddressbookVO vo = new AddressbookVO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4));
//		list.add(vo);
//	}
//	while(rs.next()) {
//		AddressbookVO vo = new AddressbookVO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4));
//		list.add(vo);
//	}