package linkedList;

public class LinkedListOperations {

	public static void main(String[] args) {

		Node head = Node.generallist();

		head = Node.addFront(head, 1102);

		Node c = Node.inTheBack(head, 14);

		c = Node.deleteData(c, 6);
		System.out.println(Node.DetectCycle(c));
		c = Node.circular(c);
		//Node.print(c);
		
		//detect Circular List
		//System.out.println(Node.DetectCycle(c));
		
		Node allOperation = Node.generallist();
		System.out.println("List after all operation");
		Node.print(allOperation);

		Node straightNode = Node.strainghtList(allOperation);

		Node.print(straightNode);

		int position = Node.positionNumber(c, 1);
		System.out.println(position);
		System.out.println(Node.contains(c, 1));

		straightNode = Node.printReverse(straightNode);
		Node.print(straightNode);
	}

}
