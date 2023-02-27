package com.emms.wipro.iaf.eAssessment.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.wipro.iaf.eAssessment.Repository.RouteWFRepository;
import com.emms.wipro.iaf.eAssessment.Repository.UserRepository;
import com.emms.wipro.iaf.eAssessment.Repository.WorkflowAssignmentRepository;
import com.emms.wipro.iaf.eAssessment.dao.WorkflowDao;
import com.emms.wipro.iaf.eAssessment.dto.WorkFlowProcessDto;
import com.emms.wipro.iaf.eAssessment.dto.WorkflowAssignmentDto;
import com.emms.wipro.iaf.eAssessment.entity.User;
import com.emms.wipro.iaf.eAssessment.entity.WorkflowAssignmentEntity;
import com.emms.wipro.iaf.eAssessment.entity.WorkflowProcessEntity;
import com.emms.wipro.iaf.eAssessment.forms.RouteWfForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class RouteWFService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	WorkflowDao wfDao;
	@Autowired
	RouteWFRepository rWfRepo;
	@Autowired
	WorkflowAssignmentRepository waRepo;

	public String routeWorkFlow(RouteWfForm params) throws JsonProcessingException {
		Calendar cal = Calendar.getInstance();
		int routedBy = Integer.parseInt(params.getRoutedby());
		List<WorkFlowProcessDto> wfProcessDtos = new ArrayList<WorkFlowProcessDto>();
		WorkflowProcessEntity wfProcess = null;
		wfProcess = this.rWfRepo.getWfRecord(params.getOwnerid());
		if (wfProcess != null) {
			return updateWorkFlow(wfProcess, params, routedBy);
		}
		wfProcess = new WorkflowProcessEntity();
		wfProcess.setApp(params.getApp());
		wfProcess.setMemo(params.getMemo());
		wfProcess.setOwnerid(params.getOwnerid());
		wfProcess.setUpdatedby(routedBy);
		switch (params.getRoutedTo()) {
		case "UEB":
			wfProcess.setPendingWith("CI");
			break;
		case "CI":
			wfProcess.setPendingWith("OIC UEB");
			break;
		case "OIC UEB":
			wfProcess.setPendingWith("");
			break;
		}
		List<User> users = userRepo.getUserWithRoles(params.getRole());
		List<WorkflowAssignmentEntity> wfAssignmentList = new ArrayList<WorkflowAssignmentEntity>();
		for (User user : users) {
			WorkflowAssignmentEntity wfAssignment = new WorkflowAssignmentEntity();
			wfAssignment.setWfprocess(wfProcess);
			wfAssignment.setCreatedby(routedBy);
			wfAssignment.setRole(params.getRoutedby());
			wfAssignment.setUserid(user.getUser_id());
			wfAssignment.setTimecreated(cal.getTimeInMillis());
			wfAssignment.setTimeupdated(cal.getTimeInMillis());
			wfAssignmentList.add(wfAssignment);
		}

		wfProcess.setAssignment(wfAssignmentList);

		wfProcess = this.wfDao.saveWorkflowProcess(wfProcess);
		WorkFlowProcessDto wfProcessDto = new WorkFlowProcessDto(params.getApp(), wfProcess.getPendingWith(),
				params.getRoutedTo());
		wfProcessDtos.add(wfProcessDto);
		ObjectMapper mapper = new ObjectMapper();
		String wfResponse = mapper.writeValueAsString(wfProcessDtos);
		return wfResponse;
	}

	private String updateWorkFlow(WorkflowProcessEntity wfProcess, RouteWfForm params, int routedBy) throws JsonProcessingException {
		Calendar cal = Calendar.getInstance();
		List<WorkFlowProcessDto> wfProcessDtos = new ArrayList<WorkFlowProcessDto>();
		wfProcess.setPendingWith(params.getRoutedTo());
		wfProcess.setUpdatedby(Long.parseLong(params.getRoutedby()));
		wfProcess.setMemo(params.getMemo());
		wfProcess = this.rWfRepo.saveAndFlush(wfProcess);
		this.waRepo.deleteAllByProcessId(wfProcess.getProcessid());
		List<User> users = userRepo.getUserWithRoles(params.getRole());
		List<WorkflowAssignmentEntity> wfAssignmentList = new ArrayList<WorkflowAssignmentEntity>();
		for (User user : users) {
			WorkflowAssignmentEntity wfAssignment = new WorkflowAssignmentEntity();
			wfAssignment.setWfprocess(wfProcess);
			wfAssignment.setCreatedby(routedBy);
			wfAssignment.setRole(params.getRoutedby());
			wfAssignment.setUserid(user.getUser_id());
			wfAssignment.setTimecreated(cal.getTimeInMillis());
			wfAssignment.setTimeupdated(cal.getTimeInMillis());
			wfAssignmentList.add(this.wfDao.saveAssignmentRecord(wfAssignment));
		}
		wfProcess.setAssignment(wfAssignmentList);
		WorkFlowProcessDto wfProcessDto = new WorkFlowProcessDto(params.getApp(), wfProcess.getPendingWith(),
				params.getRoutedTo());
		wfProcessDtos.add(wfProcessDto);
		ObjectMapper mapper = new ObjectMapper();
		String wfResponse = mapper.writeValueAsString(wfProcessDtos);
		return wfResponse;
	}

	public String getAssignments(int userid) throws Exception {
		List<WorkflowAssignmentEntity> wfAssignments = this.wfDao.getAssignments(userid);
		List<WorkflowAssignmentDto> WfDto = new ArrayList<WorkflowAssignmentDto>();

		for (WorkflowAssignmentEntity wfAssignment : wfAssignments) {
			WorkflowProcessEntity wfProcess = wfAssignment.getWfprocess();
			WorkflowAssignmentDto wfDto = new WorkflowAssignmentDto(wfAssignment.getRole(), wfAssignment.getUserid(),
					wfAssignment.getTimecreated(), wfAssignment.getTimeupdated(), wfAssignment.getCreatedby(),
					wfAssignment.getUpdatedby(), wfProcess.getApp(), wfProcess.getMemo(), wfProcess.getPendingWith());
			WfDto.add(wfDto);
		}

		ObjectMapper mapper = new ObjectMapper();
		String pendingAssignments = mapper.writeValueAsString(WfDto);
		System.out.println(pendingAssignments);
		return pendingAssignments;
	}

	public String checkRecordEntry(String ownerid) throws JsonProcessingException {
		WorkFlowProcessDto wfDto = this.rWfRepo.checkWFRecord(ownerid);
		ObjectMapper mapper = new ObjectMapper();
		String currentRecord = mapper.writeValueAsString(wfDto);
		return currentRecord;
	}

}
