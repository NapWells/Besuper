package com.liu.besuperMybatis.beans;

import java.util.List;

public class Question {
	private int id;
	private String value;
	private int credit;
	private int playerId;
	private String isOpen = "Y";
	private Player player;
	private List<Answer> answers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getScore() {
		return credit;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setScore(int score) {
		this.credit = score;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", value=" + value + ", credit=" + credit + ", playerId=" + playerId + ", isOpen="
				+ isOpen + "]";
	}

	
}
