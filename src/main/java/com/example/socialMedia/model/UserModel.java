package com.example.socialMedia.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Component
public class UserModel {
	private Integer id;
	@Size(min = 5, message = "Name should contain 5 letters")
	private String name;
	@Past(message = "Date should pe past")
	private LocalDate date;

	public UserModel() {

	}

	public UserModel(Integer id, String name, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
