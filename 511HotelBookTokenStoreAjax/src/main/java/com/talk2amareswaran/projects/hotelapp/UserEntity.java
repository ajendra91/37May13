package com.talk2amareswaran.projects.hotelapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String passsword;
	private String firstname;
	private String lastname;
	private String role;
	
	public UserEntity(String email, String passsword, String firstname, String lastname, String role) {
		super();
		this.email = email;
		this.passsword = passsword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}
	
	
	
	
}
