package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_croptype")
public class CropType {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")

	@Column(name="croptypeid")
    private int cropTypeId;
	
	@Column(name="croptypename")
	private String cropTypeName;

	public int getCropTypeId() {
		return cropTypeId;
	}

	public void setCropTypeId(int cropTypeId) {
		this.cropTypeId = cropTypeId;
	}

	public String getCropTypeName() {
		return cropTypeName;
	}

	public void setCropTypeName(String cropTypeName) {
		this.cropTypeName = cropTypeName;
	}
}
