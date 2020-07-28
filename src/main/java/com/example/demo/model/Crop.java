package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_crop")
public class Crop {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")

	@Column(name="cropid")
    private int cropId;
	
	@Column(name="cropname")
	private String cropName;
	
	@Column(name="croptypeid")
	private String cropTypeId;
	
	@Column(name="cropdesc")
	private String cropDesc;
	
	@Column(name="cropimg")
	private String cropImg;
	
	@Column(name="climate")
	private String cliMate;
	
	@Column(name="timeperiod")
	private String timePeriod;
	
	@Column(name="soilrequirement")
	private String soilRequirement;
	
	@Column(name="landpreparation")
	private String landPreparation;
	
	@Column(name="sowing")
	private String sowIng;
	
	@Column(name="irrigation")
	private String irrigation;

	public String getCliMate() {
		return cliMate;
	}

	public void setCliMate(String cliMate) {
		this.cliMate = cliMate;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public String getSoilRequirement() {
		return soilRequirement;
	}

	public void setSoilRequirement(String soilRequirement) {
		this.soilRequirement = soilRequirement;
	}

	public String getLandPreparation() {
		return landPreparation;
	}

	public void setLandPreparation(String landPreparation) {
		this.landPreparation = landPreparation;
	}

	public String getSowIng() {
		return sowIng;
	}

	public void setSowIng(String sowIng) {
		this.sowIng = sowIng;
	}

	public String getIrrigation() {
		return irrigation;
	}

	public void setIrrigation(String irrigation) {
		this.irrigation = irrigation;
	}

	public String getCropImg() {
		return cropImg;
	}

	public void setCropImg(String cropImg) {
		this.cropImg = cropImg;
	}

	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropTypeId() {
		return cropTypeId;
	}

	public void setCropTypeId(String cropTypeId) {
		this.cropTypeId = cropTypeId;
	}

	public String getCropDesc() {
		return cropDesc;
	}

	public void setCropDesc(String cropDesc) {
		this.cropDesc = cropDesc;
	}
	
}
