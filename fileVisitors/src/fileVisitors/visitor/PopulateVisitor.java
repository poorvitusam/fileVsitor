package fileVisitors.visitor;

import fileVisitors.tree.Tree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.util.MyLogger.DebugLevel;

/**
 * Visitor class to construct a Binary Search Tree from a Text File
 * @author suresh
 *
 */
public class PopulateVisitor implements VisitorI{
	FileProcessor fileProcessor;
	
	public PopulateVisitor(FileProcessor fp) {
		fileProcessor = fp;
		MyLogger.writeMessage( this.getClass().getSimpleName()+ " Constructor is called", DebugLevel.CONSTRUCTOR);
	}
	
	public void visit(Tree tree) {
		String line = "";
		while((line = fileProcessor.readLine()) != null ) {
			line = line.trim();

			if(line.length() == 0) continue;

			String[] words = line.split(" ");

			for(String word : words) {
				tree.addWord(word.trim());
			}
		}
	}
}
