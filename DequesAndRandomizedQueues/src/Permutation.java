import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	// Write a client program Permutation.java that takes an integer k as a command-line argument; reads in a sequence of strings from standard input using StdIn.readString(); and prints exactly k of them, uniformly at random
	public static void main(String[] args) {
		
		int numberOfElements = Integer.parseInt(args[0]);
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		
		while (!StdIn.isEmpty()) {
			q.enqueue(StdIn.readString());			
		}
		
		for (int i = 0; i < numberOfElements; i++) {
			System.out.println(q.dequeue());
		}
	}

}
