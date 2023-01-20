package com.eManagement.eManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.eManagement.eManagement.beans.BluePrintData;
import com.eManagement.eManagement.beans.BluePrintMarksbean;
import com.eManagement.eManagement.entity.BluePrintTb;
import com.eManagement.eManagement.entity.Blueprintmarksdetails;

@Repository
public class BluePrintDao {

	private EntityManager entityManager;
	
	
	BluePrintDao(EntityManager manager){
		this.entityManager = manager;
	}
	
	
	public String createUpdateBlueprint(BluePrintData bpData) {
		
		Session currentSession = this.entityManager.unwrap(Session.class);
		
		BluePrintTb bluePrintTb = new BluePrintTb();
		Blueprintmarksdetails bpmarksDetails = new Blueprintmarksdetails();
		BluePrintMarksbean mBean = bpData.getMarksBean();
		bluePrintTb.setLocation(bpData.getLocation());
		bluePrintTb.setMasterCourseName(bpData.getMasterCourseName());
		bluePrintTb.setSubject(bpData.getSubject());
		bluePrintTb.setTerm(bpData.getTerm());
		bluePrintTb.setTitle(bpData.getTitle());
		bluePrintTb.setOption(bpData.getOption());
		bluePrintTb.setStatus(bpData.getStatus());
		bluePrintTb.setCreatedOnTimeStamp(bpData.getCreatedOnTimeStamp());
		bluePrintTb.setUpdatedOnTimeStamp(bpData.getUpdatedOnTimeStamp());
		bluePrintTb.setCreatedBy(bpData.getCreatedBy());
		bluePrintTb.setUpdatedBy(bpData.getUpdatedBy());
		
		bpmarksDetails.setLAMarks(mBean.getLAMarks());
		bpmarksDetails.setSAMarks(mBean.getSAMarks());
		bpmarksDetails.setFIBobjMarks(mBean.getFIBobjMarks());
		bpmarksDetails.setFIBsubMarks(mBean.getFIBsubMarks());
		bpmarksDetails.setVSAMarks(mBean.getVSAMarks());
		bpmarksDetails.setMCQMarks(mBean.getMCQMarks());
		bpmarksDetails.setTFMarks(mBean.getTFMarks());
		bpmarksDetails.setTotalMarks(mBean.getTotalMarks());
		bpmarksDetails.setBlueprint(bluePrintTb);
		bluePrintTb.setBpMarksDetails(bpmarksDetails);
		currentSession.saveOrUpdate(bluePrintTb);
		
		return String.valueOf(bluePrintTb.getId());
	}


	public List<BluePrintTb> getBlueprint() {
		Session session = this.entityManager.unwrap(Session.class);
		String query = "from BluePrintTb b";
		@SuppressWarnings({ "rawtypes", "deprecation" })
		Query hql = session.createQuery(query);
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<BluePrintTb> list = (List<BluePrintTb>)hql.list();
		
		return list;
	}
	public List<BluePrintTb> getBlueprint(String whereClause){
		Session session = this.entityManager.unwrap(Session.class);
		String query = "from BluePrintTb where "+ whereClause;
		Query hql = session.createQuery(query);
		List<BluePrintTb> list = (List<BluePrintTb>)hql.list();
		return list;
	}
	
	
}
