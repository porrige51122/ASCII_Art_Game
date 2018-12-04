import java.io.File;
import java.io.IOException;

public class Question {
	private File f;
	private String answer;
	private String path;

	public Question(String path) {
		this.path = path;
		f = new File(path);
		char[] chars = f.getName().toCharArray();
		answer = f.getName();
		char[] characterCount = answer.toCharArray();
		char[] output = new char[characterCount.length-4];
		answer.getChars(0, characterCount.length-4, answer, 0);
		return chars1;
	}

	public String getAnswer() {
		return answer;
	}

	public boolean isAnswerCorrect(String answer) {
		return this.answer.equals(answer);
	}

	public void print(int diff) throws IOException {
		ASCII.printImg(path, diff);
	}
}
