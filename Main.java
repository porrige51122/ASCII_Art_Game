import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Main {
	static int diff;
	static String category;
	static final String path = "";
	static final List<Question> questions = new ArrayList<Question>();
	static final Set<Integer> used = new HashSet<Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
    	Scanner keys = new Scanner(System.in);

    	System.out.print("Enter category: ");
    	category = keys.next();

    	System.out.print("Enter diff (e, m, h): ");
		switch (keys.next()) {
    		case "e": diff = 75; break;
    		case "m": diff = 50; break;
    		case "h": diff = 20; break;
    		default: diff = 75; break;
		}

		File[] files = new File(path + category).listFiles();

		int p;
		for (int i = 0; i < files.length / 2; i++) {
			p = genNum(files.length);
			questions.add(new Question(files[p].getAbsolutePath()));
		}

		int points = 0;
    	String answer;
    	for (Question q : questions) {
    		q.print(diff);
    		System.out.print("Name the image: ");
    		answer = keys.next();
    		if (!q.isAnswerCorrect(answer)) {
    			System.out.println("Incorrect, the answer is " + q.getAnswer());
    		} else {
    			System.out.println("Correct");
    			points++;
    		}
    		TimeUnit.SECONDS.sleep(1);
    	}
    }

    public static int genNum(int length) {
    	int n = (int) (Math.random() * length);
    	if (used.contains(n)) return genNum(length);
    	used.add(n);
    	return n;
    }
}
