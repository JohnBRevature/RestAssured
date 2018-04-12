package com.revature;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.SimpleBean;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/** 
 * @author John Brand (1802-Matt)
 * 
 * NOTES:
 * 	Was running into a classDefNotFound exception.  Had to add a Groovy dependency to pom.xml.
 *
 *	H2 should look like this before all tests
 *
 *	BEAN_ID  	BEAN_NAME  		BEAN_NUMBER  
 *	1			Bean with 		64
 *	2			Bean with 		128
 *	3			Bean with 		128
 *	4			bean with 		512
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAssuredStandAloneApplicationTests {

	private String url = "http://localhost:4500/beans";
	private static SimpleBean bean;
	
	@BeforeClass
	public static void makeBean() {
		bean = new SimpleBean();
		bean.setBeanId(5);
		bean.setBeanName("This is the Bean's name");
		bean.setBeanNumber(1024);
		
	}
	
	/**
	 * Getting a list of all beans and checking body[0] to make sure it is
	 * the bean with beanId = 1;
	 */
	
	@Test
	public void testGetRestAssured() {
		RestAssured.get(url).then().body("[0].beanId", equalTo(1));
	}

	/**
	 * Adding the bean we initialized at the top of this JUnit.
	 */
	
	@Test
	public void testPostRestAssured() {

		RestAssured.given().contentType("application/json")
		.body(bean)
		.when().post(url).then()
		.body("beanId", equalTo(5));
	}
	
	/**
	 * Changing the (beanId = 1) bean's name to 'Changed the name'
	 * 
	 * Check to make sure we have bean 1 and then check to see if the 
	 * bean's name matches the new name
	 */
	
	@Test
	public void testPutRestAssured() {
		//changing to bean with id  = 1
		bean.setBeanId(1);
		bean.setBeanName("Changed the name");
		bean.setBeanNumber(64); // id 1 bean has beanNumber = 64; don't want that change
		
		RestAssured.given()
		.contentType("application/json").body(bean)
		.when().put(url).then()
		.body("beanId", equalTo(1))
		.and()
		.body("beanName", equalTo("Changed the name"));
	}
	
	/**
	 * Deleting bean number 3
	 */
	
	@Test
	public void testDeleteRestAssured() {
		RestAssured.delete(url + "/3").then().statusCode(200);
	}
	
	
	/**
	 * After tests are run this should be what H2 looks like.
	 * 
	 * BEAN_ID  	BEAN_NAME  					BEAN_NUMBER  
	 *	1			Changed the name			64
	 *	2			Bean with 					128
	 *	4			bean with 					512
	 *	5			This is the Bean's name		1024
	 */
}
