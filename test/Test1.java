package com.app.test;
import com.app.info.model.*;
import com.app.rbi.*;
import com.app.sbi.*;
import java.util.*;
public class Test1 {

	public static void main(String[] args) {
		RBI1 r=new SBI1();
		Account a = new Account();
		Scanner sc=new Scanner(System.in);
		
//		System.out.println("enter age");
//		int age=sc.nextInt();
//		a.setAge(age);
//		
		
		
		
		
		
		try{
			
		while(true)
			
		{
		System.out.println("enter 1 for create, 2 for view chcekbalance, 3 for view dtails, 4 for withdraw 5 for deposit, 6 for update details, 7 for transection histry 8 for exit");
		int no=sc.nextInt();
		
		switch(no) {
		
		case 1:{
//			if(a.getAge()>=18&&a.getAge()<=60) {
			
			r.createAccount();
			System.out.println("data is save");
//			}
//			else {
//				System.err.println("not creat");
//			}
			break;
		}
		case 2:
		{
			r.checkBalance();
			break;
		}
		case 3:
		{
			r.showtails();
			break;
		}
		case 4:{
			r.withdraw();
			break;
		}
		case 5:
		{r.deposit();
		break;
			
		
		}
		case 6:{
			r.update();
			break;
		}
		case 7:{
			r.transhistory();
			break;
		}
		default:{
			System.out.println("Enter correct input 1 to 7 only");
		}
		}
		if (no==8) {
			System.out.println("exit");
			break;
		}
		
		}
		
		}catch(InputMismatchException e) {
			System.out.println("plse input integer value");
		}catch(NullPointerException e){
			System.out.println("first create account");
		}finally {
		
			sc.close();
		}
	}
			}

