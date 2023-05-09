package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LocationModel.Location;
import ThingsToDo.AboutTheArea;


public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		
		req.getRequestDispatcher("/_view/loader.jsp").forward(req, resp);
		
		
		System.out.println("Loader Servlet: doGet");
		String FunThingsToDo = null;
		AboutTheArea about = new AboutTheArea();
		Location bestLoc = (Location) req.getSession().getAttribute("bestLocation");
		
		

		try {
			FunThingsToDo = about.getThingsTodo(bestLoc.getZipcode());
			req.getSession().setAttribute("FunThingsToDo", FunThingsToDo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.getRequestDispatcher("/_view/output.jsp").forward(req, resp);
		
		
	}
}
