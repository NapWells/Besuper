package command.impl;

import beans.Answer;
import beans.Player;
import beans.Question;
import besuperDAO.BesuperDao;
import command.PlayerCommand;
import uitl.Console;

public class AcceptCommand extends PlayerCommand{

	public AcceptCommand(Player player) {
		super(player);
	}

	@Override
	public void execute() {
		BesuperDao besuper = new BesuperDao();
		long qid = Console.askUserLong("please input question id:");
		Question q = besuper.getQuestion(qid);
		if(q == null){
			Console.println("don't existst like this question that id = " + qid);
			return;
		}
		if(q.getFrom().getId() != player.getId()){
			Console.println("your cann't operate other peopele's question !");
			return;
		}
		
		int aid = Console.askUserNumber("please input best answer id:");
		Answer a = besuper.getAnswer(aid);
		
		if(a == null){
			Console.println("not exists this asnwer id!");
			return;
		}
		
		if(a.getFrom().getId() == player.getId()){
			Console.println("can't choice yourself answer to be best answer");
			return;
		}
		
		
		q.setOpen(false);
		q.setBestAnswer(a);
		a.setBestAnswer(true);
		
		Player answerFrom = a.getFrom();
		int score = q.getCredit() + answerFrom.getScore();
		answerFrom.setScore(score);
		besuper.updatePlayer(player);
		besuper.acceptAnswer(q, a);

	}

}
