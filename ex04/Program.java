package ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        char[] chartChars = new char[10];
        int[] chartCounts = new int[10];

        for (char c : frequencyMap.keySet()) {
            int count = frequencyMap.get(c);

            for (int i = 0; i < 10; i++) {
                if (count > chartCounts[i]) {
                    for (int j = 9; j > i; j--) {
                        chartCounts[j] = chartCounts[j - 1];
                        chartChars[j] = chartChars[j - 1];
                    }

                    chartCounts[i] = count;
                    chartChars[i] = c;

                    break;
                }
            }
        }

		for (int i = 0; i < 10; i++) {
			if (chartCounts[i] > 999) {
				chartCounts[i] = 999;
			}
		}

        Object[][] chartMatrix = new Object[13][11];

        for (int col = 0; col < 10; col++) {
            int count = chartCounts[col];
            int row = 12;

            chartMatrix[row][col] = chartChars[col];

			if (chartCounts[0] > 10) {
				int max = chartCounts[0];
				count =  count * 10 / max;
			}
			row--;
            while (count > 0) {
				chartMatrix[row--][col] = "#";
				count--;
			}

			chartMatrix[row++][col] = chartCounts[col];
        }

		for (int row = 0; row < 13; row++) {
			boolean isNotEmpty = false;

			for (int col = 0; col < 11; col++) {
				Object value = chartMatrix[row][col];
				if (value != null && !(value.equals(0))) {
					System.out.print(value + " ");
					isNotEmpty = true;
				}
			}

			if (isNotEmpty) {
				System.out.println();
			}
		}


    }
}
