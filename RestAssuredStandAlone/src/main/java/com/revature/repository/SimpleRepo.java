package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.beans.SimpleBean;

@RepositoryRestResource
public interface SimpleRepo extends JpaRepository<SimpleBean, Integer> {

	void deleteByBeanId(int beanId);

}
