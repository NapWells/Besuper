package command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import beans.Player;
import command.impl.AcceptCommand;
import command.impl.AnswerCommand;
import command.impl.AskCommand;
import command.impl.HelpPlayerComand;
import command.impl.ListCommand;
import command.impl.ScoreCommand;



public class PlayerCommandFactory extends SystemCommandFactory{
	
	private static Map<CommandCode,Class<? extends Command>> commandMap = new HashMap<>();
	static{
		commandMap.put(CommandCode.LIST,ListCommand.class);	
		commandMap.put(CommandCode.ASK,AskCommand.class);
		commandMap.put(CommandCode.ANSWER,AnswerCommand.class);
		commandMap.put(CommandCode.ACCEPT,AcceptCommand.class);
		commandMap.put(CommandCode.SCORE,ScoreCommand.class);
		commandMap.put(CommandCode.HELP,HelpPlayerComand.class);
	}
	
	protected Player player;
	public PlayerCommandFactory(Player player){
		this.player = player;
	}
	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> cmdClass = commandMap.get(cmd);
		if(cmdClass !=null){
			try {
				return cmdClass.getConstructor(Player.class).newInstance(player);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return super.buildCommand(cmd);
	}
}
