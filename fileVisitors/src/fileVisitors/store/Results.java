package fileVisitors.store;

import java.util.ArrayList;
import java.util.List;

import fileVisitors.util.FileDisplayInterface;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.FileProcessor.Permission;
import fileVisitors.util.MyLogger;
import fileVisitors.util.MyLogger.DebugLevel;
import fileVisitors.util.StdoutDisplayInterface;

/**
 * Class to store all results in string format and process those results to write in
 * a file or print on console
 * @author suresh
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	List<String> testResults = new ArrayList<String>();;
	String outputFilePath;

	public Results(String outputFilePath) {
		MyLogger.writeMessage("Results Parameterized Constructor is called", DebugLevel.CONSTRUCTOR);
		this.outputFilePath = outputFilePath;
	}


	/**
	 * Store new result
	 * @param resultString
	 */
	public void storeNewResult(String resultString) {
		MyLogger.writeMessage(resultString, DebugLevel.DEBUG);
		testResults.add(resultString);
	}

	
	
	@Override
	public void writeToFile() {
		FileProcessor fileProcessor = new FileProcessor(outputFilePath, Permission.WRITE, true);
		fileProcessor.writeLines(testResults);
		fileProcessor.closeFile();
		
		MyLogger.writeMessage("Result is generated at path = " + fileProcessor.getFilePath(), DebugLevel.VERBOSE);
	}



	@Override
	public void writeToStdout() {
		for (String line : testResults) {
			System.out.println(line);
		}
	}


}

