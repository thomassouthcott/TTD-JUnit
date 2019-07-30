/*
 * I added a toString as I added it to the Training Record and decided I should add an actual toString as good practice.
 * I also made addEmployee a boolean instead of void as a way to ensure uniqueness in a record manager.
 * I also made any methods that require a StaffID to search booleans so they can return false if not found.
 */
package com.example.tddTask2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/*
 * A Record Manager Model Object
 * 
 * @author Thomas Southcott
 * @version 1.0
 */
public class RecordManager {
	private ArrayList<Employee> Employees = new ArrayList<Employee>();
	
	/*
	 * Constructor
	 */
	public RecordManager() {
		
	}
	
	/*
	 * Adds an Employee to the Manager
	 * @param Employee to be added.
	 * 
	 * @return <tt>true</tt> If employee StaffID is unique, the employee has been added.
	 * @return <tt>false</tt> If employee StaffID is taken, the employee was not added.
	 */
	public boolean addEmployee(Employee employee) {
		boolean unique = true;
		for(Employee current : Employees) {
			if(employee.getStaffID().equals(current.getStaffID())) {
				unique = false;
			}
		}
		if(unique) {
			Employees.add(employee);
		}
		
		return unique;
	}
	
	/*
	 * Gets a List of Employees and their qualifications
	 * 
	 * @return String
	 */
	public String getEmployeeList() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String result = "";
		for(Employee employee : Employees) {
			String row = "";
			row = String.format("%s, %s, %s, %s, %s\n", 
					employee.getStaffID(), 
					employee.getName(), 
					employee.getAddress(), 
					employee.getDepartment(), 
					format.format(employee.getFirstDay()));
			for(TrainingRecord record: employee.getTrainingRecords()) {
				row += String.format("\t%s\n",record.toString());
			}
			result += row;
		}
		return result;
	}
	
	/*
	 * Changes an Employees name for a given staff id
	 * 
	 * @param String staffID
	 * @param String newName
	 * 
	 * @return <tt>true</tt> if a Staff ID matches and the name is changed
	 * @return <tt>false</tt> if a Staff ID didn't match, no name changed.
	 */
	public boolean changeEmployeeName(String staffID, String change) {
		boolean result = false;
		for(Employee employee : Employees){
			if(employee.getStaffID().equals(staffID)){
				employee.setName(change);
				result = true;
			}
		}
		return result;
	}
	
	/*
	 * Changes an Employees Address for a given staff id
	 * 
	 * @param String staffID
	 * @param String newAddress
	 * 
	 * @return <tt>true</tt> if a Staff ID matches and the name is Address
	 * @return <tt>false</tt> if a Staff ID didn't match, no Address changed.
	 */
	public boolean changeEmployeeAddress(String staffID, String change) {
		boolean result = false;
		for(Employee employee : Employees){
			if(employee.getStaffID().equals(staffID)){
				employee.setAddress(change);
				result = true;
			}
		}
		return result;
	}
	
	/*
	 * Adds a Training Record to a given Staff ID
	 * 
	 * @param String staffID
	 * @param TrainingRecord
	 * 
	 * @return <tt>true</tt> if a Staff ID matches and the training record is added
	 * @return <tt>false</tt> if a Staff ID didn't match, no training record added.
	 */
	public boolean addEmployeeTrainingRecord(String staffID,TrainingRecord newRecord) 
	throws NullPointerException{
		boolean result = false;
		for(Employee employee : Employees){
			if(employee.getStaffID().equals(staffID)){
				employee.addTrainingRecord(newRecord);
				result = true;
			}
		}
		return result;
	}
	
	/*
	 * Gets all employees matching a name
	 * 
	 * @param String name
	 * 
	 * @returns ArrayList<Employees>
	 */
	public ArrayList<Employee> getEmployees(String name) {
		ArrayList<Employee> result = new ArrayList<Employee>();
		for(Employee employee : Employees){
			if(employee.getName().equals(name)){
				result.add(employee);
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = "RecordManager [Employees=";
		for(Employee employee : Employees) {
			result += employee.toString();
		}
		result += "]";
		return result;
	}

}
