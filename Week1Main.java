package week1;

public class Week1Main {

	public static void main(String[] args) throws Exception
	{
		System.out.print("true");
		LinkedList ll = new LinkedList();
		ll.addFront(5);
		ll.addFront(7);
		ll.addEnd(3);
		ll.removeFront();
		ll.display();

	}

}
