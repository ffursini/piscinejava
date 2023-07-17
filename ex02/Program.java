package ex02;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int coffeeRequests = 0;

		while (true) {
			int query = scanner.nextInt();

			if (query == 42) {
				break;
			}

			int sumOfDigits = calculateSumOfDigits(query);

			if (isPrime(sumOfDigits)) {
				coffeeRequests++;
			}
		}
			System.out.println("Count of coffee-request - " + coffeeRequests);

	}

	private static int calculateSumOfDigits(int number) {
		int sum = 0;

		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}

		return sum;
	}

	private static boolean isPrime(int number) {
		boolean isPrime = true;

		if (number <= 1) {
			isPrime = false;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}
