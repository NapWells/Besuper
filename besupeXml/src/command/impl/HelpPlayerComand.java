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
		Console.println("exit £º exit system£¡");
		Console.println("help £º help how to user system£¡");
		Console.println("list £º look at all question£¡");
		Console.println("ask £º ask a question£¡");
		Console.println("answer £º answer a question£¡");
		Console.println("acceppt £º choiese a best answer with one question£¡");
		Console.println("score £º look at now user score£¡");
	}
	
}
