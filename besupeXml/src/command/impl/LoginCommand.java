package command.impl;

import application.BesuperApplication;
import beans.Player;
import beans.PlayerCredential;
import besuperDAO.BesuperDao;
import command.SystemCommand;
import uitl.Console;

public class LoginCommand extends SystemCommand{
	@Override
	public void execute() {
		BesuperDao besuper = new BesuperDao();
		String username = Console.askUserInput("please input username:");
	
		while(!besuper.isUsernameExists(username)){
			Console.println("username hasn't exists!");
			username = Console.askUserInput("please input username:");
		}
		String password = Console.askUserInput("please input password:");
		PlayerCredential playerCredential = new PlayerCredential(username, password);
		Player player = besuper.login(playerCredential);
		if(player == null){
			Console.println("fail login on! username/password not corrent!");
			return;
		}
		BesuperApplication.getInstance().setPlayerProfile(player);
	}


}
