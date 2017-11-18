package fileVisitors.visitor;

import fileVisitors.tree.Node;
import fileVisitors.tree.Tree;

/**
 * Visitor class that process the Tree and Highlight all the palinformic nodes by changing the words to
 * UPPERCASE 
 * @author suresh
 *
 */
public class PalindromeHighlight implements VisitorI {

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
		
		if(node.getWord().length() > 3 && isPalindrome(node.getWord())) {
			String word = node.getWord().toUpperCase();
			node.setWord(word);
			
		}
		
		processTree(node.getRightNode());
		
	}


	/**
	 * Check if the word is a Palindrome
	 * @param str
	 * @return <b>true</b> if word is palindrome else  <b>false</b>
 	 */
	private  boolean isPalindrome(String str) {
		int j = str.length() - 1;
		int i = 0;

		while(j > i) {
			char charAti = str.toLowerCase().charAt(i);
			char charAtj = str.toLowerCase().charAt(j);

			if(charAti != charAtj) {
				return false;
			}

			i += 1;
			j -= 1;

		}
		return true;

	}

}
