package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_district")
public class District {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")

	@Column(name="districtid")
    private int districtId;
	
	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Column(name="districtname")
	private String districtName;
	
	@Column(name="croptypeids")
	private String cropTypeIds;

	public String getCropTypeIds() {
		return cropTypeIds;
	}

	public void setCropTypeIds(String cropTypeIds) {
		this.cropTypeIds = cropTypeIds;
	}

	
	
}