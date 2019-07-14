package com.eksad.rest.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

//@Data
//@Entity
//@Table(name = "product")
//public class Product {
//	
//	@Id
//	
//	// generated valuenya bisa milih mau pake SEQUENCE atau IDENTITY
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, // kayak counter (penghitung) di database, digunakan kalau gaada default value nya
//			generator = "product_id")
//	@SequenceGenerator(name = "product_id",
//			sequenceName = "product_id_seq",
//			allocationSize = 1) // buat nandain kalo naiknya itu satu angka(ditambah 1 tiap ngeadd)
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	
//	private long id;
//	
//	// kenapa many to one? ini kan class produk, nah produk itu punya satu merk
//	// contoh = laptop 1 laptop 2 itu brand nya lenovo
//	// berarti laptop nya banyak, brandnya 1 yaitu lenovo, makanya bilangnya many to one
//	// kalo ini di class brand, maka akan jadi one to many
//	@ManyToOne // untuk ngasih tau ke jpa bahwa class ini punya relasi ke class Brand
//	@JoinColumn(name = "brand_id") // ini tuh colomn nya yang mana yang mau di join
//	private Brand brand;
//	
//	@Column(nullable = false)
//	private String name;
//	
//	@Column(nullable = false)
//	private BigDecimal price; // sifatnya sama kayak double, diperuntukkan untuk uang
//	
//
//}

// -----------------------------------------------------------------------------------------------------------------

@Data
@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	// ini punya si Long id
	// generated valuenya bisa milih mau pake SEQUENCE atau IDENTITY
//	@GeneratedValue(strategy = GenerationType.IDENTITY, // kayak counter (penghitung) di database, digunakan kalau gaada default value nya
//			generator = "product_id")
//	@SequenceGenerator(name = "product_id",
//			sequenceName = "product_id_seq",
//			allocationSize = 1) // buat nandain kalo naiknya itu satu angka(ditambah 1 tiap ngeadd)

	
	
	
	// kenapa many to one? ini kan class produk, nah produk itu punya satu merk
	// contoh = laptop 1 laptop 2 itu brand nya lenovo
	// berarti laptop nya banyak, brandnya 1 yaitu lenovo, makanya bilangnya many to one
	// kalo ini di class brand, maka akan jadi one to many
	@ManyToOne // untuk ngasih tau ke jpa bahwa class ini punya relasi ke class Brand
	@JoinColumn(name = "brand_id") // ini tuh colomn nya yang mana yang mau di join
	private Brand brand;
	
	@Transient
	private Long brandId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private BigDecimal price; // sifatnya sama kayak double, diperuntukkan untuk uang
	

}
