package com.liu.besuperMybatis.command.impl;

import com.liu.besuperMybatis.application.BesuperApplication;
import com.liu.besuperMybatis.beans.Player;
import com.liu.besuperMybatis.command.SystemCommand;
import com.liu.besuperMybatis.dao.PlayerDao;
import com.liu.besuperMybatis.util.Console;

public class LoginCommand extends SystemCommand{
	@Override
	public void execute() {
		PlayerDao dao = new PlayerDao();
		String username = Console.askUserInput("please input username:");
		while(!dao.isExistUsername(username)){
			Console.println("username hasn't exists!");
			username = Console.askUserInput("please input username:");
		}
		String password = Console.askUserInput("please input password:");
		Player player = dao.login(username, password);
		if(player == null){
			Console.println("fail login on! username/password not corrent!");
			return;
		}
		BesuperApplication.getInstance().setPlayerProfile(player);
	}


}
