package linkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		Node a = new Node(1);
		Node b = a.next = new Node(2);
		Node c = b.next = new Node(3);
		System.out.println("A data " + a.data + " B data " + b.data);

		Node node = head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}

		Node revNode = reverseLinkedList(head);
		while (revNode != null) {
			System.out.print(" node.data " + revNode.data);
			revNode = revNode.next;
		}
	}

	static Node reverseLinkedList(Node head) {
		System.out.println("revered linked list");
		Node current = head;
		Node prev = null;
		Node nextNode = null;
		
		int count=0;
		System.out.println("current "+current.data);
		while (current != null) {
			count++;
			nextNode = current.next;
			if (nextNode == null) {
				System.out.println("nextNode is null");
			} else {
				System.out.println(count+".-> nextnode data " + nextNode.data + " current.next Node " + current.next.data);
			}

			current.next = prev;
			if (current.next == null) {
				System.out.println("current.next == null");
			} else {
				System.out.println("current.next " + current.next.data + " Prev " + prev.data);
			}

			prev = current;
			System.out.println("prev " + prev.data + " current " + current.data);
			current = nextNode;
			if(current == null) {
				System.out.println("current is null");

			}else {
				System.out.println("current " + current.data + " nextNode " + nextNode.data);

			}

			System.out.println();
		}

		return prev;
	}
}

class Node {
	int data;
	Node next;

	Node(int newData) {
		this.data = newData;
	}
}
