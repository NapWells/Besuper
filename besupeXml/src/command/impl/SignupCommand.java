package command.impl;

import java.util.regex.Pattern;

import application.BesuperApplication;
import beans.PlayerCredential;
import besuperDAO.BesuperDao;
import command.SystemCommand;
import uitl.Console;


public class SignupCommand extends SystemCommand{
	
	@Override
	public void execute() {
		String username = Console.askUserInput("please input username:");
		BesuperDao besuper = new BesuperDao();
		while(besuper.isUsernameExists(username)){
			Console.println("username has exists!");
			username = Console.askUserInput("please input username:");
		}
		String password = null;
		while(true){
			password = Console.askUserInput("please input password:");
			try {
				validatePassword(password);
				break;
			} catch (Exception e) {
				Console.println("password format not valid, " + e.getMessage());
				continue;
			}
		}
		String nickname = Console.askUserInput("please input nickename:");
		PlayerCredential player = new PlayerCredential(username,password);
		player.setName(nickname);
		BesuperApplication.getInstance().setPlayerProfile(besuper.signup(player));
	}
	
	private void validatePassword(String passwrod) throws Exception{
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if(!lenPattern.matcher(passwrod).find()){
			throw new Exception("password length must be bigger than 6");
		}
		
		Pattern numPattern = Pattern.compile("[0-9]");
		if(!numPattern.matcher(passwrod).find()){
			throw new Exception("password must be containe one number");
		}
		
		Pattern charPattern = Pattern.compile("[a-zA-Z]");
		if(!charPattern.matcher(passwrod).find()){
			throw new Exception("password must be containe one character");
		}
	}
	
}
