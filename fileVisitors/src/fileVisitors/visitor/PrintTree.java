package fileVisitors.visitor;

import fileVisitors.store.Results;
import fileVisitors.tree.Node;
import fileVisitors.tree.Tree;

/**
 * Visitor class that traverse the tree and prints the node in output file.
 * @author suresh
 *
 */
public class PrintTree implements VisitorI{
	Results result; 
	
	public PrintTree(Results results) {
		result = results;
	}
	
	public void visit(Tree tree) {
		printInAscendingOrder(tree.getRootNode(), result);
		result.writeToFile();
	}
	
	
	
	/**
	 * Traverse tree in In Order form and store result in Results object
	 * @param node
	 * @param result
	 */
	private void printInAscendingOrder(Node node, Results result) {
		if(node == null) return;
		
		printInAscendingOrder(node.getLeftNode(), result);
		
		result.storeNewResult(node.getWord());
		
		printInAscendingOrder(node.getRightNode(), result);
	}
}
