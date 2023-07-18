package ex03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Map<Integer, Map<Integer, Integer>> weeklyGrades = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String weekInput = scanner.nextLine();

            if (weekInput.equals("42")) {
                break;
            }

            if (!weekInput.matches("Week [1-9]|1[0-8]")) {
                invalidArgument();
            }

            int week = Integer.parseInt(weekInput.substring(5));
            if (weeklyGrades.containsKey(week)) {
				invalidArgument();
            }

            String gradesInput = scanner.nextLine();
            String[] grades = gradesInput.split(" ");

            if (grades.length != 5) {
                invalidArgument();
            }

            Map<Integer, Integer> studentGrades = new HashMap<>();
            for (int i = 0; i < 5; i++) {
                int grade = Integer.parseInt(grades[i]);
                if (grade < 1 || grade > 9) {
                    invalidArgument();
                }
                studentGrades.put(i + 1, grade);
            }

            weeklyGrades.put(week, studentGrades);
        }

		printStudentProgress(weeklyGrades);
	}

	private static void invalidArgument() {
		System.err.println("IllegalArgument");
		System.exit(-1);
	}

	private static void printStudentProgress(Map<Integer, Map<Integer, Integer>> weeklyGrades) {
		for (int week : weeklyGrades.keySet()) {
			System.out.print("Week " + week + " ");

			Map<Integer, Integer> studentGrades = weeklyGrades.get(week);
			int minGrade = Integer.MAX_VALUE;

			for (int grade : studentGrades.values()) {
				minGrade = Math.min(minGrade, grade);
			}

			for (int j = 1; j <= minGrade; j++) {
				System.out.print("=");
			}

			System.out.println(">");
		}
	}
}
