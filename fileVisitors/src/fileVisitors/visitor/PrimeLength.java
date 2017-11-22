package fileVisitors.visitor;

import fileVisitors.tree.Node;
import fileVisitors.tree.Tree;
import fileVisitors.util.MyLogger;
import fileVisitors.util.MyLogger.DebugLevel;
import fileVisitors.util.StringHelper;

/**
 *Visitor class that check for all the words in a Tree and append -PRIME keyword if the word
 *length is a prime number 
 * @author suresh
 */
public class PrimeLength implements VisitorI {
	
	public PrimeLength() {
		MyLogger.writeMessage( this.getClass().getSimpleName()+ " Constructor is called", DebugLevel.CONSTRUCTOR);
	}

	
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

		if(StringHelper.isPrimeLength(node.getWord())) {
			String word = node.getWord() + "-PRIME";
			node.setWord(word);
			
			MyLogger.writeMessage(node.getWord() + " Word length is prime so updated to " + word, DebugLevel.PRIME);

		}

		processTree(node.getRightNode());

	}





}
