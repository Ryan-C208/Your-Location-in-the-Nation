package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabasePersist.DerbyDatabase;
import LocationModel.Location;
import UserModel.PopularLocations;

public class SearchByZipcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DerbyDatabase database;
	Location Location = null;
	@Override
	public void init() throws ServletException {
		super.init();
		database = new DerbyDatabase();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SearchByZipcode Servlet: doGet");
	    
		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");

			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}

	    
		
		
		
		
		req.getRequestDispatcher("/_view/ViewZipInfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SearchByZipcode Servlet: doPost");
		//needs database attribute
		String errorMessage = null;
    	String Zipcode = req.getParameter("Zipcode");
        
        boolean saved = false;
        String username = (String) req.getSession().getAttribute("user");
        
        
		//if user clicks submit
        if(req.getParameter("submit") != null) {
        	try {
    			Location = database.viewZipcodeinfo(Zipcode);
    			 //System.out.print("PopLoc" + PopularLocations.get(0).getNumberOfSaves());
    			  
    		     req.setAttribute("Location", Location);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            

    		if(Location == null) {
    			errorMessage = "No location in our database matched that ZIP code";
    			System.out.print(errorMessage);
    			req.setAttribute("errorMessage", errorMessage);
    		}
    		else {
    			req.setAttribute("Location", Location);
    			req.setAttribute("avgsal", Location.getAvgSalaryPerHouse());
    			req.setAttribute("Zipcode", Zipcode);
    		}
    	       
    	    
    		req.getRequestDispatcher("/_view/ViewZipInfo.jsp").forward(req, resp);
        	
        	
        }
        
        //if the user clicks to go back to the index
        else if(req.getParameter("index") != null) {
        	resp.sendRedirect(req.getContextPath() + "/index");
        	return;
        }
        else if(req.getParameter("save") != null) {
			
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
			
			
			
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/ViewZipInfo.jsp").forward(req, resp);
		}
        
        
        
	    
	}
}
