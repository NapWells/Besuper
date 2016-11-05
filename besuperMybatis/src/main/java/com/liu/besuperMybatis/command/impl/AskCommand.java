package com.liu.besuperMybatis.command.impl;

import com.liu.besuperMybatis.beans.Player;
import com.liu.besuperMybatis.beans.Question;
import com.liu.besuperMybatis.command.PlayerCommand;
import com.liu.besuperMybatis.dao.QuestionDao;
import com.liu.besuperMybatis.util.Console;

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
		QuestionDao dao = new QuestionDao();
		Question question = new Question();
		question.setCredit(credit);
		question.setValue(content);
		question.setPlayerId(player.getId());
		question = dao.insertQuestion(question);
		player.getQuestions().add(question);
		player.setScore(player.getScore()-credit);
	}

}
