package com.bridgeLabs.binarySearchTreeProgram;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void givenThreeNumbersWhenAddedToBInaryTreeShouldHaveSizeThree() {
		BinarySearchTree<Integer> myTree=new BinarySearchTree<Integer>();
		Integer a=56, b=30, c=70;
		myTree.add(a);
		myTree.add(b);
		myTree.add(c);
		int size=myTree.getSize();
		Assert.assertEquals(3, size);
	}
}
