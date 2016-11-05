package command.impl;

import java.util.ArrayList;
import java.util.List;

import beans.Player;
import beans.Question;
import besuperDAO.BesuperDao;
import command.PlayerCommand;
import uitl.Console;

public class ListCommand extends PlayerCommand{
	public ListCommand(Player player){
		super(player);
	}
	@Override
	public void execute() {
		String listMode = Console.askUserInput("choose your want to list question (ALL/MINE/OPEN/ID):");
		if(!"ALL|MINE|OPEN|ID".contains(listMode.toUpperCase())){
			Console.println("don't support your input type!" + listMode);
			return;
		}
		BesuperDao besuper = new BesuperDao();
		List<Question> questions = new ArrayList<>();
		if("ALL".equalsIgnoreCase(listMode)){
			questions = besuper.getQuestions();
		}else if("MINE".equalsIgnoreCase(listMode)){
			questions = besuper.getQuestionsFrom(player);
		}else if("OPEN".equalsIgnoreCase(listMode)){
			List<Question> tmpList = besuper.getQuestions();
			for(Question q : tmpList){
				if(q.isOpen())
					questions.add(q);
			}
		}else if("ID".equalsIgnoreCase(listMode)){
			long id = Console.askUserLong("please input question id:");
			Question question = besuper.getQuestion(id);
			questions.add(question);
		}
		for(Question q: questions){
			Console.println(q);
		}
	}
	


}
