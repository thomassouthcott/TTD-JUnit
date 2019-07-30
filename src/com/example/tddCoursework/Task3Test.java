package com.example.tddCoursework;

import com.example.tddTask2.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class Task3Test extends AbstractLoggingJUnitTest {
	String recordName = "BTech PE";
	String recordLevel = "Pass";
	Date recordNow = new Date();
		TrainingRecord tr = new TrainingRecord(recordName,recordLevel,recordNow);
		
	String employeeStaffID = "TS17";
	String employeeName = "Thomas Southcott";
	String employeeAddress = "12 Lyndhust Avenue";
	String employeeDepartment = "IT";
	Date employeeFirstDay = recordNow;
		Employee testEmployee = new Employee(employeeStaffID,employeeName,employeeAddress,employeeDepartment,employeeFirstDay);

	RecordManager testManager = new RecordManager();
	
	String secondEmployeeStaffID = "TH17";
	String secondEmployeeName = "Thomas Southcott";
	String secondEmployeeAddress = "13 Lyndhust Avenue";
	String secondEmployeeDepartment = "HR";
	Date secondEmployeeFirstDay = recordNow;
		Employee testEmployee2 = new Employee(secondEmployeeStaffID,secondEmployeeName,secondEmployeeAddress,secondEmployeeDepartment,secondEmployeeFirstDay);

	@Test
	public void recordManagerGetMatchingNamesSingleName() {
		testManager.addEmployee(testEmployee);
		ArrayList<Employee> test = testManager.getEmployees("Thomas Southcott");
		
		assertTrue("Record Manager did not return the correct name.",test.get(0).getName().equals("Thomas Southcott"));
	}

	@Test
	public void recordManagerGetMatchingNamesMultipleName() {
		testManager.addEmployee(testEmployee);
		testManager.addEmployee(testEmployee2);
		ArrayList<Employee> test = testManager.getEmployees("Thomas Southcott");
		
		assertTrue("Record Manager did not return the correct names.",test.get(0).getName().equals("Thomas Southcott")&&test.get(1).getName().equals("Thomas Southcott"));
	}

	@Test
	public void recordManagerGetMatchingNamesNoNames() {
		testManager.addEmployee(testEmployee);
		ArrayList<Employee> test = testManager.getEmployees("Thomas Helyeh");
		
		assertTrue("Record Manager returned names.",test.size()==0);
	}
	
	@Test
	public void recordManagerChangeEmployeeName() {
		String change = "Thomas Helyeh";
		testManager.addEmployee(testEmployee);
		testManager.changeEmployeeName(testEmployee.getStaffID(),change);
		
		assertTrue("Record Manager did not change the name.",testManager.getEmployees(change).get(0).getName().equals(change));
	}
	
	@Test
	public void recordManagerChangeEmployeeAddress() {
		String change = "14 Lyndhurst Avenue";
		testManager.addEmployee(testEmployee);
		testManager.changeEmployeeAddress(testEmployee.getStaffID(),change);
		
		assertTrue("Record Manager did not change the address.",testManager.getEmployees("Thomas Southcott").get(0).getAddress().equals(change));
	}
	
	@Test
	public void recordManagerChangeEmployeeNameNoMatchingStaffID() {
		String change = "Thomas Helyeh";
		testManager.addEmployee(testEmployee);
		
		
		assertFalse("Record Manager did not change the name.",testManager.changeEmployeeName("",change));
	}
	
	@Test
	public void recordManagerChangeEmployeeAddressNoMatchingStaffID() {
		String change = "Thomas Helyeh";
		testManager.addEmployee(testEmployee);
		
		
		assertFalse("Record Manager did not change the name.",testManager.changeEmployeeAddress("",change));
	}
	
	@Test(expected=NullPointerException.class)
	public void recordManagerChangeEmployeeNameNull() {
		String change = null;
		testManager.addEmployee(testEmployee);
		testManager.changeEmployeeName(testEmployee.getStaffID(),change);
		
		assertTrue("Expected Exception wasn't thrown.",testManager.getEmployees(change).get(0).getName().equals(change));
	}
	
	@Test(expected=NullPointerException.class)
	public void recordManagerChangeEmployeeAddressNull() {
		String change = null;
		testManager.addEmployee(testEmployee);
		testManager.changeEmployeeAddress(testEmployee.getStaffID(),change);
		
		assertTrue("Expected Exception wasn't thrown.",testManager.getEmployees("Thomas Southcott").get(0).getAddress().equals(change));
	}
	
	@Test
	public void recordManagerAddEmployeeQualification() {
		Date now = new Date();
		testManager.addEmployee(testEmployee);
		TrainingRecord newRecord = new TrainingRecord("Alevel Maths","A*",now);
		assertTrue("Record Manager didn't add a new training record",testManager.addEmployeeTrainingRecord(testEmployee.getStaffID(),newRecord));
	}
	
	@Test
	public void recordManagerAddEmployeeQualificationNoStaffID() {
		Date now = new Date();
		testManager.addEmployee(testEmployee);
		TrainingRecord newRecord = new TrainingRecord("Alevel Maths","A*",now);
		assertFalse("Record Manager didn't add a new training record",testManager.addEmployeeTrainingRecord("",newRecord));
	}
	
	@Test(expected=NullPointerException.class)
	public void recordManagerAddEmployeeQualificationNull() {
		testManager.addEmployee(testEmployee);
		TrainingRecord newRecord = null;
		assertTrue("Record Manager didn't add a new training record",testManager.addEmployeeTrainingRecord(testEmployee.getStaffID(),newRecord));
	}
}
