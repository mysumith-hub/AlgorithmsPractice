package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * @author yc05s3b
 *
 * https://stackoverflow.com/questions/3228334/how-to-display-flat-data-structure-into-hierarchical-data-structure-java
 */

public class EmployeeOrg {


	public static void main(String args[]){
		new EmployeeOrg().orgStructure();
	}
	public void orgStructure(){

		Queue<Emp> queue = getEmployeeList();
		List<String> existing = new ArrayList<String>();
		Emp root = null; 
		while(!queue.isEmpty()){
			Emp emp = queue.remove();
			
			if(emp.reports_to == ""){
				root = new Emp();
				root.id = emp.id;
				existing.add(root.id);
				continue;
			}
			if(existing.contains(emp.reports_to) && root != null){
				root.addEmployee(emp);
				existing.add(emp.id);
			}else{
				queue.add(emp);
			}
			
		}
//		System.out.println(root);
		print(root);
	}
	
	public void print(Emp root){
		
		System.out.println(root.id);
		for(Emp emp: root.employees){
			print(emp);
			
		}
	}
	
	@Override
	public String toString() {
		return "EmployeeOrg [\n\t\n]";
	}
	public Queue<Emp> getEmployeeList(){
		Queue<Emp> emps = new LinkedList<Emp>();
		Emp mfly = new Emp();
		mfly.firstName = "Marty";
		mfly.id = "mfly";
		mfly.reports_to = "jblogs";
		emps.add(mfly);
		
		Emp jblogs = new Emp();
		jblogs.firstName = "Joe";
		jblogs.id = "jblogs";
		jblogs.reports_to = "rboss";
		emps.add(jblogs);
		
		Emp rboss = new Emp();
		rboss.firstName = "Robert";
		rboss.id = "rboss";
		rboss.reports_to = "";
		emps.add(rboss);
		
		Emp nmuller = new Emp();
		nmuller.firstName = "Nicolas";
		nmuller.id = "nmuller";
		nmuller.reports_to = "jblogs";
		emps.add(nmuller);
		
		Emp trice = new Emp();
		trice.firstName = "Travis";
		trice.id = "trice";
		trice.reports_to = "rboss";
		emps.add(trice);

		
		return emps;
	}
}

class Emp{
	public List<Emp> employees = new ArrayList<Emp>();
	public String firstName;
	public String lastName;
	public String id;
	public String reports_to;
	
	public void addEmployee(Emp emp){
		if(emp.reports_to == id){
			employees.add(emp);
		}else{
			for(Emp reporters : employees){
				reporters.addEmployee(emp);
			}
		}
	}

	@Override
	public String toString() {
		return "Emp [\n\t" + (employees != null ? "employees=" + employees + ", \n\t\t" : "")
				+ (firstName != null ? "firstName=" + firstName + ", \n\t\t" : "")
				+ (lastName != null ? "lastName=" + lastName + ", \n\t\t" : "")
				+ (id != null ? "id=" + id + ", \n\t\t" : "") + (reports_to != null ? "reports_to=" + reports_to : "")
				+ "\n]";
	}
	
}
