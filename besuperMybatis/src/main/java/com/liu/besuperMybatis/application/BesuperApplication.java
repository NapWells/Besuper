package com.liu.besuperMybatis.application;

import com.liu.besuperMybatis.beans.Player;
import com.liu.besuperMybatis.command.Command;
import com.liu.besuperMybatis.command.CommandFactory;
import com.liu.besuperMybatis.command.CommandFactory.CommandCode;
import com.liu.besuperMybatis.util.Console;

public class BesuperApplication {
	private Player playerProfile;
	private static BesuperApplication instance = null;
	private BesuperApplication(){}
	public static synchronized BesuperApplication getInstance(){
		if(instance ==null){
			instance = new BesuperApplication();
		}
		return instance;
	}
	
	public Player getPlayerProfile(){
		return playerProfile;
	}
	public void setPlayerProfile(Player playerProfile){
		this.playerProfile = playerProfile;
	}
	
	public static void main(String [] args){
		Console.println("welcome to use system! input 'help' look at all useage command!");
		while(true){
			String cmd = Console.askUserInput("cmd>");
			CommandCode cmdCode = null;
			try{
				cmdCode = CommandCode.valueOf(cmd.toUpperCase());
				CommandFactory factory = CommandFactory.getFactory((BesuperApplication.getInstance().getPlayerProfile()));
				Command command  = factory.buildCommand(cmdCode);
				command.execute();
			}catch(Exception e){
				Console.println("can't distinguish you input, please input 'HELP' look at available command!");
			}
			
		}
	}
}

