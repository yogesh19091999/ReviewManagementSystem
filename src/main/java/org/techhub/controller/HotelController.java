package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Model.HotelModel;
import org.techhub.service.HotelService;

@WebServlet("/newhotel")
public class HotelController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		
		out.println("</head>");
		   out.println("<body>");
		   RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		   r.include(request, response);
		   out.println("<form name='frm' action='' method='POST'>");
		   out.println("<center>");
		   out.println("<input type='text' name='name' value='' style='width:400px;height:40px;' /><br><br>");
		   out.println("<input type='submit' name='s' value='Add New Hotel' style='width:400px;height:40px;' />");
		   out.println("</div>");
		   out.println("</center>");
		   out.println("<form>");
		   String btn=request.getParameter("s");
		   if(btn!=null) {
			   String hotelName=request.getParameter("name");
			   HotelModel model = new HotelModel();
			   model.setName(hotelName);
			   HotelService hotelServ = new HotelService();
			   boolean b = hotelServ.isAddHotel(model);
			   if(b) {
				   out.println("<h1>New hotel Added Successful...</h1>");
			   }
			   else {
				   out.println("<h1>some problem in hotel adding...</h1>");
			   }
		   }
		   out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
