package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleBean;
import com.revature.service.SimpleService;

/**
 * 
 * @author John Brand (1802-Matt)
 *
 * POST ("/beans") - takes in a SimpleBean to add to the H2 DB and return the SimpleBean added
 * GET ("/beans") - returns list of all SimpleBeans in H2 DB
 * PUT ("/beans") - takes in a SimpleBean, updates it in the H2 DB, returns the updated SimpleBean
 * DELETE ("/beans") - takes in a SimpleBean and removes it from the H2 DB
 */

@RestController
public class SimepleController {

	@Autowired
	SimpleService simpleServ;
	
	/**
	 * @author John Brand (1802-Matt)
	 * 
	 * @return Returns list of all beans
	 */
	
	@GetMapping("/beans")
	public List<SimpleBean> getAllBeans() {
		return simpleServ.findAllBeans();
	}
	
	/**
	 * @author John Brand (1802-Matt)
	 * @param bean - A SimpleBean to be added to H2 DB
	 * @return -  the SimpleBean added
	 */
	
	@PostMapping("/beans")
	public SimpleBean postBean(@RequestBody SimpleBean bean) {
		return simpleServ.addBean(bean);
	}

	/**
	 * @author John Brand (1802-Matt)
	 * @param bean - The SimpleBean to be updated
	 * @return - The SimpleBean that was updated
	 */
	
	@PutMapping("/beans")
	public SimpleBean putBean(@RequestBody SimpleBean bean) {
		return simpleServ.updateBean(bean);
	}
	
	/**
	 * @author John Brand (1802-Matt)
	 * @param bean - The SimpleBean to be deleted
	 * 
	 * Also i have no idea why this works.  I think it is taking in the beanId
	 * and building an empty bean with id 3, then passing that to the service.
	 * 
	 * I just dont understand why it is creating an empty bean with the id
	 * from the URL.
	 * 
	 */
	
//	@DeleteMapping("/beans/{beanId}")
//	public void deleteBean(SimpleBean bean) {
//		simpleServ.deleteBean(bean);
//	}
	
	/**
	 * @author John Brand (1802-Matt)
	 * @param int - the beanId to be used to delete a bean from H2 DB
	 */
	
	@DeleteMapping("beans/{beanId}")
	public void deleteBean(@PathVariable int beanId) {
		simpleServ.deleteBean(beanId);
	}
}
