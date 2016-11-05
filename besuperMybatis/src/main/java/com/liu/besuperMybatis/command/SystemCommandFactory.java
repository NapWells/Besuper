package com.liu.besuperMybatis.command;

import java.util.HashMap;
import java.util.Map;

import com.liu.besuperMybatis.command.impl.ExitCommand;
import com.liu.besuperMybatis.command.impl.HelpSystemCommand;
import com.liu.besuperMybatis.command.impl.LoginCommand;
import com.liu.besuperMybatis.command.impl.SignupCommand;



public class SystemCommandFactory extends CommandFactory{
	private static Map<CommandCode,Class<? extends Command>> commandMap = new HashMap<>();
	static{
		commandMap.put(CommandCode.EXIT,ExitCommand.class);	
		commandMap.put(CommandCode.HELP,HelpSystemCommand.class);
		commandMap.put(CommandCode.SIGNUP,SignupCommand.class);
		commandMap.put(CommandCode.LOGIN,LoginCommand.class);
		
	}
	
	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> cmdClass = commandMap.get(cmd);
		if(cmdClass != null){
			try {
				return cmdClass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


}
