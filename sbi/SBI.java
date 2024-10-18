package com.app.sbi;
import java.util.Scanner;

import com.app.info.model.Account;
import com.app.rbi.*;
import java.util.*;
public class SBI implements RBI{
	Scanner sc=new Scanner(System.in);
	int bb;
	Account a = new Account();
	
	
	
//	int age=a.getAge();
	@Override
	
	public void createAccount() {
		
		System.out.println("start createing bank account");
		System.out.println("enter name");
		String name=sc.nextLine();
		
		a.setName(name);
		
		
//		System.out.println("enter 10th digit mobileno ");
//		long mobile=sc.nextLong();
//		
//		a.setMobileno(mobile);
//		System.out.println("enter addrress");
//		String addr=sc.next();
//		a.setQddr(addr);
//		System.out.println("enter 12th digits aadhar no ");
//		long aadhar=sc.nextLong();
//		a.setAadhar(aadhar);
//		System.out.println("enter  aadhar no ");
//		int accno=sc.nextInt();
//		a.setAccno(accno);
		while(true) {
		System.out.println("enter 10th digit mobileno ");
		long mobile=sc.nextLong();
	
		int count = 0;
		long temp = mobile;
        while (temp > 0) {
        	
        temp = temp / 10;
        count++;
        
        
        }
        
        
        if(count==10) {
        	a.setMobileno(mobile);
        }
        else {
        	System.out.println("enter valid mobile no");
        }
       
		if(count==10) {
			break;
		}
		}
		
		
		
		System.out.println("enter addrress");
		String addr=sc.next();
		a.setQddr(addr);
		
		
		
		
		
		while(true) {
		System.out.println("enter 12th digits aadhar no ");
		long aadhar=sc.nextLong();
        int count1 = 0;
		long re=aadhar;
        while (re > 0) {
         re = re /10;
        count1++;
       
        
        
        
        }
        
        if(count1==12) {
        	a.setAadhar(aadhar);
        	
        }
        else {
        	System.out.println("enter valid aadhar no");
        }
        
        if(count1==12) {
        	break;
        }
		}
		
		while (true) {
		System.out.println("enter  account no ");
		int accno=sc.nextInt();
        int count2 = 0;
        int re1=accno;
        while (re1 > 0) {
         re1= re1 / 10;
        count2++;
       
       
        
        
        }
        
        if(count2==5) {
        	a.setAccno(accno);
        }
        else {
        	System.out.println("enter valid account no");
        }
		
		if(count2==5) {
			break;
		}
		}
		
		
		a.setBalance(7438);
		
		
		System.out.println("enter pin for withdraw and deposit");
		int pin=sc.nextInt();
		 int count3 = 0;
	        int re3=pin;
	        while (re3 > 0) {
	         re3= re3 / 10;
	        count3++;
	       
	       
	        
	        
	        }
	        
	        if(count3==6) {
	        	a.setPin(pin);
	        }
	        else {
	        	System.out.println("enter valid account no");
	        }
			
		
	}

	@Override
	public void checkBalance() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter account no");
		int acc=sc.nextInt();
		if(acc==a.getAccno()) {
			
			System.out.println("avalible balance " +a.getBalance());
		}else {
			System.out.println("invalid account number");
		}
		
	}

	
	@Override
	public void showtails() {
		
		System.out.println( "holder name is : " + a.getName());
		System.out.println("holder Account no is : " + a.getAccno());
		System.out.println("holder Adhar no is : " + a.getAadhar());
		System.out.println("holder mobile no is : " + a.getMobileno());
		System.out.println("holder address is : " + a.getQddr());
		System.out.println("avalible balance : " + a.getBalance());
		
		
		
	}
	

	@Override
	public void withdraw() 
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter account no");
		int acc=sc.nextInt();
		
		if(acc==a.getAccno()) {
			System.out.println("enter account pin");
			int pin=sc.nextInt();
			if(pin==a.getPin()) {
				System.out.println("enter amount for withdraw");
				long w=sc.nextLong();
				
					 
					if(a.getBalance()<1000 || w==0) {
					
						System.out.println("not withdraw");
					}
					else  {
						long b=a.getBalance();
						long b1=b-w;
						  
						  System.out.println("avalible balance is:" + b1);
						  a.setBalance(b1);
					
						
					}
					
			}else {
				System.out.println("invalid pin");
			}
			
		}else {
			System.out.println("invalid account number");
		}
		
		
		
		   
		 
	}

	@Override
	public void deposit() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter account no");
		int acc=sc.nextInt();
		if(acc==a.getAccno()) {
			
			System.out.println("enter amount for deposit");
			long w=sc.nextLong();
			if(w==0|| w>5000) {
				System.out.println("not deposit");
			}else {
				long b=a.getBalance();
				 long b1=b+w;
				 System.out.println("avalible balance is: " + b1);
				  a.setBalance(b1);
			}
		}else {
			System.out.println("invalid account number");
		}
		
		
		
		
		
 	}
	
	

}
