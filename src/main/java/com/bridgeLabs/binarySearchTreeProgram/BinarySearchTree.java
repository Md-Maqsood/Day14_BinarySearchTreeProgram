package com.bridgeLabs.binarySearchTreeProgram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearchTree<K extends Comparable<K>> {
	private static final Logger logger = LogManager.getLogger(BinarySearchTree.class);
	private BinaryNode<K> root;
	public BinarySearchTree() {
		this.root=null;
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
	
	public int getSize() {
		return this.getSizeRecursively(this.root);
	}
	
	private int getSizeRecursively(BinaryNode<K> current) {
		return (current==null)?0:1+getSizeRecursively(current.left)+getSizeRecursively(current.right);
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> myTree=new BinarySearchTree<Integer>();
		Integer a=56, b=30, c=70;
		myTree.add(a);
		myTree.add(b);
		myTree.add(c);
		logger.debug("Binary tree of size "+myTree.getSize()+" created.");
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