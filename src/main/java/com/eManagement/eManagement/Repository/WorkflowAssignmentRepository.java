package com.eManagement.eManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eManagement.eManagement.entity.WorkflowAssignmentEntity;

public interface WorkflowAssignmentRepository extends JpaRepository<WorkflowAssignmentEntity, Long> {

	@Query( value= "SELECT * FROM workflow_assignment wa left join workflow_process wp on wa.process_id=wp.processid WHERE WA.USERID=?1 " , nativeQuery =true)
	public List<WorkflowAssignmentEntity> getAssignmentsById(int userid);
	
	@Modifying
	@Query(value="delete from workflow_assignment where process_id=:processid", nativeQuery=true)
	public void deleteAllByProcessId(@Param(value="processid")int processid);
	
}
