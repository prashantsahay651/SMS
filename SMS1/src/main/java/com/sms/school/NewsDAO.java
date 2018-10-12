package com.sms.school;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.beans.News;

public interface NewsDAO extends JpaRepository<News,Integer>{

}
