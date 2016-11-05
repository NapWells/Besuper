package com.liu.besuperMybatis.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.liu.besuperMybatis.beans.Answer;

public class AnswerDaoTest {
	AnswerDao dao = new AnswerDao();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetAnswerById(){
		Answer answer = dao.getAnswerById(8);
		System.out.println(answer);
		Assert.assertNotNull(answer);
	}
	@Test
	public void testInsertAnswer() {
		Answer answer = new Answer();
		answer.setValue("asssss");
		answer.setPlayerId(2);
		answer.setQuestionId(1035);
		answer = dao.insertAnswer(answer);
		System.out.println(answer);
		Assert.assertNotNull(answer);
	}
	
	@Test
	public void testUpdateAnswer(){
		Answer answer = dao.getAnswerById(8);
		answer.setBest("Y");
		answer = dao.updateAnswer(answer);
		Assert.assertNotNull(answer);
	}
}
