package ex03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Map<Integer, Map<Integer, Integer>> weeklyGrades = new HashMap<>();
		int currentWeek = 1;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Week " + currentWeek);
			String input = scanner.nextLine();

			if (input.equals("42")) {
				break;
			}

			String[] grades = input.split(" ");
			if (grades.length != 5) {
				System.out.println("IllegalArgument");
				System.exit(-1);
			}

			Map<Integer, Integer> studentGrades = new HashMap<>();
			for (int i = 0; i < 5; i++) {
				studentGrades.put(i + 1, Integer.parseInt(grades[i]));
			}

			weeklyGrades.put(currentWeek, studentGrades);
			currentWeek++;
		}




	}

}
