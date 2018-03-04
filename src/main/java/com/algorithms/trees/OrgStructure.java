package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

class Employee{
	private int id;
	private String firstName;
	private String lastName;
	private int reportingTo;
	private List<Employee> emps = new ArrayList<Employee>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getReportingTo() {
		return reportingTo;
	}
	public void setReportingTo(int reportingTo) {
		this.reportingTo = reportingTo;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}

public class OrgStructure {

	public Employee head;
	
	public void addEmployee(Employee employee){
		if(head.getId() == employee.getReportingTo()){
			head.getEmps().add(employee);
		}else{
//			for()
		}
	}
	public void printEmployees(){
		System.out.println("Employee ID:"+head.getId());
		System.out.println("Employee FirstName:"+head.getFirstName());
		System.out.println("Employee LastName:"+head.getLastName());
		System.out.println("Employee ReportsTo:"+head.getReportingTo());
		printEmpDetails(head);
	}
	public void printEmpDetails(Employee employee){
		System.out.println("Employee ID:"+employee.getId());
		System.out.println("Employee FirstName:"+employee.getFirstName());
		System.out.println("Employee LastName:"+employee.getLastName());
		System.out.println("Employee ReportsTo:"+employee.getReportingTo());
		if(null == employee.getEmps() || employee.getEmps().size() != 0){
			return;
		}
		for(Employee emp : employee.getEmps()){
			printEmpDetails(emp);
		}
	}
}
