package com.lithan;

import java.util.Arrays;

public class Store {
String name;
String phoneNumber;
String[] localities;
public Store(String name, String phone_number, String[] localities) {
	super();
	this.name = name;
	this.phoneNumber = phone_number;
	this.localities = localities;
}
public Store() {}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phone_number) {
	this.phoneNumber = phone_number;
}
public String[] getLocalities() {
	return localities;
}
public void setLocalities(String[] localities) {
	this.localities = localities;
}
@Override
public String toString() {
	return "Store [name=" + name + ", phoneNumber=" + phoneNumber + ", localities=" + Arrays.toString(localities)
			+ "]";
}
}
