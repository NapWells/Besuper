package beSuper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
	private static int num = 0;
	
	@XmlAttribute(name = "id")
	private int id = num++;
	
	@XmlAttribute(name = "from")
	private String from;
	
	@XmlAttribute(name = "solved")
	private boolean solved;
	
	@XmlElement
	private String content;
	
	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		 String template = "[%s] %s. [%s] from %s";
		String solve = isSolved()?"SOLVED":"UNSOLVED";
		return String.format(template, solve, id, content, from);
	}
	
	
	
	
}
