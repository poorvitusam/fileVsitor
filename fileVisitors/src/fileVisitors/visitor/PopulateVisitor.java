package fileVisitors.visitor;

import fileVisitors.tree.Tree;
import fileVisitors.util.FileProcessor;

public class PopulateVisitor implements VisitorI{
	FileProcessor fileProcessor;
	public PopulateVisitor(FileProcessor fp) {
		fileProcessor = fp;
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
