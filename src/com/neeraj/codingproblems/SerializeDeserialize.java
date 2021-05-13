package com.neeraj.codingproblems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDeserialize {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Neeraj");
		emp.setOrganization("ACI Worldwide Inc.");
		Address address=new Address(11,"Magarpatta","Pune");
		emp.setAddress(address);
		
		try {
			// Serialize
			FileOutputStream fileOut = new FileOutputStream("employee.txt");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();

			// Deserialize
			Employee emp1 = null;
			FileInputStream fileIn = new FileInputStream("employee.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp1 = (Employee) in.readObject();
			in.close();
			fileIn.close();

			System.out.println("Deserialized Employee...");
			System.out.println("Emp id: " + emp1.getEmployeeId());
			System.out.println("Name: " + emp1.getEmployeeName());
			System.out.println("Organization: " + emp1.getOrganization());
			address = emp.getAddress();
			System.out.println("City :"+address.getCity());
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
	}
}

class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	int employeeId;
	String employeeName;
	String organization;
	transient Address address;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private void writeObject(ObjectOutputStream os) throws IOException, ClassNotFoundException {
		try {
			os.defaultWriteObject();
			os.writeInt(address.getHomeNo());
			os.writeObject(address.getStreet());
			os.writeObject(address.getCity());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
		try {
			is.defaultReadObject();
			int homeNo = is.readInt();
			String street = (String) is.readObject();
			String city = (String) is.readObject();
			address = new Address(homeNo, street, city);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Address {

	int homeNo;
	String street;
	String city;

	public Address(int homeNo, String street, String city) {
		super();
		this.homeNo = homeNo;
		this.street = street;
		this.city = city;
	}

	public int getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}