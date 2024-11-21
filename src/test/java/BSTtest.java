import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

class BSTtest 
{

	@BeforeEach

	
	
	@Test
	void test() 
	{
		int [] A = {50,72,96,94,107,26,12,11,9,10,25,51,16,17,95};
		int [] B = {50,72,96,94,107,26,12,11,9,10,25,51,16,17,95,450};
		int [] C = {9,10,11,12,16,17,25,26,50,51,72,94,95,96,107};
		BSTree BST1 = new BSTree();
		BSTree BSTE = new BSTree();
		BSTree BST3 = new BSTree();
		BSTree BST4 = new BSTree();
		BSTree BST5 = new BSTree();
		BSTree tree = new BSTree();
		BSTree tree2 = new BSTree();
	
		for(int i = 0; i < A.length; i++) 
		{
			tree.insert(A[i]);
		}
		
		for(int i = 0; i < B.length; i++) 
		{
			tree2.insert(B[i]);
		}
		
		BST4.insert(12);
		assertEquals(0,BST1.getSize());
		assertTrue(BST1.isEmpty());
		BST1.insert(50);
		assertFalse(BST1.isEmpty());
		assertEquals(50,BST1.retrieve(50));
		assertNull(BST1.retrieve(49));
		assertEquals(1, BST1.getSize());
		BST1.insert(35);
		BST1.insert(69);
		BST1.insert(21);
		BST1.insert(15);
		BST1.insert(51);
		BST1.insert(36);
	
		assertEquals(3, BST1.retrieveDepth(15));
		assertEquals(2, BST1.retrieveDepth(70));
	
		assertEquals(7,BST1.getSize());
		assertEquals(69, BST1.largest());
		assertEquals(null, BST3.largest());
		assertEquals(450, tree2.largest());
		assertEquals(12,BST4.largest());
		assertEquals(277,BST1.sum());
		BSTE.insert(50);
		BSTE.insert(35);
		BSTE.insert(69);
		BSTE.insert(21);
		BSTE.insert(15);
		BSTE.insert(51);
		BSTE.insert(36);
	
		assertTrue(compList(BST1,BSTE));
		assertFalse(compList(BST1,BST4));
		assertTrue(compList(BST1,BST1));
		assertTrue(compList(BST3,BST5));
		assertFalse(compList(BST4, BST5));
	
		assertTrue(BSTE.myEquals(BST1)); //Test true, false, empty empty (true),( empty full, full empty ) false
		assertFalse(BST4.myEquals(BST1));
		assertTrue(BST3.myEquals(BST5)); // empty empty (true)
		assertFalse(BST4.myEquals(BST5));  // full empty (false)
		assertFalse(BST5.myEquals(BST4));  //empty full (false)
		treeEquals(BST1,A,false);
		
		int [] B10 = {50, 72, 96, 94, 107, 26,12,11,9,25,51,16,17,95};
		int [] C18A = {50,72,96,94,107,26,12,11,9,10,25,51,16,17,95,18};
		int [] D51 = {50,72,96,94,107,26,12,11,9,10,25,16,17,95};
		int [] E51A = {50,72,96,94,107,26,12,11,9,10,25,51,16,17,95,51};
		
		List<Integer> AB = new ArrayList<Integer>();
	
		for(int i = 0; i < C.length; i++) 
		{
			AB.add(C[i]);
		}
	
		assertEquals(AB,tree.toList());
		treeEquals(tree,B10,false);
		treeEquals(tree,C18A,false);
		treeEquals(tree,D51,false);
		treeEquals(tree,E51A,false);
	
	}

	public boolean compList(BSTree BST1, BSTree BST2) 
	{
		boolean samelist = true;
		if (BST1.isEmpty() == true && BST2.isEmpty() == true) 
		{
			return samelist;
		}
		List<Integer> compList = BST1.toList();
		List<Integer> compList2 = BST2.toList();
		samelist = compList.equals(compList2);
		return samelist;
	}

	public void treeEquals(BSTree BST1, int [] A, boolean truth) 
	{
		BSTree BSTfresh = new BSTree();
		for(int i = 0; i < A.length; i++) 
		{
			BSTfresh.insert(A[i]);
		}
		assertEquals(truth,BST1.myEquals(BSTfresh));
		return;
	}

}