package fileVisitors.visitor;

import fileVisitors.tree.Node;
import fileVisitors.tree.Tree;

public class PrimeLength implements VisitorI{

	public void visit(Tree tree) {
		processTree(tree.getRootNode());
	}

	private void processTree(Node node) {

		if(node == null) return;

		processTree(node.getLeftNode());

		if(isPrimeLength(node.getWord())) {
			String word = node.getWord() + "-PRIME";
			node.setWord(word);

		}

		processTree(node.getRightNode());

	}

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
