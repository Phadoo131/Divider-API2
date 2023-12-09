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
@Table(name = "restaurants")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESTAURANT_ID")
	private Integer id;
	
	@Column(name="RESTAURANT_NAME", nullable=false)
	private String rsName;
	
	@Column(name="CONTACT_NUM", nullable=false)
	private String contactNum;
	
	@Column(name="Address", nullable=false)
	private String address;
	
	@OneToOne
	@JoinColumn(name = "CITY_ID", nullable=false)
	City city;
}
