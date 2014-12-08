
import org.junit.Test;


public class BSTTest {

	@Test
	public void test() {
		BST bst = new BST();
		
		bst.insert(9);
		bst.insert(5);
		bst.insert(7);
		bst.insert(10);
		bst.insert(0);
		bst.insert(6);
		bst.insert(11);
		bst.insert(-1);
		bst.insert(1);
		bst.insert(2);
		
		bst.print();
		System.out.println("\n");
		
		bst.remove(9);
		
		bst.print();
	}

}
