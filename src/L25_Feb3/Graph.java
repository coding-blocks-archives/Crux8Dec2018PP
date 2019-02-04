package L25_Feb3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Feb-2019
 *
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVetex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {

			Vertex nbrVtx = vtces.get(key);
			nbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);

	}

	public int numEdges() {

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;

		for (String key : keys) {

			Vertex vtx = vtces.get(key);
			count = count + vtx.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1); // 2k
		Vertex vtx2 = vtces.get(vname2); // 4k

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("------------------");
		ArrayList<String> vnames = new ArrayList<>(vtces.keySet());

		for (String vname : vnames) {

			String str = vname + " => ";

			Vertex vtx = vtces.get(vname);
			str += vtx.nbrs;

			System.out.println(str);
		}
		System.out.println("------------------");

	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {

		// direct edge
		if (containsEdge(vname1, vname2)) {
			return true;
		}

		processed.put(vname1, true);

		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {

			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed))
				return true;
		}

		return false;
	}

	private class Pair {
		String name;
		String psf;
		String color;
	}

	public boolean BFS(String src, String dst) {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// 1. make a pair and put in queue
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;

		queue.addLast(sp);

		// 2. work till the queue is not empty
		while (!queue.isEmpty()) {

			// 2.1 remove the pair from queue
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.name)) {
				continue;
			}

			// 2.2 processed
			processed.put(rp.name, true);

			// 2.3 direct edge
			if (containsEdge(rp.name, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 2.4 nbrs
			for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make pair for nbr and put in queue
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}

			}

		}

		return false;

	}

	public boolean DFS(String src, String dst) {

		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// 1. make a pair and put in queue
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;

		stack.addFirst(sp);

		// 2. work till the queue is not empty
		while (!stack.isEmpty()) {

			// 2.1 remove the pair from queue
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.name)) {
				continue;
			}

			// 2.2 processed
			processed.put(rp.name, true);

			// 2.3 direct edge
			if (containsEdge(rp.name, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 2.4 nbrs
			for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make pair for nbr and put in queue
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}

			}

		}

		return false;

	}

	public void BFT() {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;

			queue.addLast(sp);

			// 2. work till the queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				// 2.2 processed
				processed.put(rp.name, true);

				// 2.3 syso
				System.out.println(rp.name + " via " + rp.psf);

				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make pair for nbr and put in queue
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}

		}

	}

	public void DFT() {

		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;

			stack.addFirst(sp);

			// 2. work till the queue is not empty
			while (!stack.isEmpty()) {

				// 2.1 remove the pair from queue
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				// 2.2 processed
				processed.put(rp.name, true);

				// 2.3 syso
				System.out.println(rp.name + " via " + rp.psf);

				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make pair for nbr and put in queue
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}

				}

			}

		}

	}

	public boolean IsConnected() {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		int flag = 0;

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			flag++;
			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;

			queue.addLast(sp);

			// 2. work till the queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				// 2.2 processed
				processed.put(rp.name, true);

				// 2.3 syso

				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make pair for nbr and put in queue
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}

		}

		return flag == 1;

	}

	public boolean isCyclic() {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;

			queue.addLast(sp);

			// 2. work till the queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					return true;
				}

				// 2.2 processed
				processed.put(rp.name, true);

				// 2.3 syso

				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make pair for nbr and put in queue
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}

		}

		return false;

	}

	public boolean IsTree() {
		return IsConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			ArrayList<String> component = new ArrayList<>();

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;

			queue.addLast(sp);

			// 2. work till the queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				// 2.2 processed
				processed.put(rp.name, true);

				// 2.3 syso
				component.add(rp.name);

				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make pair for nbr and put in queue
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}

				}

			}

			ans.add(component);

		}

		return ans;

	}

	public boolean isBipartite() {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, String> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			sp.color = "r";

			queue.addLast(sp);

			// 2. work till the queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 remove the pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					String oc = processed.get(rp.name);
					String nc = rp.color;

					if (!nc.equals(oc)) {
						return false;
					}

					continue;
				}

				// 2.2 processed
				processed.put(rp.name, rp.color);

				// 2.4 nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make pair for nbr and put in queue
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						String c = rp.color.equals("r") ? "g" : "r";
						np.color = c;

						queue.addLast(np);
					}

				}

			}

		}

		return true;

	}

}
