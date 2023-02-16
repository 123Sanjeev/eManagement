package com.eManagement.eManagement.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eManagement.eManagement.dto.WorkFlowProcessDto;
import com.eManagement.eManagement.entity.WorkflowProcessEntity;

public interface RouteWFRepository extends JpaRepository<WorkflowProcessEntity, Long>{

	@Query(value="select new com.eManagement.eManagement.dto.WorkFlowProcessDto(wf.app,wf.pendingWith,wf.memo) from WorkflowProcessEntity wf where wf.ownerid=:ownerid")
	public WorkFlowProcessDto checkWFRecord(@Param(value = "ownerid") String ownerid);
	
	@Query(value="select wf from WorkflowProcessEntity wf where wf.ownerid=:ownerid")
	public WorkflowProcessEntity getWfRecord(@Param(value = "ownerid") String ownerid);
}
