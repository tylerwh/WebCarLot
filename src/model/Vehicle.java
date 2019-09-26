package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="MODEL")
	private String model;
	@Column(name="MAKE")
	private String make;
	@Column(name="YEAR")
	private int year;
	@Column(name="PRICE")
	private double price;
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Vehicle(String model, String make, int year, double price) {
		super();
		this.model = model;
		this.make = make;
		this.year = year;
		this.price = price;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String returnVechicleDetails() {
		return year + " " + make + " " + model + " for $" + price;
	}
	
	
	
	

}
