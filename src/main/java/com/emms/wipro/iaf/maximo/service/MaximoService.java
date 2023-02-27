package com.emms.wipro.iaf.maximo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emms.wipro.iaf.maximo.dao.MaximoDao;

@Service
public class MaximoService {

	@Autowired
	private MaximoDao maximoDao;
	
	public String getMoodleAdminUser(String user) {
		return this.maximoDao.moodleUser(user);
		
	}
	
}
