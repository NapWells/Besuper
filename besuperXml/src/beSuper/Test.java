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
		System.out.println("help: �鿴���п�������");
		System.out.println("exit: �˳�����");
		System.out.println("list: ��ӡ��������");
		System.out.println("sak: ��������");
		System.out.println("answer: �ش�����");
		System.out.println("score: �鿴�÷�");
	}
	public static void main(String [] args){
	
		loadBeSuper();
		Console.print("��ӭʹ��ϵͳ��");
		while(true){
			String name = Console.askUserInput("����������û�����");
			if("".equals(name)){
				System.out.println("�û�������Ϊ�գ�");
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
		Console.println("��ӭ�� " + player.getName() + ".�����ʹ��'help'�鿴���п�������.");
		while(true){
			command = Console.askUserInput("cmd>").trim();
			if(command.equals("help")){
				printOrder();
			}
			else if(command.equals("exit")){
				System.out.println("�ټ���");
				System.exit(0);
			}
			else if(command.equals("list")){
				for(Question question : beSuper.getQuestionList())
					Console.println(question);
			}
			else if(command.equals("ask")){
				String conten = Console.askUserInput("������������⣺");
				Question question = new Question();
				question.setContent(conten);
				question.setFrom(player.getName());
				beSuper.getQuestionList().add(question);
				saveBeSuper();
				Console.println("�����Ѿ�������");
			}
			else if(command.equals("answer")){
				String qid = Console.askUserInput("�����������id��");
				Question q = null;
				Answer a = null;
				for(Question question : beSuper.getQuestionList()){ 
					if(Integer.parseInt(qid)==question.getId()){
						q = question;
						break;
					}
				}
				if(q==null){
					Console.println("���ⲻ���ڣ�");
				}
				else if(q.isSolved()==true){
					for(Answer answer : beSuper.getAnswerList()){
						if(q.getId() == answer.getId()){
							a = answer;
							break;
						}
					}
					Console.print("�����Ѿ���������ش�Ϊ��");
					Console.println(a);
				}
				else{
					String qcontent = Console.askUserInput("��������Ļش�");
					a = new Answer();
					a.setContent(qcontent);
					a.setId(q.getId());
					a.setFrom(player.getName());
					player.setScore(player.getScore()+10);
					q.setSolved(true);
					beSuper.getAnswerList().add(a);
					saveBeSuper();
					Console.println("�ش�ɹ�");
				}
			}
			else if(command.equals("score")){
				Console.println(player.getScore());
			}
			else{
				Console.println("������Ч��������!");
			}
		}
		
	}
}
