package fileVisitors.driver;

import fileVisitors.store.Results;
import fileVisitors.tree.Tree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.FileProcessor.Permission;
import fileVisitors.util.MyLogger;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;
import fileVisitors.visitor.VisitorI;

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
		
		if(debugLevel < 0  || debugLevel > 4) {
			System.err.println("Invalid Log level found in the command");
			System.exit(0);
		}
		
		MyLogger.setDebugValue(debugLevel);
		
		FileProcessor inputFileProcess = new FileProcessor(inputFile, Permission.READ, true);

		Results results = new Results(outputFile);
		
		//Element
		Tree tree = new Tree();
		//visitor
		VisitorI populateVisitor = new PopulateVisitor(inputFileProcess);
		tree.accept(populateVisitor);
		
		VisitorI palindromeHighlight = new PalindromeHighlight();
		tree.accept(palindromeHighlight);
		
		VisitorI primeLength = new PrimeLength();
		tree.accept(primeLength);
		
		VisitorI printTree = new PrintTree(results);
		tree.accept(printTree);
		
		inputFileProcess.closeFile();
		
	}
	
	/**
	 * Check if the command line arguments are valid
	 * @param args
	 * @return<b>true</b> if valid else <b>false</b>
	 */
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
