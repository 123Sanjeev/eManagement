package com.eManagement.eManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eManagement.eManagement.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
