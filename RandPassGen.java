import java.util.Scanner;

public class RandPassGen {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("How many Random passwords do you want to generate?");
		int total = in.nextInt();
		System.out.println("How many characters long do you want each password?");
		int length = in.nextInt();

		String[] randomPasswords = new String[total];

		for (int i = 0; i < total; i++) {
			String randomPassword = "";
			for (int j = 0; j < length; j++) {
				randomPassword += randomCharacter();
			}
			randomPasswords[i] = randomPassword;
		}
		printPasswords(randomPasswords);
	}

	public static void printPasswords(String[] passwords) {
		for (int i = 0; i < passwords.length; i++) {
			System.out.println(passwords[i]);
		}
	}

	public static char randomCharacter() {
		int rand = (int) (Math.random() * 62);
		if (rand <= 9) {
			int ascii = rand + 48;
			return (char) (ascii);
		} else if (rand <= 35) {
			int ascii = rand + 55;
			return (char) (ascii);
		} else {
			int ascii = rand + 61;
			return (char) (ascii);
		}
	}
}
