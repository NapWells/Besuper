package command.impl;

import beans.Player;
import beans.Question;
import besuperDAO.BesuperDao;
import command.PlayerCommand;
import uitl.Console;

public class AskCommand extends PlayerCommand{

	public AskCommand(Player player) {
		super(player);
	}

	@Override
	public void execute() {
		String content = Console.askUserInput("please input your question:");
		int credit = Console.askUserNumber("please input award of your question:");
		if(credit > player.getScore()){
			credit = player.getScore();
			Console.println("input reward less than you has score,use your score with default.");
		}
		BesuperDao besuper = new BesuperDao();
		Question q = new Question(-1,content,player,credit);
		besuper.upsertQuestion(q);
		player.getQuestions().add(q);
		player.setScore(player.getScore()-credit);
		
	}

}
