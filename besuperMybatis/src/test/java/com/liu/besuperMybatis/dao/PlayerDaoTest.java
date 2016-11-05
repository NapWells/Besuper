package com.liu.besuperMybatis.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.liu.besuperMybatis.beans.Player;

public class PlayerDaoTest {
	PlayerDao dao = new PlayerDao();
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
	public void testIsExistUsername() {
		boolean isExit = dao.isExistUsername("111");
		System.out.println(isExit);
		Assert.assertTrue(isExit);
	}

	@Test
	public void testLogin() {
		Player playerLogin = dao.login("qwe", "123");
		Assert.assertNotNull(playerLogin);
	}
	
//	@Test
//	public void testSignup(){
//		Player player = new Player();
//		player.setName("王晓");
//		player.setUsername("qazx2");
//		player.setPassword("123");
//		Player p = dao.signup(player);
//		Assert.assertNotNull(p);
//	}
	
//	@Test 
//	public void testUpdatePlayer(){
//		Player player = dao.login("zxcvb", "123");
//		player.setName("小明");
//		player.setUsername("zxcvb2");
//		Player player1 = dao.updatePlayer(player);
//		Assert.assertNotNull(player1);
//	}
}
