package L3_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2018
 *
 */

public class LowerUpper {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		char ch = scn.next().charAt(0);

		if (ch >= 'A' && ch <= 'Z') {
			System.out.println("upper");
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println("lower");
		} else {
			System.out.println("invalid");
		}

	}

}
