package ex01;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();

		if (number <= 1) {
			System.out.println("IllegalArgument");
			System.exit(-1);
		}

		boolean isPrime = true;

		int iterationCount = 0;
		
		for (int i = 2; i <= Math.sqrt(number); i++) {
			iterationCount++;

			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}

		System.out.println(isPrime + " " + iterationCount);
	}
}
