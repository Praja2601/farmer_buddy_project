package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Crop;
import com.example.demo.model.CropType;
import com.example.demo.model.District;
import com.example.demo.model.Pesticide;
import com.example.demo.repo.CropRepository;
import com.example.demo.repo.CropTypeRepository;
import com.example.demo.repo.DistrictRepository;
import com.example.demo.repo.PesticideRepository;


@Component
@Path("/crop")
public class CropController {
	
	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	CropTypeRepository cropTypeRepository;
	
	@Autowired
	CropRepository cropRepository;
	
	@Autowired
	PesticideRepository pesticideRepository;
	
	@GET
	@Path("/getAllDistricts")
	@Produces("text/html")
	public String getAllDistricts()
	{
		List <District> districts =districtRepository.findAll();
		JSONArray districtArray = new JSONArray();
		JSONObject districtObject = null;
		if(districts != null)
		{
			if(districts.size()>0)
			{
				for(District district : districts)
				{
					districtObject = new JSONObject();
					districtObject.put("status","ok");
					districtObject.put("id", district.getDistrictId());
					districtObject.put("districtname", district.getDistrictName());
					districtObject.put("croptypeids", district.getCropTypeIds());
					districtArray.put(districtObject);   //[{"id":1, "croptypeid":"1,2,3,4","districtnmae":"Ahmednagar"}]
				}
			}
			else
			{
				districtObject = new JSONObject();
				districtObject.put("status", "no records for districts");
				districtArray.put(districtObject);
			}
		}
		else
		{
			districtObject = new JSONObject();
			districtObject.put("status", "no records for districts");
			districtArray.put(districtObject);
		}
		return districtArray.toString();
		//return districtId+" "+ dt.getDistrictName();
		
	}
	
	@GET
	@Path("/croptypes")
	@Produces("text/html")
	public String test(@QueryParam ("croptypeids") String cropTypeIds)
	{
		JSONArray cropTypeArray = new JSONArray();
		JSONObject cropTypeObject = null;
		
		List<Integer> ids = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(cropTypeIds,",");
		while(st.hasMoreElements())
			ids.add(Integer.parseInt(st.nextToken()));
		List<CropType> croptypes = cropTypeRepository.findByCropTypeIdsIn(ids);
		if(croptypes != null)
		{
			if(croptypes.size()>0)
			{
				for(CropType cp : croptypes) {
					System.out.println(cp.getCropTypeName()+" "+cp.getCropTypeId());
					cropTypeObject = new JSONObject();
					cropTypeObject.put("status", "ok");
					cropTypeObject.put("croptypeid", cp.getCropTypeId());
					cropTypeObject.put("croptypename", cp.getCropTypeName());
					cropTypeArray.put(cropTypeObject);
				}
			}
			else
			{
				cropTypeObject = new JSONObject();
				cropTypeObject.put("status", "no records for croptypes");
				cropTypeArray.put(cropTypeObject);
			}
		}
		else
		{
			cropTypeObject = new JSONObject();
			cropTypeObject.put("status", "no records for croptypes");
			cropTypeArray.put(cropTypeObject);
		}
		return cropTypeArray.toString();
		//return districtId+" "+dt.getDistrictName()+" "+dt.getCropTypeIds();
	}
	
