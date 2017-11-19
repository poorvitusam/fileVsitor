package fileVisitors.tree;

import fileVisitors.util.MyLogger;
import fileVisitors.util.MyLogger.DebugLevel;
import fileVisitors.visitor.VisitorI;

/**
 * Helper class that holds and create a Binary Search Tree for given words and count
 * @author suresh
 *
 */
public class Tree {
	
	Node rootNode; 
	
	public Tree() {
		MyLogger.writeMessage( this.getClass().getSimpleName()+ " Constructor is called", DebugLevel.CONSTRUCTOR);
	}
	
	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public Node getRootNode() {
		return rootNode;
	}
	
	/**
	 * Open to any type of Visitor who wants to perform any operations on the current instance of tree.
	 * @param visitor
	 */
	public void accept(VisitorI visitor) {
		visitor.visit(this);
	}
	
	/**
	 * Add new node to tree
	 * @param node
	 */
	public synchronized void addWord(String word) {
		if(word == null || word.length() == 0) return;
		
		if(rootNode == null) {
			rootNode = new Node(word);
			rootNode.occurrence = 1;
			return;
		}
		
		traverseAndAdd(rootNode, word);
	}
	
	/**
	 * Traverse through the tree and find the appropriate place for new node to store.
	 * @param root
	 * @param nodeToAdd
	 * @return node
	 */
	private Node traverseAndAdd(Node root, String wordToAdd) {
		
		if(root == null) {
			root = new Node(wordToAdd);
			root.occurrence = 1;
			return root;
		}
		
		if(wordToAdd.compareTo(root.getWord()) > 0) {
			root.setRightNode(traverseAndAdd(root.getRightNode(), wordToAdd));
		} else if(wordToAdd.compareTo(root.getWord()) < 0) {
			root.setLeftNode(traverseAndAdd(root.getLeftNode(), wordToAdd));
		} else {
			root.incrementWordCount();
		}
		
		return root;
	}
	
}

