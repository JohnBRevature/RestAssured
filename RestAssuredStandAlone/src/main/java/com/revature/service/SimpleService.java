package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleBean;
import com.revature.repository.SimpleRepo;

/**
 * 
 * @author John Brand (1802-Matt)
 *
 */

@Service
public class SimpleService {

	@Autowired
	SimpleRepo simpleRepo;

	/**
	 * @author John Brand (1802-Matt)
	 * 
	 * @return List of SimpleBeans in DB
	 */
	
	public List<SimpleBean> findAllBeans(){
		return simpleRepo.findAll();
	}
	
	/**
	 * @author John Brand (1802-Matt)
	 * 
	 * @param bean - a SimpleBean
	 * @return - The Bean that was added (not too relevant, we aren't using a sequence to generate an ID)
	 */

	@Transactional
	public SimpleBean addBean(SimpleBean bean) {
		System.out.println("Adding Bean: "+bean.toString());
		return simpleRepo.save(bean);
	}
	
	/**
	 * @author John Brand	(1802-Matt)
	 * 
	 * Functionally identical to addBean()
	 * 
	 * @param bean - A SimpleBean to be updated
	 * @return - The bean that was updated
	 */
	@Transactional
	public SimpleBean updateBean(SimpleBean bean) {
		return simpleRepo.save(bean);
	}
	
	/**
	 * @author John Brand (1802-Matt)
	 * 
	 * @param bean - The SimpleBean to be deleted
	 */
	
	@Transactional
	public void deleteBean(int beanId) {
		simpleRepo.deleteByBeanId(beanId);
	}
	
}
