import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Smallest {
	static int lowest_sum = Integer.MAX_VALUE;
	public static MyLinkedList my_list;

	public static void main(String args[]) {

		my_list = new MyLinkedList();

		Scanner scanner = null;
		File file = new File("in.txt");

		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			return;
		}

		while (scanner.hasNextInt()) {

			my_list.add(scanner.nextInt());
		}

		System.out.println(Subset_Sum(my_list.head, 0, false));

	}

	public static int Subset_Sum(Node current, int running_sum, boolean flag) {

		if(current == null)
			{
			return Math.abs(running_sum);
			}
		if(current.next_node == null && flag == false)
		{
			return Math.abs(current.value);
		}
			//int s1 = Math.abs(Subset_Sum(current.next_node, running_sum, flag));
			//int s2 = Math.abs(Subset_Sum(current.next_node, running_sum + current.value, true));
			return Math.min(Math.abs(Subset_Sum(current.next_node, running_sum, flag)), Math.abs(Subset_Sum(current.next_node, running_sum + current.value, true)));
		
		
	}
}

class Node {

	Node next_node;
	int value;

	public Node(int data) {
		next_node = null;
		value = data;
	}

}

class MyLinkedList {
	Node head;

	public MyLinkedList() {

	}

	public void add(int data) {
		if (head == null) {
			head = new Node(data);
		}

		Node temp = new Node(data);
		Node current = head;

		if (current != null) {

			while (current.next_node != null) {
				current = current.next_node;
			}

			current.next_node = temp;
		}

	}
}
