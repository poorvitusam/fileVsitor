package fileVisitors.visitor;

import fileVisitors.tree.Node;
import fileVisitors.tree.Tree;

public class PalindromeHighlight implements VisitorI {

	public void visit(Tree tree) {
		
		processTree(tree.getRootNode());

	}
	
	private void processTree(Node node) {
		
		if(node == null) return;
		
		processTree(node.getLeftNode());
		
		if(node.getWord().length() > 3 && isPalindrome(node.getWord())) {
			String word = node.getWord().toUpperCase();
			node.setWord(word);
			
		}
		
		processTree(node.getRightNode());
		
	}


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
