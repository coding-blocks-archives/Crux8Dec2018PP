package L3_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2018
 *
 */

public class Temp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int min = scn.nextInt();
		int max = scn.nextInt();
		int step = scn.nextInt();

		int temp = min;

		while (temp <= max) {

			int c = (int) ((5.0 / 9) * (temp - 32));

			System.out.println(temp + "\t" + c);

			temp = temp + step;

		}

	}

}
