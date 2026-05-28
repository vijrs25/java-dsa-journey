package linkedList;

public class SortedMerge {

	static Node sortList(Node head) {

		if (head == null || head.next == null) {
			System.out.println("Base case reached: " + (head != null ? head.data : "null"));
			return head;
		}

		System.out.print("\nSplitting list: ");
		printList(head);

		Node mid = getMiddle(head);
		Node right = mid.next;
		mid.next = null;

		System.out.print("Left part: ");
		printList(head);

		System.out.print("Right part: ");
		printList(right);

		Node leftSorted = sortList(head);
		Node rightSorted = sortList(right);

		System.out.print("\nMerging left: ");
		printList(leftSorted);
		System.out.print("With right: ");
		printList(rightSorted);

		Node merged = merge(leftSorted, rightSorted);

		System.out.print("Merged result: ");
		printList(merged);
		System.out.println("-----------------------------------");

		return merged;
	}

	static Node getMiddle(Node head) {
		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		System.out.println("Middle found at node: " + slow.data);
		return slow;
	}

	static Node merge(Node a, Node b) {
		Node dummy = new Node(-1);
		Node tail = dummy;

		while (a != null && b != null) {
			if (a.data <= b.data) {
				System.out.println("Taking from left: " + a.data);
				tail.next = a;
				a = a.next;
			} else {
				System.out.println("Taking from right: " + b.data);
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}

		while (a != null) {
			System.out.println("Remaining left: " + a.data);
			tail.next = a;
			a = a.next;
			tail = tail.next;
		}

		while (b != null) {
			System.out.println("Remaining right: " + b.data);
			tail.next = b;
			b = b.next;
			tail = tail.next;
		}

		return dummy.next;
	}

	static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {

		Node head = new Node(4);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(5);

		System.out.println("Original List:");
		printList(head);

		head = sortList(head);

		System.out.println("\nFinal Sorted List:");
		printList(head);
	}
}
