package com.liu.besuperMybatis.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.besuperMybatis.beans.Question;

public class QuestionDao {
	String resource;
	InputStream is;
	SqlSessionFactory sessionFactory;
	SqlSession session ;
	public QuestionDao() {
		resource = "mybatis_conf.xml";
		is = PlayerDao.class.getClassLoader().getResourceAsStream(resource);;
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
	}
	
	public List<Question> getAllQuestions(){
		String statement = "com.liu.besuperMybatis.mapper.questionMapper.selectAllQuestion";
		List<Question> questions = session.selectList(statement);
		return questions;
	}
	public List<Question> getQuestionsByPlayerId(int playerId){
		String statement = "com.liu.besuperMybatis.mapper.questionMapper.selectQuestionsByPlayerId";
		List<Question> questions = session.selectList(statement,playerId);
		return questions;
	}
	public List<Question> getQuestionsIsOpen(){
		String statement = "com.liu.besuperMybatis.mapper.questionMapper.selectQuestionOfOpen";
		List<Question> questions = session.selectList(statement);
		return questions;
	}
	public Question getQuesionById(int id){
		String statement = "com.liu.besuperMybatis.mapper.questionMapper.selectQuestionById";
		Question question = session.selectOne(statement,id);
		return question;
	}
	
	public Question insertQuestion(Question question){
		String statement = "com.liu.besuperMybatis.mapper.questionMapper.insertQuestion";
		session.insert(statement, question);
		session.commit();
		return question;
	}
	
	public Question updateQuestion(Question question){
		String statement = "com.liu.besuperMybatis.mapper.questionMapper.updateQuestion";
		session.update(statement,question);
		session.commit();
		return question;
	}
	
	
}
