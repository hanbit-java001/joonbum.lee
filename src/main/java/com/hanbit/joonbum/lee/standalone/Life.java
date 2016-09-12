package com.hanbit.joonbum.lee.standalone;

public class Life {

	public static void main(String[] args) {
		God god = God.pray();


		Person someone = new Person();

//		for (int year = 0; year <100 ; year++){
//
//			if (Location.HOSPITAL.equals(someone.getLocation().getName())
//					&& someone.getAge()==1){
//				someone.goHome();
//			}
//
//			System.out.println(someone);
//
//			someone.liveYear();

		Location somewhere = new School("서울");
		Location hospital = new Hospital("경기");

//		somewhere.getAvgSize();
//		hospital.getAvgSize();



//        }
	}
}
