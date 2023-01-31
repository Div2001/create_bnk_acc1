package com.proj3;

//import java.util.Dictionary;
//import java.util.Hashtable;
import java.util.Scanner;

public class customer extends bank{
	String bname;
	String cname;
	String caddr;
	String cphno;
	String crn;
	String acc_type;
	String acc_id;
	int bal = 0;
	int min_bal = 0;
	//String[] all_details;
	
	public customer(String b_name) {
		super(b_name);
		// TODO Auto-generated constructor stub
		bname = b_name;
		
	}
	
	public void get_cdetails() {
		Scanner inp = new Scanner(System.in);
		
		System.out.println("enter name: ");
		cname = inp.next();
		
		System.out.println("enter address: ");
		caddr = inp.next();
		
		System.out.println("enter ph_no: ");
		cphno = inp.next();
		
		int min = 1000, max = 2000;
		int rndm = (int)(Math.random()*(max-min+1)+min); 
		//crn = bname+cname+ "yyyy";
		crn = bname+cname+ rndm;
	}
	
	//Not called
	public void disp_cdetails() {
		System.out.println("name: "+ cname);
		System.out.println("addr: "+ caddr);
		System.out.println("ph_no: "+ cphno);
		System.out.println("branch: "+ caddr);
		System.out.println("ifsc: "+ bname+ "xxxx");
		System.out.println("CRN: "+ crn);

	}
	
	public void acc_type() {
		Scanner inp = new Scanner(System.in);
		System.out.println("enter acc type CUR/ SAV/ OD: ");
		acc_type = inp.next();
		acc_type_det tmp = new acc_type_det();
		acc_id = tmp.disp(bname, acc_type, cname);
		System.out.println("deposit the min balance. Enter amt: ");
		int amt = inp.nextInt();
		min_bal = tmp.mbal;
		while (amt < min_bal) {
			System.out.println("Amt lesser than min bal, enter again: ");
			amt = inp.nextInt();
		}
		bal += amt;
		
	}
	
	public void deposit() {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter amt to deposit: ");
		int amt = inp.nextInt();
		bal += amt;
	}
	
	public void withdraw() {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter amt to withdraw: ");
		int amt = inp.nextInt();
		if ((bal-amt) < min_bal) System.out.println("Can't withdraw, Min bal should be maintained !");
		else bal -= amt;
	}
	
//	public String[][] ret_details() {
//		String[][] arr = {{acc_type},{cname, caddr, cphno, crn}};
//		return arr;
//	}
	
	public Object[] ret_details() {
		Object[] all_details = {bname, acc_type, cname, caddr, cphno, crn, acc_id, bal};
		return all_details;
	}

}
