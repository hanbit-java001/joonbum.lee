package com.hanbit.joonbum.lee.standalone;

public class God {

	private static God god;

	private God(){

	}

	public static God pray(){
		if(god == null){
			god = new God();
		} //하나만 객체가 생성되게끔 하는 방법

		return god;
	}
}
