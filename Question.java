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
	}

	public String getAnswer() {
		return answer;
	}

	public boolean isAnswerCorrect(String answer) {
		return this.answer.equals(answer + ".jpg") || this.answer.equals(answer + ".png");
	}

	public void print(int diff) throws IOException {
		ASCII.printImg(path, diff);
	}
}
