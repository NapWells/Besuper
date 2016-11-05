package beSuper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class Test {
	private static String command;
    private static BeSuper beSuper;
    private static User player = null;
    
	public static void loadBeSuper(){
		if(!new File("beSuper.xm").exists()){
			beSuper = new BeSuper();
			return;
		}
		try {
			JAXBContext ctx= JAXBContext.newInstance(BeSuper.class);
			beSuper = (BeSuper) ctx.createUnmarshaller().unmarshal(new FileInputStream("besuper.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void saveBeSuper() {
       try {
    	   JAXBContext ctx = JAXBContext.newInstance(BeSuper.class);
	       ctx.createMarshaller().marshal(beSuper, new File("besuper.xml"));
	       }catch (JAXBException e) {
	           e.printStackTrace();
	       }
	    }
	public static void printOrder(){
		System.out.println("help: 查看所有可用命令");
		System.out.println("exit: 退出程序");
		System.out.println("list: 打印所有问题");
		System.out.println("sak: 提问问题");
		System.out.println("answer: 回答问题");
		System.out.println("score: 查看得分");
	}
	public static void main(String [] args){
	
		loadBeSuper();
		Console.print("欢迎使用系统！");
		while(true){
			String name = Console.askUserInput("请输入你的用户名：");
			if("".equals(name)){
				System.out.println("用户名不能为空！");
				continue;
			}
			
			for(User user:  beSuper.getUserList()){
				if(name.equals(user.getName())){
					player = user;
				}
			}
			if(player == null){
				player = new User();
				player.setName(name);
				beSuper.getUserList().add(player);
				saveBeSuper();
			
			}
			break;
		}
		Console.println("欢迎， " + player.getName() + ".你可以使用'help'查看所有可用命令.");
		while(true){
			command = Console.askUserInput("cmd>").trim();
			if(command.equals("help")){
				printOrder();
			}
			else if(command.equals("exit")){
				System.out.println("再见！");
				System.exit(0);
			}
			else if(command.equals("list")){
				for(Question question : beSuper.getQuestionList())
					Console.println(question);
			}
			else if(command.equals("ask")){
				String conten = Console.askUserInput("请输入你的问题：");
				Question question = new Question();
				question.setContent(conten);
				question.setFrom(player.getName());
				beSuper.getQuestionList().add(question);
				saveBeSuper();
				Console.println("问题已经被创建");
			}
			else if(command.equals("answer")){
				String qid = Console.askUserInput("请输入问题的id：");
				Question q = null;
				Answer a = null;
				for(Question question : beSuper.getQuestionList()){ 
					if(Integer.parseInt(qid)==question.getId()){
						q = question;
						break;
					}
				}
				if(q==null){
					Console.println("问题不存在！");
				}
				else if(q.isSolved()==true){
					for(Answer answer : beSuper.getAnswerList()){
						if(q.getId() == answer.getId()){
							a = answer;
							break;
						}
					}
					Console.print("问题已经被解决！回答为：");
					Console.println(a);
				}
				else{
					String qcontent = Console.askUserInput("请输入你的回答：");
					a = new Answer();
					a.setContent(qcontent);
					a.setId(q.getId());
					a.setFrom(player.getName());
					player.setScore(player.getScore()+10);
					q.setSolved(true);
					beSuper.getAnswerList().add(a);
					saveBeSuper();
					Console.println("回答成功");
				}
			}
			else if(command.equals("score")){
				Console.println(player.getScore());
			}
			else{
				Console.println("输入无效，请重试!");
			}
		}
		
	}
}
