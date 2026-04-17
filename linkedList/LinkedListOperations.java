package linkedList;

public class LinkedListOperations {

	public static void main(String[] args) {

		Node head = Node.generallist();

		head = Node.addFront(head, 1102);

		Node c = Node.inTheBack(head, 14);

		c = Node.deleteData(c, 6);

		c = Node.circular(c);
		
		
		System.out.println("List after all operation");
		Node.print(c);
		
		Node straightNode = Node.strainghtList(c);
		
		Node.print(straightNode);
//		while (straightNode.next != null) {
//			System.out.println("straight.data directly " + straightNode.data);
//			straightNode = straightNode.next;
//		}
		
		int position = Node.positionNumber(c, 1);
		System.out.println(position);
		System.out.println(Node.contains(c, 1));
		
		straightNode = Node.printReverse(straightNode);
 	    Node.print(straightNode);
	}

	public static Node create(Node node, int newData) {

		Node a = new Node(newData);
		node.next = a;

		return a;
	}
}
