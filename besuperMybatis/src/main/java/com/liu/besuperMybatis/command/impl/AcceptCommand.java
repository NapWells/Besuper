package com.liu.besuperMybatis.command.impl;

import com.liu.besuperMybatis.beans.Answer;
import com.liu.besuperMybatis.beans.Player;
import com.liu.besuperMybatis.beans.Question;
import com.liu.besuperMybatis.command.PlayerCommand;
import com.liu.besuperMybatis.dao.AnswerDao;
import com.liu.besuperMybatis.dao.PlayerDao;
import com.liu.besuperMybatis.dao.QuestionDao;
import com.liu.besuperMybatis.util.Console;


public class AcceptCommand extends PlayerCommand{

	public AcceptCommand(Player player) {
		super(player);
	}

	@Override
	public void execute() {
		AnswerDao daoA = new AnswerDao();
		QuestionDao daoQ = new QuestionDao();
		int qid = Console.askUserNumber("please input question id:");
		Question q = daoQ.getQuesionById(qid);
		if(q == null){
			Console.println("don't existst like this question that id = " + qid);
			return;
		}
		if(q.getPlayerId() != player.getId()){
			Console.println("your cann't operate other peopele's question !");
			return;
		}
		int aid = Console.askUserNumber("please input best answer id:");
		Answer a = daoA.getAnswerById(aid);
		
		if(a == null){
			Console.println("not exists this asnwer id!");
			return;
		}
		if(a.getPlayerId()== player.getId()){
			Console.println("can't choice yourself answer to be best answer");
			return;
		}
		
		q.setIsOpen("N");
		a.setBest("Y");
		daoA.updateAnswer(a);
		daoQ.updateQuestion(q);
		int score = q.getCredit() + a.getPlayer().getScore();
		player.setScore(score);
		new PlayerDao().updatePlayer(player);
	}

}
