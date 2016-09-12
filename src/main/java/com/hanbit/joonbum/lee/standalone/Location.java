package com.hanbit.joonbum.lee.standalone;

public class Location { // 추상클래스는 정의가 덜된 클래스라 객체생성 안됨

	public static final String HOSPITAL = "병원";
	public static final String HOME = "집";
	public static final String SCHOOL = "학교";

	public static Location LOC_HOME = new Location(HOME, "서울 강서구");
	public static Location LOC_HOSPITAL = new Location(HOSPITAL, "서울 마포구");
	public static Location LOC_SCHOOL = new School("서울 은평구");

	//가능 하위개념 스쿨에서 상위개념 로케이션으로 갈수 있다.
	public static Object someObject = new School("서울 강남구");


	private String name;
	private String address; // String 기본 null

	private boolean opened; // boolean 기본 false
	private boolean toilet;

	private int rooms; //int 는 기본 0

	public Location(String name, String adress){
		this.name = name;
		this.address = address;

		Location school = new School("서울");

		if (school instanceof School){

			School middleSchool = (School) school;
		}
	}

	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public String toString(){
		return name;
	}
	public int getRooms(){
		return rooms;
	}
	public boolean isOpened(){
		return opened;
	}
	public boolean hasToilet(){
		return toilet;
	}
}








