import java.io.File;
import java.io.IOException;

public class Question {
	private File f;
	private String answer;
	private String path;

	public Question(String path) {
		this.path = path;
		f = new File(path);
		char[] extension = f.getName().toCharArray();
		answer = "";
		for (int i = 0;i < extension.length-4 ;i++) {
			answer += String.valueOf(extension[i]);
		}
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
