package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalesPerson;
import model.Vehicle;

/**
 * Servlet implementation class addVehicleServlet
 */
@WebServlet("/addVehicleServlet")
public class addVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Made it to addVehicleServlet"); // Used as checkpoint for testing
		
		int year = Integer.parseInt(request.getParameter("year"));
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		double price = Double.parseDouble(request.getParameter("price"));
		// Capture salesPerson from index
		String salesPerson = request.getParameter("salesPerson");
		System.out.println("Start adding salesPerson");
		SalesPerson personToAdd = new SalesPerson(salesPerson);
		SalesPersonHelper sph = new SalesPersonHelper();
		sph.insertSalesPerson(personToAdd);
		
		Vehicle vehicleToAdd = new Vehicle(model, make, year, price);
		VehicleHelper veh = new VehicleHelper();
		veh.insertVehicle(vehicleToAdd);
		
		
		// Go back to index.html page
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
