package servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FakeDatabase.FakeData;
import LocationModel.Location;
import ThingsToDo.AboutTheArea;
import DatabasePersist.DerbyDatabase;



public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String Zipcode;
	Location bestLoc = null;
	String FunThingsToDo = null;
	@Override
    public void init() throws ServletException {
        super.init();
        
        
    }
	
	//need to add animation 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");

			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		
		System.out.println("Output Servlet: doGet");	
		
		
		
		
        
        
		
		
		
		
		
		AboutTheArea about;
		
		System.out.println("Output Servlet: doPost");
		

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		Double result = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			about = new AboutTheArea();
			bestLoc = (Location) req.getSession().getAttribute("bestLocation");
			/*
			if(bestLoc == null) {
				errorMessage = "We were not able to find a location matching that criteria";
			}
			*/
			
			
			FunThingsToDo = about.getThingsTodo(bestLoc.getZipcode());
			
			
			System.out.print("BEST LOC: " + bestLoc.getAvgSalaryPerHouse());
			System.out.print("ZIPCODE: " +bestLoc.getZipcode());
			
			
			
			
			
			
			
		
			
			
			Zipcode = bestLoc.getZipcode();
			
		} catch (Exception e) {
			errorMessage = "Error getting about the area info";
		}
		
		// Add parameters as request attributes
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
		
		
		
		//fixes null pointer exception that was being thrown before
		Zipcode = bestLoc.getZipcode();
		
		
		
		req.setAttribute("AvgSalary", bestLoc.getAvgSalaryPerHouse());
		
		
		
		req.setAttribute("FunThingsToDo", FunThingsToDo);
		
		
		
		req.setAttribute("bestLoc", bestLoc);
		
		
		
		
		
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		
		
		
		
		// Once processing is complete, forward the request to the output JSP page
        //RequestDispatcher dispatcher2 = req.getRequestDispatcher("/_view/output.jsp");
        //dispatcher2.forward(req, resp);
		
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/output.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("Output Servlet doPost");
		DerbyDatabase database = new DerbyDatabase();
		String username = (String) req.getSession().getAttribute("user");
		// holds the error message text, if there is any
		String errorMessage = null;
		boolean saved = false;
		
		if(req.getParameter("submitquestions") != null) {
			resp.sendRedirect(req.getContextPath() + "/questions");
			return;
		}
		else if(req.getParameter("SaveLocation") != null) {
			
			try {
				saved = database.SaveLocation(username, Zipcode);
				System.out.print(username);
				System.out.print(Zipcode);
			} catch (SQLException e) {
				errorMessage = "Database error";
				
			}
			
			if(saved == false) {
				errorMessage = "Failed to save location. It may already be saved in your account";
			}
			else {
				String success = "Saved!";
				req.setAttribute("success", success);
			}
			req.setAttribute("errorMessage", errorMessage);
			
			req.setAttribute("AvgSalary", bestLoc.getAvgSalaryPerHouse());
			
			
			
			req.setAttribute("FunThingsToDo", FunThingsToDo);
			
			
			
			req.setAttribute("bestLoc", bestLoc);
			
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/output.jsp").forward(req, resp);
		}
		
		
		
	}

}

