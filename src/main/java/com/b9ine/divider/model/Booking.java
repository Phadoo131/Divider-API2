package com.b9ine.divider.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOKING_ID", nullable=false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="CLIENT_ID", nullable=false)
	Client clientId;

	@ManyToOne
	@JoinColumn(name="BOOKER_ID", nullable=false)
	Booker bookerId;

	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID", nullable=false)
	Restaurant rsId;

	@Column(name="TIME_STAMP", nullable=false)
	private LocalDate timeStamp;

	@Column(name="Status", nullable=false)
	private String bookingStatus;
}
