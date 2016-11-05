package com.liu.besuperMybatis.command.impl;

import com.liu.besuperMybatis.beans.Answer;
import com.liu.besuperMybatis.beans.Player;
import com.liu.besuperMybatis.beans.Question;
import com.liu.besuperMybatis.command.PlayerCommand;
import com.liu.besuperMybatis.dao.AnswerDao;
import com.liu.besuperMybatis.dao.QuestionDao;
import com.liu.besuperMybatis.util.Console;


public class AnswerCommand extends PlayerCommand{

	public AnswerCommand(Player player){
		super(player);
	}
	@Override
	public void execute() {
		int qid = Console.askUserNumber("please input question id:");
		AnswerDao daoA = new AnswerDao();
		QuestionDao daoQ = new QuestionDao();
		Question q = daoQ.getQuesionById(qid);
		if(q == null){
			Console.println("don't existst like this question that id = " + qid);
			return;
		}
		if(q.getPlayerId() == player.getId()){
			Console.println("cann't anwer youself question!");
			return;
		}
		String content = Console.askUserInput("input your answer:");
		Answer answer = new Answer();
		answer.setPlayerId(player.getId());
		answer.setValue(content);
		answer.setQuestionId(qid);
		daoA.insertAnswer(answer);
		
		player.getAnswers().add(answer);
		q.getAnswers().add(answer);
	}

}
