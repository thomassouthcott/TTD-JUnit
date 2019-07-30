/*
 * Made Date a final as an employees first day doesn't change.
 */
package com.example.tddTask2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/*
 * Employee Model Object
 * 
 * @author Thomas Southcott
 * @version 1.0
 */
public class Employee {
	final private String staffID;
	private String name;
	private String address;
	private String department;
	final private Date firstDay;
	private LinkedList<TrainingRecord> trainingRecords = new LinkedList<TrainingRecord>();
	
	/*
	 *  Employee Model Object
	 *  
	 *  @author Thomas Southcott
	 *  @version 1.0
	 */
	public Employee(String staffID, String name, String address, String department, Date firstDay) {
		this.staffID = staffID;
		setName(name);
		setAddress(address);
		setDepartment(department);
		this.firstDay = firstDay;
	}

	/*
	 *  Returns the Staff ID of the Employee
	 *  
	 *  @returns String
	 */
	public String getStaffID() {
		return staffID;
	}
	
	/*
	 *  Returns the Name of the Employee
	 *  
	 *  @returns String
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Sets the name of the Employee
	 * 
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 *  Returns the Address of the Employee
	 *  
	 *  @returns String
	 */	
	public String getAddress() {
		return address;
	}
	
	/*
	 *  Sets the Address of the Employee
	 *  
	 *  @param String address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 *  Returns the Department of the Employee
	 *  
	 *  @returns String
	 */
	public String getDepartment() {
		return department;
	}
	
	/*
	 *  Sets the Department of the Employee
	 *  
	 *  @param String department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/*
	 *  Returns the First Day of the Employee
	 *  
	 *  @returns Date
	 */
	public Date getFirstDay() {
		return firstDay;
	}

	/*
	 *  Returns the Training Records of the Employee
	 *  
	 *  @returns LinkedList<TrainingRecord>
	 */
	public LinkedList<TrainingRecord> getTrainingRecords() {
		return trainingRecords;
	}

	/*
	 *  Returns a Training of the Employee with the name provided
	 *  @param String name of Training Record
	 *  
	 *  @returns TrainingRecord
	 */
	public TrainingRecord getTrainingRecord(String name) {
		for(TrainingRecord record : trainingRecords) {
			if(record.getName().equals(name)) {
				return record;
			}
		}
		return null;
	}

	/*
	 *  Adds a Training Record to the Employee
	 *  
	 *  @param Training Record
	 */
	public void addTrainingRecord(TrainingRecord record) {
		this.trainingRecords.add(record);
	}

	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String trainingRecordsString = "";
		for(TrainingRecord record : trainingRecords) {
			trainingRecordsString += record.toString();
		}
		return "Employee [staffID=" + staffID 
				+ ", name=" + name 
				+ ", address=" + address 
				+ ", department=" + department
				+ ", firstDay=" + format.format(firstDay) 
				+ ", trainingRecords=" + trainingRecordsString 
				+ "]";
	}
}
