package com.app.sbi;

import java.util.Scanner;

import com.app.info.model.Account;
import com.app.info.model.Account1;
import com.app.rbi.*;
import java.util.*;

public class SBI1 implements RBI1 {
	Scanner sc = new Scanner(System.in);
	long w;
	long d;
	Account1 a;
	Account1 a1[];

//	int age=a.getAge();
	@Override

	public void createAccount() {

		System.out.println("How many acc you want to create");
		int noacc = sc.nextInt();
		a1 = new Account1[noacc];

		for (int i = 0; i < a1.length; i++) {
			a = new Account1();
			System.out.println("start createing bank account");
			System.out.println("enter name");
			String name = sc.next();

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
				} else {
					System.out.println("enter valid account no");
				}

				if (count2 == 5) {
					break;
				}
			}

			System.out.println("enter balance");
			int bal = sc.nextInt();
			a.setBalance(bal);

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
			} else {
				System.out.println("enter valid account no");
			}

			a1[i] = a;
		}

	}

	@Override
	public void checkBalance() {

		a = new Account1();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter account no");
		int acc = sc.nextInt();
		
			for(Account1 a:a1) {
		if (acc == a.getAccno()) {

			System.out.println("avalible balance " + a.getBalance());

		} }

	}

	@Override
	public void showtails() {

		for (Account1 a : a1) {

			System.out.println("holder name is : " + a.getName());
			System.out.println("holder Account no is : " + a.getAccno());
			System.out.println("holder Adhar no is : " + a.getAadhar());
			System.out.println("holder mobile no is : " + a.getMobileno());
			System.out.println("holder address is : " + a.getQddr());
			System.out.println("avalible balance : " + a.getBalance());
			System.out.println();
		}

	}

	@Override
	public void withdraw() {
		System.out.println("enter account no");
		int acc = sc.nextInt();
		for (Account1 a : a1) {

			Scanner sc = new Scanner(System.in);

			if (acc == a.getAccno()) {
				System.out.println("enter account pin");
				int pin = sc.nextInt();
				if (pin == a.getPin()) {
					System.out.println("enter amount for withdraw");
					w = sc.nextLong();

					if (a.getBalance() < 1000 || w == 0) {

						System.out.println("not withdraw");
					} else {
						long b = a.getBalance();
						long b1 = b - w;

						System.out.println("avalible balance is:" + b1);
						a.setBalance(b1);

					}

				} else {
					System.out.println("invalid pin");
				}

			}
		}

	}

	@Override
	public void deposit() {

		System.out.println("enter account no");
		int acc = sc.nextInt();

		for (Account1 a : a1) {

			Scanner sc = new Scanner(System.in);

			if (acc == a.getAccno()) {

				System.out.println("enter amount for deposit");
				w = sc.nextLong();
				if (w == 0 || w > 5000) {
					System.out.println("not deposit");
				} else {
					long b = a.getBalance();
					long b1 = b + w;
					System.out.println("avalible balance is: " + b1);

					a.setBalance(b1);
					break;
				}
			}

		}

	}

	@Override

	public void update() {

		System.out.println("enter account no");
		int acc = sc.nextInt();
		a = new Account1();
		for (Account1 a : a1) {
			try {
				if (acc == a.getAccno()) {
					System.out.println("enter 1 for update name 2 for mobile no 3 for address 4 for set new pin");
					int no = sc.nextInt();

					switch (no) {

					case 1: {
						System.out.println("enter your updated name");
						String uname = sc.next();
						a.setName(uname);
						break;
					}
					case 2: {
						System.out.println("enter mobile no for update");
						long umobile = sc.nextLong();
						a.setMobileno(umobile);
						break;
					}
					case 3: {
						System.out.println("enter address for updte");
						String uaddr = sc.next();
						a.setQddr(uaddr);
						break;
					}
					case 4: {
						System.out.println("set new pin");
						int upin = sc.nextInt();
						a.setPin(upin);
						break;
					}

					}
				}
			} catch (NullPointerException e) {
				System.out.println("first creat your account");
			} catch (InputMismatchException e) {
				System.out.println("mismatch input");
			}
		}

	}

	@Override
	public void transhistory() {
		System.out.println("enter account no");
		int acc = sc.nextInt();

		try {
			if (acc == a.getAccno()) {
				
				long b1 = w;
				System.out.println("you withdraw/deposit " + b1);
				System.out.println("your avalible balance is " + a.getBalance());
			}

		} catch (NullPointerException e) {
			System.out.println("create account first and deposit and withdraw balance");
		}

	}

}
