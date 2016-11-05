package com.liu.besuperMybatis.dao;


import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.liu.besuperMybatis.beans.Question;

public class QuestionDaoTest {
	QuestionDao dao = new QuestionDao();
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
	public void testGetQuesionById() {
		Question question = dao.getQuesionById(1001);
		Assert.assertNotNull(question);
	}
	
//	@Test
//	public void testInsertQuestion(){
//		Question question = new Question();
//		question.setValue("are you crazy?");
//		question.setScore(10);
//		question.setPlayerId(1);
//		question = dao.insertQuestion(question);
//		System.out.println(question);
//		Assert.assertNotNull(question);
//	}
	
	@Test
	public void testUpdateQuestion(){
		Question q = dao.getQuesionById(1043);
		q.setScore(100);
		q.setIsOpen("N");
		q = dao.updateQuestion(q);
		System.out.println(q);
		Assert.assertNotNull(q);
	}
	
	@Test
	public void testGetAllQuestions(){
		List<Question> questions = dao.getAllQuestions();
		Assert.assertNotNull(questions);
	}
	
	@Test
	public void testGetQuestionsByPlayerId(){
		List<Question> questions = dao.getQuestionsByPlayerId(1);
		for(Question q: questions)
			System.out.println(q);
		Assert.assertNotNull(questions);
	}
	
	@Test
	public void testGetQuestionsIsOpen(){
		List<Question> questions = dao.getAllQuestions();
		for(Question q: questions)
			System.out.println(q);
		Assert.assertNotNull(questions);
	}
}
