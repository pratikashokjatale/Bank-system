package com.app.info.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	private int accno;
	private String name;
	private long mobileno;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Trancestion> tr = new LinkedHashSet<>();
	
	public Set<Trancestion> getTr() {
		return tr;
	}
	public void setTr(Set<Trancestion> tr) {
		this.tr = tr;
	}
	private long aadhar;
	private String qddr;
	private long balance;
	
	
	private int pin;
	private int age; 
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getQddr() {
		return qddr;
	}
	public void setQddr(String qddr) {
		this.qddr = qddr;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	

	
}


