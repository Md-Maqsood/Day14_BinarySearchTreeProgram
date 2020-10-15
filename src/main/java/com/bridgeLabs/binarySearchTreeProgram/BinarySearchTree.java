package com.bridgeLabs.binarySearchTreeProgram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearchTree<K extends Comparable<K>> {
	private static final Logger logger = LogManager.getLogger(BinarySearchTree.class);
	private BinaryNode<K> root;
	public BinarySearchTree() {
		this.root=null;
	}
	
	public void addMultipleValues(K[] keyArray) {
		for(K key: keyArray) {
			this.add(key);
		}
	}
	
	public void add(K key) {
		this.root=this.addRecursively(this.root,key);
	}
	
	private BinaryNode<K> addRecursively(BinaryNode<K> current,K key) {
		if(current==null) {
			return new BinaryNode<K>(key);
		}
		int comparisonResult=key.compareTo(current.key);
		if(comparisonResult==0) {
			return current;
		}else if(comparisonResult<0) {
			current.left=addRecursively(current.left, key);
		}else {
			current.right=addRecursively(current.right, key);
		}
		return current;
	}
	
	public boolean search(K key) {
		return this.searchRecursively(this.root,key);
	}
	
	private boolean searchRecursively(BinaryNode<K> current, K key) {
		if(current==null) {
			return false;
		}else if(current.key==key) {
			return true;
		}else if(key.compareTo(current.key)<0) {
			return searchRecursively(current.left, key);
		}else {
			return searchRecursively(current.right, key);
		}
	}
	
	public int getSize() {
		return this.getSizeRecursively(this.root);
	}
	
	private int getSizeRecursively(BinaryNode<K> current) {
		return (current==null)?0:1+getSizeRecursively(current.left)+getSizeRecursively(current.right);
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> myTree=new BinarySearchTree<Integer>();
		Integer[] keyArray=new Integer[] {56,30,70,22,40,60,95,11,65,3,63,67};
		myTree.addMultipleValues(keyArray);
		logger.debug("Binary tree of size "+myTree.getSize()+" created.");
		Integer searchNumber=63;
		logger.debug("\nElement 63 "+(myTree.search(searchNumber)?"is in the tree":"is not in the tree"));
	}
}

class BinaryNode<K extends Comparable<K>>{
	K key;
	BinaryNode<K> left;
	BinaryNode<K> right;
	
	public BinaryNode(K key) {
		this.key=key;
		this.left=null;
		this.right=null;
	}
}