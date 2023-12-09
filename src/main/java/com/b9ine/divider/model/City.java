package com.b9ine.divider.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cities")
public class City {
	
	@Id
	@Column(name="CITY_ID", nullable=false)
	private String cityId;
	
	@Column(name="CITY_NAME", nullable=false)
	private String cityName;
	
}
