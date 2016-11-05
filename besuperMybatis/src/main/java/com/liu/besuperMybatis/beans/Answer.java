package com.liu.besuperMybatis.beans;

public class Answer {
	private int id;
	private String value;
	private String best = "N";
	private int playerId;
	private Player player;
	private int questionId;
	private Question question;
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
	
	public String getBest() {
		return best;
	}
	public void setBest(String best) {
		this.best = best;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", value=" + value + ", best=" + best + ", playerId=" + playerId + ", questionId="
				+ questionId + "]";
	}
	
}
