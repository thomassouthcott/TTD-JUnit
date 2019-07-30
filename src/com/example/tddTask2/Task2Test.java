package com.example.tddTask2;

import com.example.tddCoursework.AbstractLoggingJUnitTest;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;


public class Task2Test extends AbstractLoggingJUnitTest {
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
	String secondEmployeeName = "Thomas Helyeh";
	String secondEmployeeAddress = "13 Lyndhust Avenue";
	String secondEmployeeDepartment = "HR";
	Date secondEmployeeFirstDay = recordNow;
		Employee testEmployee2 = new Employee(secondEmployeeStaffID,secondEmployeeName,secondEmployeeAddress,secondEmployeeDepartment,secondEmployeeFirstDay);

	@Test
	public void trainingRecordInitialize() {
		assertTrue("Training Record is not initialised",tr instanceof TrainingRecord);
	}
	
	@Test
	public void trainingRecordGetName() {
		if(!tr.getName().equals(recordName)) {
			fail("TrainingRecord getName failed.");
		}
	}
	
	@Test
	public void trainingRecordGetLevel() {
		if(!tr.getLevel().equals(recordLevel)) {
			fail("TrainingRecord getLevel failed.");
		}
	}
	
	@Test
	public void trainingRecordGetDatePassed() {
		assertTrue("TrainingRecord getDatePassed failed.",tr.getDatePassed().equals(recordNow));
	}
	
	@Test
	public void trainingRecordToString() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String result = "TrainingRecord [name=" + recordName + ", level=" + recordLevel + ", datePassed=" + format.format(recordNow) + "]";
		assertTrue("Training Record to String failed.",result.equals(tr.toString()));
		
	}
	
	@Test
	public void employeeInitialize() {
		assertTrue("Employee is not initialised",testEmployee instanceof Employee);
	}
	
	@Test
	public void employeeGetStaffID() {
		assertTrue("Employee getStaffID",testEmployee.getStaffID().equals(employeeStaffID));
	}

	@Test
	public void employeeGetName() {
		assertTrue("Employee getName failed",testEmployee.getName().equals(employeeName));
	}

	@Test
	public void employeeGetAddress() {
		assertTrue("Employee getAddress failed",testEmployee.getAddress().equals(employeeAddress));
	}

	@Test
	public void employeeGetDepartment() {
		assertTrue("Employee getDepartment failed",testEmployee.getDepartment().equals(employeeDepartment));
	}

	@Test
	public void employeeGetFirstDay() {
		assertTrue("Employee getFirstDay failed",testEmployee.getFirstDay().equals(employeeFirstDay));
	}

	@Test
	public void employeeSetName() {
		String newName = "Thomas Helyeh";
		testEmployee.setName(newName);
		assertTrue("Employee setName failed",testEmployee.getName().equals(newName));
		testEmployee.setName(employeeName);
	}

	@Test(expected = NullPointerException.class)
	public void employeeSetNameNull() {
		String newName = null;
		testEmployee.setName(newName);
		assertTrue("Employee didn't throw an exception.",testEmployee.getName().equals(newName));
		testEmployee.setName(employeeName);
	}

	@Test
	public void employeeSetAddress() {
		String newAddress = "13 Lyndhurst";
		testEmployee.setAddress(newAddress);
		assertTrue("Employee setAddress failed",testEmployee.getAddress().equals(newAddress));
		testEmployee.setAddress(employeeAddress);
	}

	@Test(expected = NullPointerException.class)
	public void employeeSetAddressNull() {
		String newAddress = null;
		testEmployee.setAddress(newAddress);
		assertTrue("Employee didn't throw an exception.",testEmployee.getAddress().equals(newAddress));
		testEmployee.setAddress(employeeAddress);
	}

	@Test
	public void employeeSetDepartment() {
		String newDepartment = "HR";
		testEmployee.setDepartment(newDepartment);
		assertTrue("Employee setDepartment failed",testEmployee.getDepartment().equals(newDepartment));
		testEmployee.setDepartment(employeeDepartment);
	}

	@Test(expected = NullPointerException.class)
	public void employeeSetDepartmentNull() {
		String newDepartment = null;
		testEmployee.setDepartment(newDepartment);
		assertTrue("Employee didn't throw an exception.",testEmployee.getDepartment().equals(newDepartment));
		testEmployee.setDepartment(employeeDepartment);
	}
	
	@Test
	public void employeeGetTrainingRecords() {
		assertTrue("Employee getTrainingRecords returned an incorrect type.",testEmployee.getTrainingRecords() instanceof LinkedList);
	}
	
	@Test
	public void employeeAddAndSetTrainingRecord() {
		testEmployee.addTrainingRecord(tr);
		assertTrue("Employee addTrainingRecord did not add a training record, or returned an incorrect type.",testEmployee.getTrainingRecord(recordName) instanceof TrainingRecord);
	}
	
	@Test(expected = NullPointerException.class)
	public void employeeAddAndSetTrainingRecordNull() {
		testEmployee.addTrainingRecord(null);
		assertTrue("Employee  didn't throw an exception.",testEmployee.getTrainingRecord(recordName) instanceof TrainingRecord);
	}
	
	@Test
	public void employeeToString() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		testEmployee.addTrainingRecord(tr);
		assertTrue("",testEmployee.toString().equals("Employee [staffID=" + employeeStaffID 
				+ ", name=" + employeeName 
				+ ", address=" + employeeAddress 
				+ ", department=" + employeeDepartment
				+ ", firstDay=" + format.format(employeeFirstDay) 
				+ ", trainingRecords=" + tr.toString() 
				+ "]"));
	}
	
	@Test
	public void recordManagerInitialize() {
		assertTrue("RecordManager was not initialized.",testManager instanceof RecordManager);
	}
	
	@Test
	public void recordManagerAddEmployee() {
		assertTrue("RecordManager failed to add an Employee.",testManager.addEmployee(testEmployee));
	}
	
	@Test
	public void recordManagerAddEmployeeTakenStaffID() {
		testManager.addEmployee(testEmployee);
		assertFalse("RecordManager added an duplicate Employee.",testManager.addEmployee(testEmployee));
	}
	
	@Test
	public void recordManagerAddEmployeeNull()
		throws NullPointerException{
		assertTrue("RecordManager didn't throw an exception.",testManager.addEmployee(null));
	}
	
	@Test
	public void recordManagerGetEmployeeList() {
		testManager.addEmployee(testEmployee);
		testManager.addEmployee(testEmployee2);
		String expectedResult = "TS17, Thomas Southcott, 12 Lyndhust Avenue, IT, 30/11/2017\n"
				+ "TH17, Thomas Helyeh, 13 Lyndhust Avenue, HR, 30/11/2017";
		assertTrue("RecordManage didn't return expected string.",testManager.getEmployeeList().equals(expectedResult));
	}
	
	@Test
	public void recordManagerToString() {
		testManager.addEmployee(testEmployee);
		testManager.addEmployee(testEmployee2);
		String expectedResult = "RecordManager [Employees=Employee [staffID=TS17, name=Thomas Southcott, address=12 Lyndhust Avenue, department=IT, firstDay=30/11/2017, trainingRecords=]Employee [staffID=TH17, name=Thomas Helyeh, address=13 Lyndhust Avenue, department=HR, firstDay=30/11/2017, trainingRecords=]]";
		assertTrue("RecordManage didn't return expected string.",testManager.toString().equals(expectedResult));
	}
	
}
