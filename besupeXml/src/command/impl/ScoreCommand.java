package command.impl;


import beans.Player;

import command.PlayerCommand;
import uitl.Console;



public class ScoreCommand extends PlayerCommand{
	public ScoreCommand(Player player){
		super(player);
	}
	@Override
	public void execute() {
		Console.println("-----------"+player.getName()+"--------------");
		Console.println("= all ask times :" + player.getQuestions().size());
		Console.println("= all answer times :" + player.getAnswers().size());
		Console.println("= now time score :" + player.getScore());
		int score = player.getScore();
		String level = "weakness";
		if(score > 100){
			level = "amazing";
		}else if(score > 90){
			level = "brillant";
		}else if(score > 80){
			level = "profect";
		}else if(score > 70){
			level = "good";
		}else if(score > 60){
			level = "passing";
		}
		Console.println("= at now,your level is : " + level);
	}

}
