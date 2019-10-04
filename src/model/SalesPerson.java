package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="salesperson")
public class SalesPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="HIRE_DATE")
	private LocalDate hireDate;
//	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
//		@JoinTable
//		(
//				name="salesperson",
//				joinColumns= { @JoinColumn(name="EMP_ID", referencedColumnName="EMP_ID")},
//				inverseJoinColumns= { @JoinColumn(name="EMP_ID", referencedColumnName="EMP_ID", unique=true)}
//		)
//		private List<Vehicle> vehicleList;
	
	public SalesPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SalesPerson(String name) {
		super();
		this.name = name;
	}

	public SalesPerson(String name, LocalDate hireDate) {
		super();
		this.name = name;
		if (hireDate == null) {
			this.hireDate = LocalDate.now();
		} else {
			this.hireDate = hireDate;
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hireDate
	 */
	public LocalDate getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "SalesPerson [id=" + id + ", name=" + name + ", hireDate=" + hireDate + "]";
	}
	

}
