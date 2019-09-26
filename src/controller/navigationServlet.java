package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		VehicleHelper veh = new VehicleHelper();
		String process = request.getParameter("vehicleProcess");
		
		if (process == null) {
			getServletContext().getRequestDispatcher("/ViewLotServlet").forward(request, response);
			
		} else if(process.equals("Edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Vehicle vehicleToEdit = veh.searchForVehicleById(tempId);
				request.setAttribute("vehicleToEdit", vehicleToEdit);
			} catch (NumberFormatException e) {
				System.out.println("Vehicle not selected");
			} finally {
				getServletContext().getRequestDispatcher("/edit-vehicle.jsp").forward(request, response);
			}
			
		} else if(process.equals("Delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Vehicle vehicleToDelete = veh.searchForVehicleById(tempId);
				veh.removeVehicle(vehicleToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Vehicle not selected");
			} finally {
				getServletContext().getRequestDispatcher("/ViewLotServlet").forward(request, response);
			}
						
		} else if(process.equals("Add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
	}

}
