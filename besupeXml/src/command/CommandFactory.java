package command;

import beans.Player;

public abstract class CommandFactory {
	
	public static enum CommandCode{
		//system
		EXIT,
		HELP,
		LOGIN,
		SIGNUP,
		
		//player
		ASK,
		ANSWER,
		SCORE,
		LIST,
		ACCEPT
	}
	
	public static CommandFactory getFactory(Player player){
		if(player != null)
			return new PlayerCommandFactory(player);
		return new SystemCommandFactory();
	}
	
	public abstract Command buildCommand(CommandCode cmd);
}
