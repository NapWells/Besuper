package com.liu.besuperMybatis.command.impl;

import java.util.ArrayList;
import java.util.List;

import com.liu.besuperMybatis.beans.Player;
import com.liu.besuperMybatis.beans.Question;
import com.liu.besuperMybatis.command.PlayerCommand;
import com.liu.besuperMybatis.dao.QuestionDao;
import com.liu.besuperMybatis.util.Console;


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
		QuestionDao dao = new QuestionDao();
		List<Question> questions = new ArrayList<>();
		if("ALL".equalsIgnoreCase(listMode)){
			questions = dao.getAllQuestions();
		}else if("MINE".equalsIgnoreCase(listMode)){
			questions = dao.getQuestionsByPlayerId(player.getId());
		}else if("OPEN".equalsIgnoreCase(listMode)){
			questions = dao.getQuestionsIsOpen();
		}else if("ID".equalsIgnoreCase(listMode)){
			int id = Console.askUserNumber("please input question id:");
			Question question = dao.getQuesionById(id);
			questions.add(question);
		}
		for(Question q: questions){
			Console.println(q);
		}
		
	}
	


}
