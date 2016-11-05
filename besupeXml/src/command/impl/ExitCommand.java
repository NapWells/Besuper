package command.impl;

import command.SystemCommand;

public class ExitCommand extends SystemCommand{

	@Override
	public void execute() {
		System.exit(0);
	}

}
