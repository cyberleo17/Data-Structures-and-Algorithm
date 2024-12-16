import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BSTTest {
	public static void main(String[] args) throws FileNotFoundException {
		BST b1 = new BST();
		System.out.println("BST Test Program - Chong Yi Chin\n");
		System.out.println("1) Building a Tree");
		System.out.println("========================\n");
		System.out.println("  Initially: " + b1 + "\n");
		b1.insert(3.0, "A");
		System.out.println("  Insert (3.0, A): \n" + b1);
		b1.insert(5.0, "B");
		System.out.println("  Insert (5.0, B) \n" + b1);
		b1.insert(2.0, "C");
		System.out.println("  Insert (2.0, C) \n" + b1);
		b1.insert(6.0, "D");
		System.out.println("  Insert (6.0, D) \n" + b1);
		b1.insert(4.0, "E");
		System.out.println("  Insert (4.0, E) \n" + b1);
		System.out.println("2) Finding Elements");
		System.out.println("========================\n");
		System.out.println("  b1.find(2.0): " + b1.find(2.0));
		System.out.println("  b1.find(3.0): " + b1.find(3.0));
		System.out.println("  b1.find(4.0): " + b1.find(4.0));
		System.out.println("  b1.find(5.0): " + b1.find(5.0));
		System.out.println("  b1.find(6.0): " + b1.find(6.0));
		System.out.println("\n3) Deleting Elements");
		System.out.println("========================\n");
		BST b2 = new BST();
		b2.insert(6.0, "E");
		b2.insert(3.0, "H");
		b2.insert(9.0, "I");
		b2.insert(2.0, "F");
		b2.insert(5.0, "C");
		b2.insert(1.0, "A");
		b2.insert(4.0, "G");
		b2.insert(7.0, "J");
		b2.insert(10.0, "D");
		b2.insert(8.0, "B");
		b2.insert(11.0, "K");
		System.out.println("  Initially:\n  " + b2 + "\n");
		System.out.println("  Delete(1.0) Left child, leaf: " + b2.delete(1.0));
		System.out.println("  " + b2);
		System.out.println("  Delete(8.0) Right child, leaf: " + b2.delete(8.0));
		System.out.println("  " + b2);
		System.out.println("  Delete(5.0) Has left child, internal: " + b2.delete(5.0));
		System.out.println("  " + b2);
		System.out.println("  Delete(10.0) Has right child, internal: " + b2.delete(10.0));
		System.out.println("  " + b2);
		System.out.println("  Delete(6.0) Has two children, internal: " + b2.delete(6.0));
		System.out.println("  " + b2);
		System.out.println("4) A Large Tree");
		System.out.println("========================\n");
		BST b3 = new BST();
		ArrayList<String> words = readWords();
		for (int i = 0; i < 10; i++) {
			double k = Math.random() * 1000.0;
			String v = words.get((int) (Math.random() * words.size())).toLowerCase();
			b3.insert(k, v);
		}
		System.out.printf("  First 10: Size is now %d\n  %s\n", b3.size(), b3);
		for (int i = 10; i < 100_000; i++) {
			double k = Math.random() * 1000.0;
			String v = words.get((int) (Math.random() * words.size())).toLowerCase();
			b3.insert(k, v);
		}
		System.out.printf("  Remaining Elements: Size is now %d\n", b3.size());
	}

	private static ArrayList<String> readWords() throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<String>();
		File inputFile = new File("words.txt");
		Scanner in = new Scanner(inputFile);
		while (in.hasNext()) {
			words.add(in.next());
		}
		in.close();
		return words;
	}
}