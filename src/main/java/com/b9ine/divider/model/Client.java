package com.b9ine.divider.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

	@OneToMany(mappedBy = "clientId")
	private List<Booking> bookings;

	@OneToOne
	@JoinColumn(name = "USER_ID", nullable=false, unique=true)
	private UserEntity userEntity;
}
