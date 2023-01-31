package com.proj3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		
		System.out.println("no. of customers to b added: ");
		int no_of_cus = inp.nextInt();
	
		customer[] arr_objs = new customer[no_of_cus];
		HashMap<String, customer> id_dets = new HashMap<>(); 
		// stores accid: customer_obj
		int cb_cus_no = 0;
		int sbi_cus_no = 0;
		
		for(int i=0; i<no_of_cus; i++) {
			String cus_no = "Cust"+ (i+1);
			System.out.println(cus_no);
			System.out.println("enter bank name CB/SBI: ");
			String c1bname = inp.next();
			arr_objs[i] = new customer(c1bname);
			arr_objs[i].disp_bname();
			arr_objs[i].get_cdetails();
			//customer1.disp_cdetails();
			arr_objs[i].acc_type();	
			if (arr_objs[i].bname.equals("CB")) cb_cus_no += 1;
			else sbi_cus_no += 1;
			
			id_dets.put(arr_objs[i].acc_id, arr_objs[i]);
		}
		
		//String[][] all_cus_dets = new String[no_of_cus][]; 
		
		/*for(int i=0; i<no_of_cus; i++) {
			//System.out.println(Arrays.toString(arr_objs[i].ret_details()));
			all_cus_dets[i] = arr_objs[i].ret_details();
			//id_dets.put(null, null)
			if (all_cus_dets[i][0].equals("CB")) cb_cus_no += 1;
			else sbi_cus_no += 1;
		}*/
		
		//String[][] cb_cus_dets = new String[cb_cus_no][]; 
		//String[][] sbi_cus_dets = new String[sbi_cus_no][];  
		customer[] cb_cus = new customer[cb_cus_no];
		customer[] sbi_cus = new customer[sbi_cus_no];
		
		int m = 0, n =0;
		for(int i=0; i<no_of_cus; i++) {
			//System.out.println(Arrays.toString(arr_objs[i].ret_details()));
			/*if (all_cus_dets[i][0].equals("CB")) {
				cb_cus_dets[m] = all_cus_dets[i]; m += 1;
				
			}
			else {
				sbi_cus_dets[n] = all_cus_dets[i]; n += 1;
			}*/	
			if (arr_objs[i].bname.equals("CB")){
				cb_cus[m] = arr_objs[i]; m += 1;				
			}
			else {
				sbi_cus[n] = arr_objs[i]; n += 1;
			}
		}
		
		System.out.println("----");
		
		
		// Transaction part
		String acc_no_req;
		while (true) {
			System.out.println("Want to perform transaction? Yes/No: ");
			String trans = inp.next();
			if (trans.equals("Yes")) {
				System.out.println("Enter acc no.: ");
				acc_no_req = inp.next();
				if (id_dets.containsKey(acc_no_req)) {
					String op;
					
					customer obj = id_dets.get(acc_no_req);
					System.out.println("Deposit/ Withdraw (Dep/With): ");
					op = inp.next();
					if (op.equals("Dep")) id_dets.get(acc_no_req).deposit();
					else obj.withdraw();
				}
				else System.out.println("Acc does not exist");
			}
			else break;
		}
		
		try {
			BufferedWriter  myWriter = new BufferedWriter (new FileWriter("bnk_op.txt"));
			if (cb_cus_no > 0) {
				//System.out.println("CB customer details are:");
				myWriter.write("CB customer details are:\n");
				//for(String[] c: cb_cus_dets) myWriter.write(Arrays.toString(c)+"\n");
				for(customer c: cb_cus) myWriter.write(Arrays.toString(c.ret_details())+"\n");
			}
			
			if (sbi_cus_no > 0) {
				myWriter.write("SBI customer details are:\n");
				//for(String[] c: sbi_cus_dets) myWriter.write(Arrays.toString(c)+"\n");
				for(customer c: sbi_cus) myWriter.write(Arrays.toString(c.ret_details())+"\n");
			}
			
			myWriter.write("----------******-----------");
			myWriter.close();
			System.out.println("Successfully printed in file!!");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}

}
