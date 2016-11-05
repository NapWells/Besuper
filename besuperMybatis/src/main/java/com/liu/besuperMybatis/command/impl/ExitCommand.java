package com.liu.besuperMybatis.command.impl;

import com.liu.besuperMybatis.command.SystemCommand;

public class ExitCommand extends SystemCommand{

	@Override
	public void execute() {
		System.exit(0);
	}

}
