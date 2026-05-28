package linkedList;

public class RemoveNthNode {

	public static void main(String[] args) {
		Node node = Node.generallist();

		int k = 11;
		Node latest = removeNthNodeFS(node, k);
		while (latest != null) {
			System.out.println(latest.data);
			latest = latest.next;

		}
	}

	private static Node removeNthNode(Node temp, int k) {
		int count = 0;
		Node node = temp;
		while (node != null) {
			count++;
			node = node.next;
		}
		// System.out.println(count);
		int removeNumber = count - k ;

		Node node2 = temp;
		while (node2 != null) {
			if (removeNumber == 1) {
				node2.next = node2.next.next;

				System.out.println("At RN 2 " + node2.data);
			}
			removeNumber--;
			// System.out.println(removeNumber);
			node2 = node2.next;
		}
		return temp;
	}
	
	static Node removeNthNodeFS(Node node , int k){
		
		Node fast= node;
		Node slow= node;
		
		for(int i = 0;i< k ;i++) {
			if(fast == null) {
				return node;
			}
			fast = fast.next;
		}
		
		if(fast==null) {
			return node.next;
		}
		
		while(fast!=null) {
			fast = fast.next;
			slow= slow.next;
		}
		
		slow.next = slow.next.next;
		return node;
	}

}
