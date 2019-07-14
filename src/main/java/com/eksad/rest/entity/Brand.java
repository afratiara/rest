package com.eksad.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter @Setter
//@EqualsAndHashCode
//@ToString

//@Data // kependekan dari @getter, @setter, @to string, @equalsandhashcode
//@Entity
//@Table(name = "brand")
//public class Brand {
//	
//	@Id // karna dia primary key
//	@GeneratedValue (strategy = GenerationType.IDENTITY) // karna sifatnya bertingkat atau increment
//	private long id;
//	
//	@Column(nullable = false)
//	private String name;
//	
//	@Column(name = "product_type") // ngasih tau kalo nama di pgAdmin itu product_type
//	private String productType;
//
//}

// ------------------------------------------------------------------------------------------------------------------


@Data // kenapa datanya jadi tanda kuning? belum ngasih tau ke si lombok, ini manggil value parent lagi apa engga?
@EqualsAndHashCode(callSuper = true) // true : inculde si parent, jadinya parent diitung juga, kalo false engga
@ToString(callSuper = true)
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "product_type")
	private String productType;
	
	// nge run nya di supermarketApplication yang bagian brandDao.findAll

}