package driver;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		Node<Integer> a = new Node();
		a.Payload = 1;
		Node<Integer> b = new Node();
		b.Payload = 283;
		Node<Integer> c = new Node();
		c.Payload = 83;
		Node<Integer> d = new Node();
		d.Payload = 12;
		Node<Integer> e = new Node();
		e.Payload = 3;
		list.Append(a);
		list.Append(b);
		list.Append(c);
		list.Append(d);
		list.Append(e);
		
		printList(list);
		
		list.Sort(true);
		printList(list);
		
		list.Sort(false);
		printList(list);
	}
	
	private static <T> void printList(DoublyLinkedList<T> list) {
	    Node<T> node = list.Header;
	    while (node != null) {
	        System.out.print(node.Payload + " ");
	        node = node.NextNode;
	    }
	    System.out.println();
	}

}