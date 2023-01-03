package com.eManagement.eManagement.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eManagement.eManagement.beans.BluePrintData;
import com.eManagement.eManagement.beans.BluePrintMarksbean;
import com.eManagement.eManagement.beans.BlueprintDto;
import com.eManagement.eManagement.dao.BluePrintDao;
import com.eManagement.eManagement.entity.BluePrintTb;
import com.eManagement.eManagement.forms.BlueprintFormParamsHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BluePrintService {

	@Autowired
	private BluePrintDao blueprintDao;
	
	@Transactional
	public String createUpdateBlueprint(BlueprintFormParamsHandler params) {

		Calendar c = Calendar.getInstance();
		
		BluePrintData bpData = new BluePrintData();
		BluePrintMarksbean marksBean =  new BluePrintMarksbean();
		bpData.setLocation(params.getLocation());
		bpData.setMasterCourseName(params.getMastercoursename());
		bpData.setSubject(params.getSubject());
		bpData.setTerm(params.getTerm());
		bpData.setTitle(params.getTitle());
		bpData.setOption(params.getOption());
		bpData.setCreatedOnTimeStamp(c.getTimeInMillis());
		bpData.setUpdatedOnTimeStamp(c.getTimeInMillis());
		bpData.setStatus("DRAFT");
		bpData.setCreatedBy("DEV");
		bpData.setUpdatedBy("DEV");
		
		System.out.println("Marks bean: "+params.toString());
		
		if(params.getOption().equals("Objective")) {
			marksBean.setFIBobjMarks(params.getMarks()[0]);
			marksBean.setMCQMarks(params.getMarks()[1]);
			marksBean.setTFMarks(params.getMarks()[2]);
		}else if(params.getOption().equals("Subjective")){
			marksBean.setFIBsubMarks(params.getMarks()[0]);
			marksBean.setVSAMarks(params.getMarks()[1]);
			marksBean.setSAMarks(params.getMarks()[2]);
			marksBean.setLAMarks(params.getMarks()[3]);
		}else if(params.getOption().equals("Both")) {
			marksBean.setFIBobjMarks(params.getMarks()[0]);
			marksBean.setVSAMarks(params.getMarks()[1]);
			marksBean.setSAMarks(params.getMarks()[2]);
			marksBean.setLAMarks(params.getMarks()[3]);
			marksBean.setFIBsubMarks(params.getMarks()[4]);
			marksBean.setMCQMarks(params.getMarks()[5]);
			marksBean.setTFMarks(params.getMarks()[6]);
		}
		
		marksBean.setTotalMarks(params.getTotalmarks());
		
		System.out.println("Marks bean: "+marksBean.toString());
		
		bpData.setMarksBean(marksBean);
		return blueprintDao.createUpdateBlueprint(bpData);
	}

	public String getBluePrint() throws JsonProcessingException {
		// Getting data from dao
		List<BluePrintTb> bpData = this.blueprintDao.getBlueprint();
		List<BlueprintDto> blueprintDtos = new ArrayList<BlueprintDto>();
		for(BluePrintTb bp : bpData) {
			BlueprintDto bpDto = new BlueprintDto();
			bpDto.setId(bp.getId());
			bpDto.setMasterCourseName(bp.getMasterCourseName());
			bpDto.setSubject(bp.getSubject());
			bpDto.setTerm(bp.getTerm());
			bpDto.setTitle(bp.getTitle());
			bpDto.setOption(bp.getOption());
			bpDto.setCreatedBy(bp.getCreatedBy());
			bpDto.setCreatedOnTimeStamp(bp.getCreatedOnTimeStamp());
			bpDto.setUpdatedBy(bp.getUpdatedBy());
			bpDto.setUpdatedOnTimeStamp(bp.getUpdatedOnTimeStamp());
			bpDto.setStatus(bp.getStatus());
			bpDto.setLocation(bp.getLocation());
			blueprintDtos.add(bpDto);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String blueprintJsonData = mapper.writeValueAsString(blueprintDtos);
		System.out.println("Json data string: " + blueprintJsonData);
		return blueprintJsonData;
	}
	
}
