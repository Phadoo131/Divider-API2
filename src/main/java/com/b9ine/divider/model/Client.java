package com.b9ine.divider.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLIENT_ID", nullable=false)
	private Integer id;
	
	@Column(name="CLIENT_FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="CLIENT_LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="CLIENT_EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="CLIENT_PHONE_NUM", nullable=false)
	private String phoneNum;
	
	@Column(name = "BOOKER_ADDRESS")
	private String address;
	
	@OneToOne
	@JoinColumn(name = "CITY_ID", nullable=false)
	City city;
	
	@Column(name = "BOOKER_PASSWORD", nullable=false)
	private String pwd;
}
