package fileVisitors.driver;

import fileVisitors.tree.Tree;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrintTree;
import fileVisitors.visitor.VisitorI;
import fileVisitors.store.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.FileProcessor.Permission;

public class Driver {
	public static void main(String args[]) {
		if (!validateArguments(args)) {
			System.err.println("Please provide valid number of arguments. 3 Arguments are expected: "
					+ "\n1.Input File \n2.Output File \n3.Log Level");
			System.exit(0);
		}

		String inputFile = args[0];
		String outputFile = args[1];
		
		int debugLevel = -1;

		try {
			debugLevel = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			System.err.println("Invalid Log level found in the command");
			System.exit(0);
		}
		FileProcessor inputFileProcess = new FileProcessor(inputFile, Permission.READ, false);

		Results results = new Results(outputFile);
		
		//Element
		Tree tree = new Tree();
		//visitor
		VisitorI populateVisitor = new PopulateVisitor(inputFileProcess);
		tree.accept(populateVisitor);
		
		VisitorI palindromeHighlight = new PalindromeHighlight();
		tree.accept(palindromeHighlight);
		
		VisitorI printTree = new PrintTree(results);
		tree.accept(printTree);
		
		results.writeToFile();
		inputFileProcess.closeFile();
		
	}
	
	private static boolean validateArguments(String[] args) {
		if (args == null || args.length != 3) {
			return false;
		}

		if ((args[0].trim().length() == 0 || args[0].contains("${arg0}"))
				|| (args[1].trim().length() == 0 || args[1].contains("${arg1}"))
				|| (args[2].trim().length() == 0 || args[2].contains("${arg2}"))) {
			return false;
		}

		return true;
	}
}
