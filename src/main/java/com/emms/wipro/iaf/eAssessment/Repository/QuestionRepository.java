package com.emms.wipro.iaf.eAssessment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emms.wipro.iaf.eAssessment.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
