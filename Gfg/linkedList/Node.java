package linkedList;

public class Node {
	int data;
	Node next;
	static int count = 0;

	public Node(int newData) {
		this.data = newData;
	}

	Node() {

	}

	static Node generallist() {
		System.out.println("General data 1 to 10");

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);

		Node a = head.next.next.next = new Node(4);
		a.next = new Node(5);
		a.next.next = new Node(6);

		Node b = a.next.next.next = new Node(7);
		b.next = new Node(8);
		b.next.next = new Node(9);
		b.next.next.next = new Node(10);
		count = 10;
		return head;
	}

	static Node addFront(Node node, int newData) {
		Node a = new Node(newData);
		a.next = node;
		count++;
		System.out.println("Adding data in the front " + newData);
		return a;
	}

	static Node inTheBack(Node node, int newData) {

		Node backNode = new Node(newData);
		if (node == null) {
			return backNode;
		}

		Node temp = node;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = backNode;
		count++;
		System.out.println("Adding data in the back " + newData);
		return node;
	}

	public static Node deleteData(Node temp, int i) {
		System.out.println("delete node int " + i);
		Node c = temp;
		while (c.next != null) {

			if (c.next.data == i) {
				c.next = c.next.next;
				break;
			} else {
				c = c.next;
			}
		}
		count--;
		return temp;
	}

	public static Node circular(Node c) {
		System.out.println("Circular Node");
		Node temp = c;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = c;
		return c;
	}

	public static Node strainghtList(Node node) {
		System.out.println("Stright List");
		Node nullNode = new Node();
		Node temp = node;
		int i = 1;
		while (i < count) {
			temp = temp.next;
			i++;
		}

		// System.out.println(temp.next.data);
		temp.next = nullNode;
		return node;
	}

	static void print(Node node) {
		System.out.println("Printing list from Internal");
		int currentCount = 0;
		while (node.next != null && currentCount < count*2) {
			System.out.println("node data " + node.data);
			node = node.next;
			currentCount++;
		}
	}

	public static int positionNumber(Node node, int i) {

		Node temp = node;
		int position = 1;
		while (temp.next != null) {
			if (temp.data == i) {
				return position;
			}
			position++;
			temp = temp.next;
		}
		return -1;
	}

	public static boolean contains(Node node, int i) {
		while (node.next != null) {
			if (node.data == i) {

				return true;

			}
			node = node.next;
		}
		return false;
	}

	public static Node printReverse(Node straightNode) {
		
		Node prevNode = null;
		Node nextNode = null;		
		Node currentNode = straightNode;
		// 1  -> 2  -> 3  ->  4 -> 5 -> 6
		// 3 -> 2 -> 1
		while(currentNode.next!=null) {
			nextNode = currentNode.next;   // future save
		    currentNode.next = prevNode;   // reverse link
		    prevNode = currentNode;        // move prev
		    currentNode = nextNode; 
		}
		
		return prevNode;
	}
	
	 static boolean DetectCycle(Node node){
		 Node slow = node;
		 Node fast = node;
		 
		 while(slow!= null && fast != null && fast.next !=null)
			      slow = slow.next;
		 		  fast = fast.next.next;
		 		  if(slow == fast) {
		 			 System.out.println("true");
		 			  return true;
		 			  
		 		  }
		 		 System.out.println("false");
		 return false;
	}

}
