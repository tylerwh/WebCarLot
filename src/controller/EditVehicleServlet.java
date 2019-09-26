package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class EditVehicleServlet
 */
@WebServlet("/EditVehicleServlet")
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVehicleServlet() {
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
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Integer year = Integer.parseInt(request.getParameter("year"));
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		Double price = Double.parseDouble(request.getParameter("price"));
		
		Vehicle vehicleToEdit = veh.searchForVehicleById(tempId);
		
		vehicleToEdit.setYear(year);
		vehicleToEdit.setMake(make);
		vehicleToEdit.setModel(model);
		vehicleToEdit.setPrice(price);
		
		veh.updateVehicle(vehicleToEdit);
		
		getServletContext().getRequestDispatcher("/ViewLotServlet").forward(request, response);
	}

}
