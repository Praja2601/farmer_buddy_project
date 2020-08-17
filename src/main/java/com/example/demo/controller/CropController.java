package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Crop;
import com.example.demo.model.CropType;
import com.example.demo.model.District;
import com.example.demo.model.Pesticide;
import com.example.demo.repo.CropRepository;
import com.example.demo.repo.CropTypeRepository;
import com.example.demo.repo.DistrictRepository;
import com.example.demo.repo.FertilizerRepository;
import com.example.demo.repo.PesticideRepository;

@RestController
@RequestMapping("/crop")
public class CropController {
	
	private static final String STATUS = "status";
	private static final String NOTOK = "notok";
	private static final String CROPID = "cropid";
	private static final String CROPIMG = "cropimg";
	private static final String CROPNAME = "cropname";
	private static final String FERTILIZER = "fertilizer";
	
	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	CropTypeRepository cropTypeRepository;
	
	@Autowired
	CropRepository cropRepository;
	
	@Autowired
	PesticideRepository pesticideRepository;
	
	@Autowired
	FertilizerRepository fertilizerRepository;
	
	@GetMapping(value="/getAllDistricts")//, method=RequestMethod.GET,produces = "text/html")
	public String getAllDistricts()
	{
		List <District> districts =districtRepository.findAll();
		JSONArray districtArray = new JSONArray();
		JSONObject districtObject = null;
		if(districts != null)
		{
			if(!districts.isEmpty())
			{
				for(District district : districts)
				{
					districtObject = new JSONObject();
					districtObject.put(STATUS,"ok");
					districtObject.put("id", district.getDistrictId());
					districtObject.put("districtname", district.getDistrictName());
					districtObject.put("croptypeids", district.getCropTypeIds());
					districtArray.put(districtObject);   //[{"id":1, "croptypeid":"1,2,3,4","districtnmae":"Ahmednagar"}]
				}
			}
			else
			{
				districtObject = new JSONObject();
				districtObject.put(STATUS, "no records for districts");
				districtArray.put(districtObject);
			}
		}
		else
		{
			districtObject = new JSONObject();
			districtObject.put(STATUS, "no records for districts");
			districtArray.put(districtObject);
		}
		return districtArray.toString();
	
	}
	
