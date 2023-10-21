package com.itview.testcases.selenium_aug_batch;


class Student{
	
	static  void display() {
		
		System.out.println("Student details..");
	}
}


public class DemoClass {

	public static void main(String[] args) {

		Student s=new Student();		
		s.display();
		
		Student.display();


	}

}
