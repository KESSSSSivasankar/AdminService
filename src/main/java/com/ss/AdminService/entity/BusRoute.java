package com.ss.AdminService.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusRoute {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long busId;
	@Column 
	private String busSource;
	@Column 
	private String busDestination;
	@Column 
	private String busprice;

}
