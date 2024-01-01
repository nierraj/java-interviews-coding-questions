package com.neeraj.codingproblems;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableMain {

	public static void main(String[] args) {

		EmployeeExternalizable emp = new EmployeeExternalizable();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Neeraj");
		emp.setOrganization("ACI Worldwide Inc.");

		// Serialize
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.txt");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// Deserialize
		emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (EmployeeExternalizable) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getEmployeeName());
		System.out.println("Organisation: " + emp.getOrganization());
	}
}

class EmployeeExternalizable implements Externalizable {

	int employeeId;
	String employeeName;
	String organization;

	public EmployeeExternalizable() {

	}

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

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		employeeId = in.readInt();
		employeeName = (String) in.readObject();
		organization = (String) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(employeeId);
		out.writeObject(employeeName);
		out.writeObject(organization);
	}
}
