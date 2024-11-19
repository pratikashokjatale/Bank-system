package com.app.sbi;

import java.util.Scanner;

import com.app.info.model.Account;
import com.app.rbi.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class SBI implements RBI {
	Scanner sc = new Scanner(System.in);
	int bb;
	Account a = new Account();
	long upa;
	long upa1;

//	int age=a.getAge();
	@Override

	public void createAccount() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "9325572418");
			String sql = "insert into account values(?,?,?,?,?,?,?)"; //insert the data using preprared statment 
			PreparedStatement pre = con.prepareStatement(sql);

			System.out.println("start createing bank account");
			System.out.println("enter name");
			String name = sc.next();

			a.setName(name);

			pre.setString(1, a.getName());

			while (true) {
				System.out.println("enter 10th digit mobileno ");
				long mobile = sc.nextLong();

				int count = 0;
				long temp = mobile;
				while (temp > 0) {

					temp = temp / 10;
					count++;

				}

				if (count == 10) {
					a.setMobileno(mobile);
					pre.setLong(2, a.getMobileno());
				} else {
					System.out.println("enter valid mobile no");
				}

				if (count == 10) {
					break;
				}
			}

			System.out.println("enter addrress");
			String addr = sc.next();
			a.setQddr(addr);
			pre.setString(4, a.getQddr());

			while (true) {
				System.out.println("enter 12th digits aadhar no ");
				long aadhar = sc.nextLong();
				int count1 = 0;
				long re = aadhar;
				while (re > 0) {
					re = re / 10;
					count1++;

				}

				if (count1 == 12) {
					a.setAadhar(aadhar);
					pre.setLong(3, a.getAadhar());

				} else {
					System.out.println("enter valid aadhar no");
				}

				if (count1 == 12) {
					break;
				}
			}

			while (true) {
				System.out.println("enter  account no ");
				int accno = sc.nextInt();
				int count2 = 0;
				int re1 = accno;
				while (re1 > 0) {
					re1 = re1 / 10;
					count2++;

				}

				if (count2 == 5) {
					a.setAccno(accno);
					pre.setInt(6, a.getAccno());
				} else {
					System.out.println("enter valid account no");
				}

				if (count2 == 5) {
					break;
				}
			}
			System.out.println("enter balance");
			a.setBalance(sc.nextLong());
			pre.setLong(5, a.getBalance());

			System.out.println("enter pin for withdraw and deposit");
			int pin = sc.nextInt();
			int count3 = 0;
			int re3 = pin;
			while (re3 > 0) {
				re3 = re3 / 10;
				count3++;

			}

			if (count3 == 6) {
				a.setPin(pin);
				pre.setInt(7, a.getPin());
			} else {
				System.out.println("enter valid account no");

			}
			int val = pre.executeUpdate();
			if (val == 1) {
				System.out.println("successfully insert data");
			} else {
				System.out.println("not insert data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void checkBalance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "9325572418");

			Scanner sc = new Scanner(System.in);
			System.out.println("enter account no");
			int acc = sc.nextInt();
			System.out.println("enter pin");
			int pin = sc.nextInt();
			String sql = "select * from account where accountno=" + acc + " and pin=" + pin + "";

//		if (acc == a.getAccno()) {
//
//			System.out.println("avalible balance " + a.getBalance());
//		} else {
//			System.out.println("invalid account number");
//		}
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet re = pre.executeQuery();

			if (re.next()) {
				System.out.println("holder balance is : " + re.getLong(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showtails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "9325572418");

			System.out.println("enter account number ");
			int no = sc.nextInt();
			String sql = "select * from account where accountno=" + no + "";
			PreparedStatement pre = con.prepareStatement(sql);

			ResultSet re = pre.executeQuery();
			while (re.next()) {

				System.out.println("holder name is : " + re.getString(1));
				System.out.println("holder mobile no is : " + re.getLong(2));
				System.out.println("holder aadhar no is : " + re.getLong(3));
				System.out.println("holder address is : " + re.getString(4));
				System.out.println("holder balance is : " + re.getLong(5) + "rs");
				System.out.println("holder Account no is : " + re.getInt(6));
			}

//			System.out.println("holder name is : " + a.getName());
//			System.out.println("holder Account no is : " + a.getAccno());
//			System.out.println("holder Adhar no is : " + a.getAadhar());
//			System.out.println("holder mobile no is : " + a.getMobileno());
//			System.out.println("holder address is : " + a.getQddr());
//			System.out.println("avalible balance : " + a.getBalance());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void withdraw() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "9325572418");
		

			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter account no");
			int acc = sc.nextInt();
			String sql = "select * from account where accountno=" + acc + "";
			Statement pre = con.createStatement();
			ResultSet re=pre.executeQuery(sql);
			
			if(re.next()) {
				
				
			System.out.println("enter withdraw amount");
			upa=sc.nextLong();
			
			String up="update bank.account set balance= balance - "+upa+" where accountno=" + acc +" ";	
			PreparedStatement pre1 = con.prepareStatement(up);
			pre1.execute();
			
			System.out.println("withdraw successfully " + upa + " rs");
			
			
			  
			    
			
			}
			
			
//		if (acc == a.getAccno()) {
//			System.out.println("enter account pin");
//			int pin = sc.nextInt();
//			if (pin == a.getPin()) {
//				System.out.println("enter amount for withdraw");
//				long w = sc.nextLong();
//
//				if (a.getBalance() < 1000 || w == 0) {
//
//					System.out.println("not withdraw");
//				} else {
//					long b = a.getBalance();
//					long b1 = b - w;
//
//					System.out.println("avalible balance is:" + b1);
//					a.setBalance(b1);
//
//				}
//
//			} else {
//				System.out.println("invalid pin");
//			}
//
//		} else {
//			System.out.println("invalid account number");
//		}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deposit() {

//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter account no");
//		int acc = sc.nextInt();
//		if (acc == a.getAccno()) {
//
//			System.out.println("enter amount for deposit");
//			long w = sc.nextLong();
//			if (w == 0 || w > 5000) {
//				System.out.println("not deposit");
//			} else {
//				long b = a.getBalance();
//				long b1 = b + w;
//				System.out.println("avalible balance is: " + b1);
//				a.setBalance(b1);
//			}
//		} else {
//			System.out.println("invalid account number");
//		}

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "9325572418");
		

			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter account no");
			int acc = sc.nextInt();
			String sql = "select * from account where accountno=" + acc + "";
			Statement pre = con.createStatement();
			ResultSet re=pre.executeQuery(sql);
			
			if(re.next()) {
				
				
			System.out.println("enter deposit amount");
			 upa=sc.nextLong();
			
			String up="update bank.account set balance= balance + "+upa+" where accountno=" + acc +" ";	
			PreparedStatement pre1 = con.prepareStatement(up);
			pre1.execute();
			
			System.out.println("deposit successfully " + upa + "rs");
			
			
			  
			    
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatedetails() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "9325572418");
		Statement smt = con.createStatement();
		
		System.out.println("-----------enter----------- \n1: for update name \n2: for update address \n3: for update mobile number\n---------------------------");
		int no=sc.nextInt();
		switch(no) {
		case 1:{
		
			System.out.println("enter account no");
			int acc = sc.nextInt();
			String sql = "select * from account where accountno=" + acc + "";
			Statement pre = con.createStatement();
			ResultSet re=pre.executeQuery(sql);
			
			if(re.next()) {
				System.out.println("enter update name");
				String name=sc.next();
				String update ="update bank.account set name='"+name+"' where accountno=" + acc + " ";
				smt.execute(update);
				System.out.println("update name successfully");
				
			
			}break;
		}
		
		case 2:{	System.out.println("enter account no");
		int acc = sc.nextInt();
		String sql = "select * from account where accountno=" + acc + "";
		Statement pre = con.createStatement();
		ResultSet re=pre.executeQuery(sql);
		
		if(re.next()) {
			System.out.println("enter new address");
			String name=sc.next();
			String update ="update bank.account set address='"+name+"' where accountno=" + acc + " ";
			smt.execute(update);
			System.out.println("update name successfully");
		}
			
			
		break;}
		
		case 3:{
			System.out.println("enter account no");
			int acc = sc.nextInt();
			String sql = "select * from account where accountno=" + acc + "";
			Statement pre = con.createStatement();
			ResultSet re=pre.executeQuery(sql);
			
			if(re.next()) {
				System.out.println("enter new mobile number ");
				long name=sc.nextLong();
				String update ="update bank.account set mobile='"+name+"' where accountno=" + acc + " ";
				smt.execute(update);
				System.out.println("update mobile number  successfully");
			}
			break;
		}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void transectionHistory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "9325572418");
	
			Scanner sc = new Scanner(System.in);
			System.out.println("enter account no");
			int acc = sc.nextInt();
			String sql = "select * from account where accountno=" + acc + "";
			Statement pre = con.createStatement();
			ResultSet re=pre.executeQuery(sql);
			
			if(re.next()) {
				long we=re.getLong(5)+upa;
				long de=re.getLong(5)-upa;
				if(we>re.getLong(5)){
					System.out.println("last trancestion " + upa + " withdraw ");
				}else if(de<re.getLong(5)) {
					System.out.println("last trancestion " + upa + " deposit ");
				}else {
					System.out.println("no transection");
				}
				
			}
			
			
		
		
		
		}catch(Exception e) {
				
			}
		
	}

}
