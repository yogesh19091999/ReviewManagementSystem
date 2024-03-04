package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Model.HotelInfoModel;
import org.Model.HotelModel;
import org.techhub.service.HotelService;

@WebServlet("/hotelinfo")
public class HotelInfoController extends HttpServlet {
	
	private Object hotelServ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		
		out.println("<br>");
		out.println("<form name='frm' action='' mathod='POST'>");
		out.println("<input type='text' name='email' value='' style='width:400px; height:40px;'/><br><br>");
		out.println("<input type='text' name='contact' value='' style='width:400px; height:40px;'/><br><br>");
		out.println("<input type='text' name='address' value='' style='width:400px; height:40px;'/><br><br>");
		out.println("<input type='text' name='location' value='' style='width:400px; height:40px;'/><br><br>");
		HotelService hotelServ=new HotelService();
		List<HotelModel> list=hotelServ.getAllHotels();
		out.println("<select name='hotelname' style='width:400px;height:40px;'>");
		out.println("<option>Select Hotel</option>");
		for(HotelModel model:list) {
			out.println("<option>"+model.getName()+"</option>");
		}
		out.println("</select>");
		out.println("<br><br><input type='submit' name='s' value='Add Hotel Info' style='width:400px; height:40px;'/>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		System.out.println("btn="+btn);
		if(btn!=null) {
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String address=request.getParameter("address");
			String location=request.getParameter("location");
			String hotelName=request.getParameter("hotelname");
			System.out.println("all information"+email + contact + address + location + hotelName);
			HotelInfoModel model=new HotelInfoModel();
			model.setEmail(email);
			model.setContact(contact);
			model.setAddress(address);
			model.setLocation(location);
			model.setName(hotelName);
			HotelService hServ=new HotelService();
			boolean b=hServ.isAddHotelInfo(model);
			if(b) {
				out.println("<h1>Hotel Info Added Success........</h1>");
			}
			else {
				out.println("<h1>Some problem is there........</h1>");
			}
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		doGet(request, response);
	}

}
