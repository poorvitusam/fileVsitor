package fileVisitors.visitor;

import fileVisitors.tree.Node;
import fileVisitors.tree.Tree;

/**
 *Visitor class that check for all the words in a Tree and append -PRIME keyword if the word
 *length is a prime number 
 * @author suresh
 */
public class PrimeLength implements VisitorI{

	
	@Override
	public void visit(Tree tree) {
		processTree(tree.getRootNode());
		
	}

	/**
	 * Traverse the tree and check if the Node contains a word with prime length. If
	 * the length is prime then append "-PRIME" keyword
	 * @param node
	 */
	private void processTree(Node node) {

		if(node == null) return;

		processTree(node.getLeftNode());

		if(isPrimeLength(node.getWord())) {
			String word = node.getWord() + "-PRIME";
			node.setWord(word);

		}

		processTree(node.getRightNode());

	}

	/**
	 * Check if string is of prime length
	 * @param str
	 * @return <b>true</b> if prime length string else <b>false</b>
	 */
	private boolean isPrimeLength(String str) {

		int length = str.length();

		if(length <= 1) return false;

		for (int i = 2; i < length; i++) {
			if (length % i == 0) {
				return false;
			}
		}

		return true;

	}





}
