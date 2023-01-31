package com.proj3;

public class bank {
	String bname = "bank_name";
	public bank(String name) {
		bname = name;
	}
	
	void disp_bname() {
		System.out.println("Welcome! This is "+ bname+ " bank");
	}
}
