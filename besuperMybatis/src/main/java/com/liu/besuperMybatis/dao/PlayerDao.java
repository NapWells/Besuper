package com.liu.besuperMybatis.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.besuperMybatis.beans.Player;


public class PlayerDao {
	String resource;
	InputStream is;
	SqlSessionFactory sessionFactory;
	SqlSession session ;
	public PlayerDao() {
		resource = "mybatis_conf.xml";
		is = PlayerDao.class.getClassLoader().getResourceAsStream(resource);;
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
	}
	public void clean(SqlSession session,InputStream is){
		if(session!=null)
			session.close();
		if(is!=null)
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public boolean isExistUsername(String username){
		String statement = "com.liu.besuperMybatis.mapper.playerMapper.selectPlayerByName";
		Player player = session.selectOne(statement,username);
		if(player!=null)
			return true;
		return false;
	}
	
	public Player login(String username,String password){
		String statement = "com.liu.besuperMybatis.mapper.playerMapper.getPLayerByUsernameAndPassword";
		Player player = new Player();
		player.setUsername(username);
		player.setPassword(password);
		Player playerLoign = session.selectOne(statement,player);
		return playerLoign;
	}
	
	
	public Player signup(Player player){
		String statement = "com.liu.besuperMybatis.mapper.playerMapper.insertPlayer";
		session.insert(statement,player);
		session.commit();
		return login(player.getUsername(),player.getPassword());
	}
	
	public Player updatePlayer(Player player){
		String statement = "com.liu.besuperMybatis.mapper.playerMapper.updatePlayer";
		session.update(statement,player);
		session.commit();
		return player;
	}
}
