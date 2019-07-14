package com.eksad.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.rest.dao.BrandDao;
import com.eksad.rest.dao.ProductDao;
import com.eksad.rest.entity.Brand;
import com.eksad.rest.entity.Product;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	BrandDao brandDao;
	
	@RequestMapping("getByBrandId/{brandId}")
	public List<Product> getByBrandId(@PathVariable Long brandId) {
		List<Product> result = new ArrayList<Product>();
		productDao.findByBrandId(brandId).forEach(result::add);
		return result;
	}
	
// -----------------------------------------------------------------------
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Product save(@RequestBody Product product) {
		Brand brand = brandDao.findById(product.getBrandId()).orElse(null);
		if(brand != null) {
			product.setBrand(brand);
			return productDao.save(product);
		}
		return null;
	}
	
// ------------------------------------------------------------------
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product productSelected = productDao.findById(id).orElse(null);
		if(productSelected != null) {
			productSelected.setName(product.getName());
			return productDao.save(productSelected);
//			return "Data Berhasil Diperbaharui!";
		} else {
			return null;
		}
	}
	
// ---------------------------------------------------------------------------
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public HashMap<String, Object> delete(@PathVariable Long id) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		productDao.deleteById(id);
		result.put("message", "Data Berhasil Dihapus!");
		return result;
	}
	
// -----------------------------------------------------------------------
	
	@RequestMapping("getBySearch/{search}")
	public List<Product> getBySearch(@PathVariable String search) {
		List<Product> hasil = new ArrayList<Product>();
		productDao.findBySearch(search).forEach(hasil::add);
		return hasil;
	}

}
