package com.sms.questionpaper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.beans.QuestionPaper;

public interface QuestionPaperDAO extends JpaRepository<QuestionPaper,Integer> {

}
