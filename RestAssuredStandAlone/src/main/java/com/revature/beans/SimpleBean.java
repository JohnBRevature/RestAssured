package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author John Brand (1802-Matt)
 * 
 *
 */
@Entity
@Table(name = "BEAN")
public class SimpleBean {

	@Id
	@Column(name = "Bean_Id")
	private int beanId;
	
	@Column(name = "Bean_Name")
	private String beanName;
	
	@Column(name = "Bean_Number")
	private int beanNumber;

	public SimpleBean() {
		super();
	}

	public SimpleBean(int beanId, String beanName, int beanNumber) {
		super();
		this.beanId = beanId;
		this.beanName = beanName;
		this.beanNumber = beanNumber;
	}

	public int getBeanId() {
		return beanId;
	}

	public void setBeanId(int beanId) {
		this.beanId = beanId;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public int getBeanNumber() {
		return beanNumber;
	}

	public void setBeanNumber(int beanNumber) {
		this.beanNumber = beanNumber;
	}

	@Override
	public String toString() {
		return "SimpleBean [ \n beanId= \t " + beanId
				+ ",\nbeanName= \t " + beanName
				+ ",\nbeanNumber= \t " + beanNumber
				+ "\n]";
	}
	
	
	
	
}
