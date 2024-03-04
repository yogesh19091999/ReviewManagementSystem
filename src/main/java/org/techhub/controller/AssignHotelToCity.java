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

import org.Model.CityModel;
import org.Model.HotelModel;
import org.apache.tomcat.util.modeler.modules.ModelerSource;
import org.techhub.service.CityService;
import org.techhub.service.HotelService;


@WebServlet("/assignhotel")
public class AssignHotelToCity extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		
		out.println("<center>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<input type='submit' name='s' value='Fetch Hotels' style='width:400px;heightL40px'/><br><br>");
		out.println("<select name='hotelname' style='width:400px;height:40px'>");
		out.println("<option>Select Hotel</option>");
		HotelService hotelServ = new HotelService();
		List<HotelModel> list=hotelServ.getAllHotels();
		for(HotelModel model:list) {
			out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
			
		}
		out.println("</select>");
		out.println("&nbsp;&nbsp;");
		out.println("<select style='width:400px;height:40px'>");
		out.println("<option>Select Hotel</option>");
		List<CityModel> Citylist=new CityService().getAllCities();
		for(CityModel model:Citylist) {
			out.println("<option>"+model.getName()+"</option>");
		}
		out.println("</select>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null) {
			int hid=Integer.parseInt(request.getParameter("hotelname"));
			out.println(hid);
		}
		out.println("</center>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
