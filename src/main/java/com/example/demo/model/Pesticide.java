package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_pesticide")
public class Pesticide{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
	@Column(name="pesticideid")
    private int pesticideId;

	@Column(name="cropid")
    private String cropId;
	
	
	
	@Column(name="disease")
    private String disease;
	
	@Column(name="solution")
    private String solution;

	public String getCropId() {
		return cropId;
	}

	public void setCropId(String cropId) {
		this.cropId = cropId;
	}

	public int getPesticideId() {
		return pesticideId;
	}

	public void setPesticideId(int pesticideId) {
		this.pesticideId = pesticideId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	
}