	@GetMapping(value="/getAllCrops")//, method=RequestMethod.GET,produces = "text/html")
	public String getAllCrops()
	{
		List <Crop> crops =cropRepository.findAll();
		JSONArray cropArray = new JSONArray();
		JSONObject cropObject = null;
		if(crops != null)
		{
			if(!crops.isEmpty())
			{
				for(Crop crop : crops)
				{
					cropObject = new JSONObject();
					cropObject.put(STATUS,"ok");
					cropObject.put("cropid", crop.getCropId());
					cropObject.put(CROPNAME, crop.getCropName());
					
					cropArray.put(cropObject);   //[{"id":1, "croptypeid":"1,2,3,4","districtnmae":"Ahmednagar"}]
				}
			}
			else
			{
				cropObject = new JSONObject();
				cropObject.put(STATUS, "no records for crops");
				cropArray.put(cropObject);
			}
		}
		else
		{
			cropObject = new JSONObject();
			cropObject.put(STATUS, "no records for crops");
			cropArray.put(cropObject);
		}
		return cropArray.toString();
	
	}
	
	
	@GetMapping(value="/croptypes")//, method=RequestMethod.GET,produces = "text/html")
	public String test(@RequestParam (name="croptypeids") String cropTypeIds)
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
			if(!croptypes.isEmpty())
			{
				for(CropType cp : croptypes) {
					System.out.println(cp.getCropTypeName()+" "+cp.getCropTypeId());
					cropTypeObject = new JSONObject();
					cropTypeObject.put(STATUS, "ok");
					cropTypeObject.put("croptypeid", cp.getCropTypeId());
					cropTypeObject.put("croptypename", cp.getCropTypeName());
					cropTypeArray.put(cropTypeObject);
				}
			}
			else
			{
				cropTypeObject = new JSONObject();
				cropTypeObject.put(STATUS, "no records for croptypes");
				cropTypeArray.put(cropTypeObject);
			}
		}
		else
		{
			cropTypeObject = new JSONObject();
			cropTypeObject.put(STATUS, "no records for croptypes");
			cropTypeArray.put(cropTypeObject);
		}
		return cropTypeArray.toString();
	}
	
	
	@GetMapping(value="/crops")//, method=RequestMethod.GET,produces = "text/html")
	public String getCropsDetails(@RequestParam (name="croptypeid") String cropTypeId)
	{
		JSONArray cropArray = new JSONArray();
		JSONObject cropObject = null;
		
		List<Crop> crops = cropRepository.findByCropTypeIdsIn(cropTypeId);
		
		if(crops != null)
		{
			if(!crops.isEmpty())
			{
				for(Crop cp : crops) {
					System.out.println(cp.getCropName()+" "+cp.getCropTypeId() + "  "+cp.getCropId()+" "+cp.getFertilizer());
					cropObject = new JSONObject();
					cropObject.put(STATUS, "ok");
					cropObject.put("croptypeid", cp.getCropTypeId());
					cropObject.put(CROPNAME, cp.getCropName());
					cropObject.put(CROPID, cp.getCropId());
					cropObject.put("cropdesc", cp.getCropDesc());
					cropObject.put("climate", cp.getCliMate());
					cropObject.put("timeperiod", cp.getTimePeriod());
					cropObject.put("soilrequirement", cp.getSoilRequirement());
					cropObject.put("landpreparation", cp.getLandPreparation());
					cropObject.put("sowing", cp.getSowIng());
					cropObject.put("irrigation", cp.getIrrigation());
					cropObject.put(CROPIMG, cp.getCropImg());
					cropObject.put(FERTILIZER, cp.getFertilizer());
					cropArray.put(cropObject);
				}
			}
			else
			{
				cropObject = new JSONObject();
				cropObject.put(STATUS, NOTOK);
				cropArray.put(cropObject);
			}
		}
		else
		{
			cropObject = new JSONObject();
			cropObject.put(STATUS, NOTOK);
			cropArray.put(cropObject);
		}
		return cropArray.toString();
	}
	
	@GetMapping(value="/crop")//, method=RequestMethod.GET,produces = "text/html")
	public String getCropDetail(@RequestParam (name=CROPID) int cropId)
	{
		JSONArray cropdescArray = new JSONArray();
		JSONObject cropdescObject = null;
		
		Crop crop = null;
		Optional<Crop> cp = cropRepository.findById(cropId);
		if(cp.isPresent())
			crop = cp.get();
		
		if(crop != null)
		{
			cropdescObject = new JSONObject();
			cropdescObject.put(STATUS, "ok");
			cropdescObject.put(CROPID,crop.getCropId());
			cropdescObject.put("cropdesc",crop.getCropDesc());
			cropdescObject.put("climate", crop.getCliMate());
			cropdescObject.put("soilrequirement", crop.getSoilRequirement());
			cropdescObject.put("timeperiod", crop.getTimePeriod());
			cropdescObject.put("landpreparation", crop.getLandPreparation());
			cropdescObject.put("sowing", crop.getSowIng());
			cropdescObject.put("irrigation", crop.getIrrigation());
			cropdescObject.put(CROPIMG, crop.getCropImg());
			cropdescObject.put(FERTILIZER, crop.getFertilizer());
			cropdescArray.put(cropdescObject);
		}
		else
		{
			cropdescObject = new JSONObject();
			cropdescObject.put(STATUS, NOTOK);
			cropdescArray.put(cropdescObject);
		}
		return cropdescArray.toString();
			
	}
	
	
	@GetMapping(value="/pesticide")//, method=RequestMethod.GET,produces = "text/html")
	public String getPesticide(@RequestParam (name=CROPID) String cropId)
	{
		JSONArray pesticideArray = new JSONArray();
		JSONObject pesticideObject = null;
		
		List<Pesticide> pesticide = pesticideRepository.findByCropIdsIn(cropId);
		
		if(pesticide != null)
		{
			if(!pesticide.isEmpty())
			{
				for(Pesticide pest : pesticide) {
					System.out.println(pest.getPesticideId()+" "+pest.getDisease()+" "+pest.getSolution()+" "+pest.getCropId());
					pesticideObject = new JSONObject();
					pesticideObject.put(STATUS, "ok");
					pesticideObject.put(CROPID, pest.getCropId());
					pesticideObject.put("pesticideid", pest.getPesticideId());
					pesticideObject.put("disease", pest.getDisease());
					pesticideObject.put("solution", pest.getSolution());
					pesticideArray.put(pesticideObject);
				}
			}
			else
			{
				pesticideObject = new JSONObject();
				pesticideObject.put(STATUS, NOTOK);
				pesticideArray.put(pesticideObject);
			}
		}
		else
		{
			pesticideObject = new JSONObject();
			pesticideObject.put(STATUS, NOTOK);
			pesticideArray.put(pesticideObject);
		}
		
		return pesticideArray.toString();
	}
	
	@GetMapping(value="/fertilizer")//, method=RequestMethod.GET,produces = "text/html")
	public String getFertilizer(@RequestParam (name=CROPID) int cropId)
	{
		JSONArray fertilizerArray = new JSONArray();
		JSONObject fertilizerObject = null;
		
		List<Crop> fertilizers = fertilizerRepository.findByCropIdsIn(cropId);
		
		if(fertilizers != null)
		{
			if(!fertilizers.isEmpty())
			{
				for(Crop fert : fertilizers) {
					System.out.println(fert.getCropName()+" "+fert.getCropTypeId() + "  "+fert.getCropId()+" "+fert.getFertilizer());
					fertilizerObject = new JSONObject();
					fertilizerObject.put(STATUS, "ok");
					fertilizerObject.put(CROPNAME, fert.getCropName());
					fertilizerObject.put(CROPID, fert.getCropId());
					fertilizerObject.put(CROPIMG, fert.getCropImg());
					fertilizerObject.put(FERTILIZER, fert.getFertilizer());
					fertilizerArray.put(fertilizerObject);
				}
			}
			else
			{
				fertilizerObject = new JSONObject();
				fertilizerObject.put(STATUS, NOTOK);
				fertilizerArray.put(fertilizerObject);
			}
		}
		else
		{
			fertilizerObject = new JSONObject();
			fertilizerObject.put(STATUS, NOTOK);
			fertilizerArray.put(fertilizerObject);
		}
		return fertilizerArray.toString();
	}
}
