package com.emms.wipro.iaf.eAssessment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emms.wipro.iaf.eAssessment.Repository.RouteWFRepository;
import com.emms.wipro.iaf.eAssessment.Repository.WorkflowAssignmentRepository;
import com.emms.wipro.iaf.eAssessment.entity.WorkflowAssignmentEntity;
import com.emms.wipro.iaf.eAssessment.entity.WorkflowProcessEntity;

@Repository
public class WorkflowDao {

	@Autowired
	WorkflowAssignmentRepository wfAssignmentRepo;

	@Autowired
	RouteWFRepository wfProcessRepo;

	public WorkflowAssignmentEntity saveAssignmentRecord(WorkflowAssignmentEntity wfAssignmentEntity) {
		return this.wfAssignmentRepo.saveAndFlush(wfAssignmentEntity);
	}
	public WorkflowProcessEntity saveWorkflowProcess(WorkflowProcessEntity wfProcess) {

		WorkflowProcessEntity savedProcess = this.wfProcessRepo.saveAndFlush(wfProcess);
		for (WorkflowAssignmentEntity assignment : wfProcess.getAssignment()) {
			assignment.setWfprocess(savedProcess);
			saveAssignmentRecord(assignment);
		}
		return savedProcess;
	}

	public List<WorkflowAssignmentEntity> getAssignments(int userid) {
		List<WorkflowAssignmentEntity> wfAssignment = this.wfAssignmentRepo.getAssignmentsById(userid);
		return wfAssignment;
	}
}
