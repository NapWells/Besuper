package com.liu.besuperMybatis.command;

import com.liu.besuperMybatis.beans.Player;

public abstract class PlayerCommand implements Command{
	protected Player player;

	public PlayerCommand(Player player) {
		this.player = player;
	}
	
}
