package com.liu.besuperMybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.besuperMybatis.beans.Answer;

public class AnswerDao {
	String resource;
	InputStream is;
	SqlSessionFactory sessionFactory;
	SqlSession session ;
	public AnswerDao() {
		resource = "mybatis_conf.xml";
		is = PlayerDao.class.getClassLoader().getResourceAsStream(resource);;
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
	}
	
	public Answer getAnswerById(int id){
		String statement = "com.liu.besuperMybatis.mapper.answerMapper.selectAnswerById";
		Answer answer = session.selectOne(statement,id);
		return answer;
	}
	public Answer insertAnswer(Answer answer){
		String statement = "com.liu.besuperMybatis.mapper.answerMapper.insertAnswer";
		session.insert(statement, answer);
		session.commit();
		return answer;
	}
	
	public Answer updateAnswer(Answer answer){
		String statement = "com.liu.besuperMybatis.mapper.answerMapper.updateAnswer";
		session.update(statement,answer);
		session.commit();
		return answer;
	}
}
