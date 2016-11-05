package command.impl;

import beans.Answer;
import beans.Player;
import beans.Question;
import besuperDAO.BesuperDao;
import command.PlayerCommand;
import uitl.Console;

public class AnswerCommand extends PlayerCommand{

	public AnswerCommand(Player player){
		super(player);
	}
	@Override
	public void execute() {
		int qid = Console.askUserNumber("please input question id:");
		
		BesuperDao besuper = new BesuperDao();
		Question q = besuper.getQuestion(qid);
		
		if(q == null){
			Console.println("don't existst like this question that id = " + qid);
			return;
		}
		
		if(q.getFrom().getId() == player.getId()){
			Console.println("cann't anwer youself question!");
			return;
		}
		String content = Console.askUserInput("input your answer:");
		Answer answer = new Answer(-1,content,player);
		besuper.upsertAnwser(answer);
		
		player.getAnswers().add(answer);
		q.getAnswers().add(answer);
	}

}
