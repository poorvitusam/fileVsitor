package fileVisitors.visitor;

import fileVisitors.tree.Tree;

/**
 * Visitor interface to be inherited by all concrete visitor classes who wants to process the
 * tree .
 * @author suresh
 *
 */
public interface VisitorI {
	
	/**
	 * A method which needs to be overridden by all concrete visitor class in order to
	 * perform operations on Tree according their needs.
	 * @param tree
	 */
	public void visit(Tree tree);
}
