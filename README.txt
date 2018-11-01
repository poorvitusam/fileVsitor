Navigate to the folder of this README file:

Perform Below commands to compile/run/clean the program:


## To clean:
ant -buildfile fileVisitors/src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile fileVisitors/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile fileVisitors/src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=Debug Level

-----------------------------------------------------------------------


To store results and threads: arraylist- O(n)

Used Binary Search Tree for storing words: 
Complexity::
search - worst case = O(n) & best case = O(logn) where n is the number of nodes
insert - worst case = O(n) & best case = O(logn) where n is the number of nodes


-----------------------------------------------------------------------

MyLogger Updates:

Log Level 0 - RELEASE
Log Level 1 - DEBUG - Prints the output (Statistics)
Log Level 2 - PALINDROME - Prints all the words detected as Palindrome and updated to uppercase
Log Level 3 - PRIME -  Prints all the words with length as prime number and updated with siffix "-PRIME"
Log Level 4 - CONSTRUCTOR - Every time a constructor is called

-----------------------------------------------------------------------
