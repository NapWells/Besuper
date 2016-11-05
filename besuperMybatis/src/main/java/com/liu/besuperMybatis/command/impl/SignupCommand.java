package com.liu.besuperMybatis.command.impl;

import java.util.regex.Pattern;

import com.liu.besuperMybatis.application.BesuperApplication;
import com.liu.besuperMybatis.beans.Player;
import com.liu.besuperMybatis.command.SystemCommand;
import com.liu.besuperMybatis.dao.PlayerDao;
import com.liu.besuperMybatis.util.Console;

public class SignupCommand extends SystemCommand{
	
	@Override
	public void execute() {
		String username = Console.askUserInput("please input username:");
		PlayerDao dao = new PlayerDao();
		while(dao.isExistUsername(username)){
			Console.println("username has exists!");
			username = Console.askUserInput("please input username:");
		}
		String password = null;
		while(true){
			password = Console.askUserInput("please input password:");
			try {
				validatePassword(password);
				break;
			} catch (Exception e) {
				Console.println("password format not valid, " + e.getMessage());
				continue;
			}
		}
		String nickname = Console.askUserInput("please input nickename:");
		Player player = new Player();
		player.setName(nickname);
		player.setUsername(username);
		player.setPassword(password);
		player = dao.signup(player);
		BesuperApplication.getInstance().setPlayerProfile(player);
	}
	
	private void validatePassword(String passwrod) throws Exception{
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if(!lenPattern.matcher(passwrod).find()){
			throw new Exception("password length must be bigger than 6");
		}
		
		Pattern numPattern = Pattern.compile("[0-9]");
		if(!numPattern.matcher(passwrod).find()){
			throw new Exception("password must be containe one number");
		}
		
		Pattern charPattern = Pattern.compile("[a-zA-Z]");
		if(!charPattern.matcher(passwrod).find()){
			throw new Exception("password must be containe one character");
		}
	}
	
}
