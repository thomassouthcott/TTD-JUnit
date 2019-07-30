/*
 *  I added a toString method as I realised it would be useful to implement
 */
package com.example.tddTask2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * Training Record Model Object
 * 
 * @author Thomas Southcott
 * @version 1.0
 */
public class TrainingRecord {
	private String name;
	private String level;
	private Date datePassed;
	
	/*
	 * Constructor
	 * 
	 * @param Name of the Training Record
	 * @param Level of the Training Record
	 * @param datePassed the Training Record
	 */
	public TrainingRecord(String name, String level, Date datePassed) {
		setName(name);
		setLevel(level);
		setDatePassed(datePassed);
	}
	
	/*
	 * Return the name of the object
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Set the name of the Training Record
	 * @param Name of the Training Record
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Return the level of the Training Record
	 * 
	 * @return String
	 */
	public String getLevel() {
		return level;
	}
	
	/*
	 * Set the level of the Training Record
	 * @param Level of the Training Record
	 */
	private void setLevel(String level) {
		this.level = level;
	}
	
	/* 
	 * Return the Date Passed of the Training Record
	 * 
	 * @return Date
	 */
	public Date getDatePassed() {
		return datePassed;
	}
	
	/*
	 * Set the Date Passed of the Training Record
	 * @para Date Passed of the Training Record
	 */
	private void setDatePassed(Date datePassed) {
		this.datePassed = datePassed;
	}

	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return "TrainingRecord [name=" + name + ", level=" + level + ", datePassed=" + format.format(datePassed) + "]";
	}
}
