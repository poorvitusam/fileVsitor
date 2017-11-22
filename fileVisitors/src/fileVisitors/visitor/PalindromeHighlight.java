package fileVisitors.visitor;

import fileVisitors.tree.Node;
import fileVisitors.tree.Tree;
import fileVisitors.util.MyLogger;
import fileVisitors.util.MyLogger.DebugLevel;
import fileVisitors.util.StringHelper;

/**
 * Visitor class that process the Tree and Highlight all the palinformic nodes by changing the words to
 * UPPERCASE 
 * @author suresh
 *
 */
public class PalindromeHighlight implements VisitorI {
	
	public PalindromeHighlight() {
		MyLogger.writeMessage( this.getClass().getSimpleName()+ " Constructor is called", DebugLevel.CONSTRUCTOR);
	}

	public void visit(Tree tree) {
		processTree(tree.getRootNode());
	}
	
	/**
	 * Traverse the tree and check if the length of word is greater then 3 and also if the word
	 * is palindrome, then Highlight it by changing word to upper case.
	 * @param node
	 */
	private void processTree(Node node) {
		
		if(node == null) return;
		
		processTree(node.getLeftNode());
		
		if(node.getWord().length() > 3 && StringHelper.isPalindrome(node.getWord())) {
			String word = node.getWord().toUpperCase();
			node.setWord(word);
			MyLogger.writeMessage(node.getWord() + " Word is a palindromic string so updated to " + word, DebugLevel.PALINDROME);
		}
		
		processTree(node.getRightNode());
		
	}



}
