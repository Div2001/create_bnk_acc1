package com.proj3;

//public class Current implements disp_acc_details{
//	@Override
//	public void disp(String bname) {
//		// TODO Auto-generated method stub
//		System.out.println("This is"+
//		bname+ " Current acc"+ bname+ "CURxxxx with INR 1000 as the min balance");
//	}	
//}

public class acc_type_det implements disp_acc_details{
	int mbal;
	@Override
	public String disp(String bname, String acc_ty, String cname) {
		// TODO Auto-generated method stub
		int min = 1000, max = 2000;
		int rndm = (int)(Math.random()*(max-min+1)+min); 
		//String acc_id = bname+ acc_ty+ cname+ "xxxx";
		String acc_id = bname+ acc_ty+ cname+ rndm;
		if (acc_ty.equals("CUR")) {mbal = 1000;}
		if (acc_ty.equals("SAV")) {mbal = 500;}
		if (acc_ty.equals("OD")) {mbal = 2000;}
		System.out.println("This is "+
		bname+ " "+ acc_ty+" acc "+ acc_id+ " with INR "+ mbal+ " as the min balance");
		return acc_id;
	}
	
}
