package com.caps.dev.controller;

import java.util.Scanner;

import com.caps.dev.beans.Person;
import com.caps.dev.dao.DAOimpl;
import com.caps.dev.dao.HibernateImpl;

public class CreatePerson 
{
    public static void main( String[] args )
    {
    	System.out.println("Enter Person Details");
		System.out.println("-------------------");
		Person person = new Person();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Person id: ");
		person.setId(Integer.parseInt(in.nextLine()));

		System.out.println("Enter Person name: ");
		person.setName(in.nextLine());

		System.out.println("Enter Person age: ");
		person.setAge(Integer.parseInt(in.nextLine()));

		System.out.println("Enter Person emailId: ");
		person.setEmailId(in.nextLine());
		
		System.out.println("Enter Person Address: ");
		person.setAddress(in.nextLine());
		
		DAOimpl impl=new HibernateImpl();
		//DAOimpl impl=new JDBCimpl();
		
		impl.Create(person);
		
		System.out.println("Person Details Saved..!!!!!!!!");
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}