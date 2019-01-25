package Assignments.Jan25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jan-2019
 *
 */

public class Hoodies {

	public static void main(String[] args) {

		Queue<Integer>[] queues = new Queue[5];

		for (int i = 0; i < queues.length; i++) {
			queues[i] = new LinkedList<>();
		}

		ArrayList<Integer> order = new ArrayList<>();

		Scanner scn = new Scanner(System.in);

		int ops = scn.nextInt();

		while (ops > 0) {

			char ch = scn.next().charAt(0);

			if (ch == 'E') {

				int courseNo = scn.nextInt();
				int rollNo = scn.nextInt();

				queues[courseNo].add(rollNo);

				if (!order.contains(courseNo)) {
					order.add(courseNo);
				}

			} else {

				Queue<Integer> pq = queues[order.get(0)];

				System.out.println(order.get(0) + "  " + pq.remove());

				if (pq.isEmpty()) {
					order.remove(0);
				}

			}
			ops--;
		}
	}

}
