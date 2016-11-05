package beSuper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beSuper")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeSuper {
	@XmlElementWrapper(name = "users")
	@XmlElement(name = "question")
	private List<User> userList = new ArrayList<User>();
	
	@XmlElementWrapper(name = "questions")
	@XmlElement(name = "question")
	private List<Question> questionList = new ArrayList<Question>();
	
	@XmlElementWrapper(name = "answers")
	@XmlElement(name = "answer")
	private List<Answer> answerList = new ArrayList<Answer>();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	
}
