package command.impl;

import beans.Player;
import command.PlayerCommand;
import uitl.Console;

public class HelpPlayerComand extends PlayerCommand{

	public HelpPlayerComand(Player player) {
		super(player);
	}

	@Override
	public void execute() {
		Console.println("exit �� exit system��");
		Console.println("help �� help how to user system��");
		Console.println("list �� look at all question��");
		Console.println("ask �� ask a question��");
		Console.println("answer �� answer a question��");
		Console.println("acceppt �� choiese a best answer with one question��");
		Console.println("score �� look at now user score��");
	}
	
}
