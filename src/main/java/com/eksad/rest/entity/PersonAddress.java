package com.eksad.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "person_address")

public class PersonAddress {
	
	@Id
	@Column(name = "person_id")
	private Long id;
	
	@ToString.Exclude // karena sifatnya bidirectional(dua arah), kalo gapake exclude bakal ngulang-ngulang terus
	@OneToOne
	@MapsId // tujuannya adalah pada saat save, id person bakal masuk ke person_id
	private Person person;
	
	@Column(nullable = false)
	private String address;
	
	
	private String city;

}
