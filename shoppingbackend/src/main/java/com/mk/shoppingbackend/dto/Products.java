package com.mk.shoppingbackend.dto;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prdid;
	private String prdname;
	private int prdprice;
	private String prdsize;
	private String prddisc; 
	private String prdimgURL;
	private int categoryid;
	private boolean active = true;
	
	@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	
	@Transient
	private MultipartFile file;
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	
		public int getPrdid() {
		return prdid;
	}

	public void setPrdid(int prdid) {
		this.prdid = prdid;
	}

	public String getPrdname() {
		return prdname;
	}

	public void setPrdname(String prdname) {
		this.prdname = prdname;
	}

	public int getPrdprice() {
		return prdprice;
	}

	public void setPrdprice(int prdprice) {
		this.prdprice = prdprice;
	}

	public String getPrdsize() {
		return prdsize;
	}

	public void setPrdsize(String prdsize) {
		this.prdsize = prdsize;
	}

	public String getPrddisc() {
		return prddisc;
	}

	public void setPrddisc(String prddisc) {
		this.prddisc = prddisc;
	}

	public String getPrdimgURL() {
		return prdimgURL;
	}

	public void setPrdimgURL(String prdimgURL) {
		this.prdimgURL = prdimgURL;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
