package com.liu.besuperMybatis.command.impl;

import com.liu.besuperMybatis.command.SystemCommand;
import com.liu.besuperMybatis.util.Console;

public class HelpSystemCommand extends SystemCommand{

	@Override
	public void execute() {
		Console.println("help : look at all commands!");
		Console.println("exit : exit system");
		Console.println("login : login on system!");
		Console.println("signup : rsgister user");
	}
	
}
