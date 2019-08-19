package com.bankguru.account;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerDataJson {
	
	//Constructor
	public static CustomerDataJson get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(filename), CustomerDataJson.class);
	}
	//
	@JsonProperty("customerName")
	String customerName;
	
	@JsonProperty("gender")
	String gender;
	
	@JsonProperty("dateOfBirth")
	String dateOfBirth;
	
	@JsonProperty("address")
	String address;
	
	@JsonProperty("city")
	String city;
	
	@JsonProperty("state")
	String state;
	
	@JsonProperty("pin")
	String pin;
	
	@JsonProperty("phone")
	String phone;
	
	@JsonProperty("emailNewCustomer")
	String emailNewCustomer;
	
	public String getCustomerName() {
		return customerName;
	}
	public String getGender() {
		return gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return customerName;
	}
	public String getState() {
		return state;
	}
	public String getPin() {
		return pin;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmailNewCustomer() {
		return emailNewCustomer;
	}
	
	
	public int randomNumber() {
		Random rd = new Random();
		return rd.nextInt(10000);
	}
	
	
}
