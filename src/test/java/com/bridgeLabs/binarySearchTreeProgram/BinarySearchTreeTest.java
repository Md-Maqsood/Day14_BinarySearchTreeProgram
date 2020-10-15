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
	
	@Test
	public void givenMultipleNumbersWhenAddedToBInaryTreeShouldHaveSizeEqualToNumberOfNumbers() {
		BinarySearchTree<Integer> myTree=new BinarySearchTree<Integer>();
		Integer[] keyArray=new Integer[] {56,30,70,22,40,60,95,11,65,3,63,67};
		myTree.addMultipleValues(keyArray);
		int size=myTree.getSize();
		Assert.assertEquals(keyArray.length, size);
	}
}
