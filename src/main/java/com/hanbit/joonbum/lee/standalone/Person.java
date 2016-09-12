package com.hanbit.joonbum.lee.standalone;

public class Person {


	private int age;
	private String name;
	private Location location;

	private Female female;

	private class Female{

	}

	public Person(){
		age = 1;
		location = Location.LOC_HOSPITAL;
	}

	public void liveYear(){
		this.age++;
	}

	public int getAge() { //캡슐화
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	private void go(Location location){
		this.location=location;
	}

	public void goHome(){
		go(Location.LOC_HOME);
	}

	public void goSchool(){
		go(Location.LOC_SCHOOL);
	}
	public String toString(){
		String personString = "나이 : " + getAge() + "위치 : " + getLocation();
		return personString;
	}

}
