package fileVisitors.visitor;

import fileVisitors.store.Results;
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
		tree.printNodes(result);
	}
}