	@GET
	@Path("/crops")
	@Produces("text/html")
	public String getCropsDetails(@QueryParam ("croptypeid") String cropTypeId)
	{
		JSONArray cropArray = new JSONArray();
		JSONObject cropObject = null;
		
		//List<String> ids = new ArrayList<>();
		//StringTokenizer st = new StringTokenizer(cropTypeId,",");
		//while(st.hasMoreElements())
			//ids.add(st.nextToken());
		List<Crop> crops = cropRepository.findByCropTypeIdsIn(cropTypeId);
		
		if(crops != null)
		{
			if(crops.size()>0)
			{
				for(Crop cp : crops) {
					System.out.println(cp.getCropName()+" "+cp.getCropTypeId() + "  "+cp.getCropId()+" "+cp.getFertilizer());
					cropObject = new JSONObject();
					cropObject.put("status", "ok");
					cropObject.put("croptypeid", cp.getCropTypeId());
					cropObject.put("cropname", cp.getCropName());
					cropObject.put("cropid", cp.getCropId());
					cropObject.put("cropdesc", cp.getCropDesc());
					cropObject.put("climate", cp.getCliMate());
					cropObject.put("timeperiod", cp.getTimePeriod());
					cropObject.put("soilrequirement", cp.getSoilRequirement());
					cropObject.put("landpreparation", cp.getLandPreparation());
					cropObject.put("sowing", cp.getSowIng());
					cropObject.put("irrigation", cp.getIrrigation());
					cropObject.put("cropimg", cp.getCropImg());
					cropObject.put("fertilizer", cp.getFertilizer());
					cropArray.put(cropObject);
				}
			}
			else
			{
				cropObject = new JSONObject();
				cropObject.put("status", "notok");
				cropArray.put(cropObject);
			}
		}
		else
		{
			cropObject = new JSONObject();
			cropObject.put("status", "notok");
			cropArray.put(cropObject);
		}
		return cropArray.toString();
	}
	
	@GET
	@Path("/crop")
	@Produces("text/html")
	public String getCropDetail(@QueryParam ("cropid") int cropId)
	{
		JSONArray cropdescArray = new JSONArray();
		JSONObject cropdescObject = null;
		
		Crop crop = cropRepository.findById(cropId).get();
		
		if(crop != null)
		{
			cropdescObject = new JSONObject();
			cropdescObject.put("status", "ok");
			cropdescObject.put("cropid",crop.getCropId());
			cropdescObject.put("cropdesc",crop.getCropDesc());
			cropdescObject.put("climate", crop.getCliMate());
			cropdescObject.put("soilrequirement", crop.getSoilRequirement());
			cropdescObject.put("timeperiod", crop.getTimePeriod());
			cropdescObject.put("landpreparation", crop.getLandPreparation());
			cropdescObject.put("sowing", crop.getSowIng());
			cropdescObject.put("irrigation", crop.getIrrigation());
			cropdescObject.put("cropimg", crop.getCropImg());
			cropdescObject.put("fertilizer", crop.getFertilizer());
			cropdescArray.put(cropdescObject);
		}
		else
		{
			cropdescObject = new JSONObject();
			cropdescObject.put("status", "notok");
			cropdescArray.put(cropdescObject);
		}
		return cropdescArray.toString();
			
	}
	
	@GET
	@Path("/pesticide")
	@Produces("text/html")
	public String getPesticide(@QueryParam ("cropid") String cropId)
	{
		JSONArray pesticideArray = new JSONArray();
		JSONObject pesticideObject = null;
		
		List<Pesticide> pesticide = pesticideRepository.findByCropIdsIn(cropId);
		
		if(pesticide != null)
		{
			if(pesticide.size()>0)
			{
				for(Pesticide pest : pesticide) {
					System.out.println(pest.getPesticideId()+" "+pest.getDisease()+" "+pest.getSolution()+" "+pest.getCropId());
					pesticideObject = new JSONObject();
					pesticideObject.put("status", "ok");
					pesticideObject.put("cropid", pest.getCropId());
					pesticideObject.put("pesticideid", pest.getPesticideId());
					pesticideObject.put("disease", pest.getDisease());
					pesticideObject.put("solution", pest.getSolution());
					pesticideArray.put(pesticideObject);
				}
			}
			else
			{
				pesticideObject = new JSONObject();
				pesticideObject.put("status", "notok");
				pesticideArray.put(pesticideObject);
			}
		}
		else
		{
			pesticideObject = new JSONObject();
			pesticideObject.put("status", "notok");
			pesticideArray.put(pesticideObject);
		}
		
		return pesticideArray.toString();
	}
	
	
	public static  void main(String args[])
	{
		
	}
}