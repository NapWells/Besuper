package command;

import beans.Player;

public abstract class PlayerCommand implements Command{
	protected Player player;

	public PlayerCommand(Player player) {
		this.player = player;
	}
	
}
