package hw8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO
//Import all necessary libraries.

public class Indexer {

	/**TODO
	 * Create the four instance variables needed for this class
	 * var1)	reversedIndex 	-is a Map that maps a Token to a List of Documents
	 * var2)	allTokens 		-is a Map that maps a String to a Token
	 * 								-use this to determine no duplicate Tokens are created
	 * var3)	allDocs			-is a Map that maps a string to a Document
	 * 								-use this to determine no duplicate Documents are created
	 * var4)	allDocsSorted	-A List that holds all Documents that are sorted by DocID
	 * 								-If done correctly, Documents added to this variable be inserted in sorted order
	 * var5)	assignID		-A int to assign docIDs
	 * 								-Should increment with each new document created
	 * 								-First document added will always get ID of 1
	 */
	private Map<Token, List<Document>> reversedIndex;
	
	private Map<String, Token> allTokens;
	
	private Map<String, Document> allDocs;
	
	private List<Document> allDocsSorted;
	
	private int assignID;
	
	
	
	public Indexer() {
		//TODO
		//Declare all instance variables
		//What should each variable be initialized to?
		reversedIndex = new HashMap<Token, List<Document>>();
		allTokens = new HashMap<String, Token>();
		allDocs = new HashMap<String, Document>();
		allDocsSorted = new ArrayList<Document>();
		assignID = 1;
		
	}
	
	
	/**
	 * A method used to add a String document to the Reversed Index.
	 * You must	1) Parse out the document name.  This will always appear at the front of a
	 * 			   document and be surrounded by "<" ">" symbols
	 * 			2) Use the Map allDocs to make sure the document name(a String) currently being checked has not been added already.
	 * 			   If it has been seen, do nothing
	 * 			   If it hasn't been added, update allDocs and proceed to the next steps.
	 * 			3) Parse out the file contents.  The contents of the file will always appear after the document name.
	 * 			4) Break the file contents into individual tokens.
	 * 			5) Loop over all tokens contained in file contents.
	 * 				Think of how you can use removePunctuation, checkToken, and checkToken_Document methods.
	 * 				Calling these methods in a certain order and using their return types can give you a Token and
	 * 					a List of Documents to update the reversedIndex.
	 * 				Don't forget to update the positionalIndex too!  When should this happen?
	 * 
	 * @param docString
	 */
	public void indexDocument(String docString) {
		//TODO - indexDocument
		String name;
		if (!docString.contains("<") && !docString.contains(">")) {
			return;
		}
		name = docString.substring(docString.indexOf("<")+1, docString.indexOf(">"));
		
		if (allDocs.containsKey(name)) {
			return;
		}
		Document tempDoc = new Document (assignID, name);
		assignID++;
		allDocs.put(name, tempDoc);
		allDocsSorted.add(tempDoc);
	
		String contents = docString.substring(docString.indexOf(">")+1).trim();
		
		String[] tokens = contents.split(" ");
		
		for (int i = 0; i<tokens.length;i++) {
			tokens[i] = removePunctuation(tokens[i]);
			Token tempToken = checkToken(tokens[i]);
			checkToken_Document(tempToken, tempDoc);
			tempToken.setPositions(tempDoc, i+1);
		}
		
		
		
		
	}

	
	/**
	 * Remove all punctuation and convert String to lower case.
	 * Only a single term, or word, should be passed to this method at a time.
	 * Punctuation to remove: "," "." "!" "?"
	 * 
	 * @param str
	 * @return a formatted String
	 */
	protected String removePunctuation(String str) {
		//TODO - removePunctuation
		return str.trim().toLowerCase().replace("!","").replace("?","").replace(".","").replace(",","");
		
	}
	
	/**
	 * Use allTokens to see if the String passed in currently is a token.
	 * If it is there, what should it return?
	 * If it isn't, what set of operations should happen?
	 * This method should never return null, meaning a Token object is always returned.
	 * 
	 * @param str
	 * @return Token
	 */
	protected Token checkToken(String str) {

		//TODO - checkToken
		if (!allTokens.containsKey(str)) {
			Token tempToken = new Token(str);
			allTokens.put(str, tempToken);
			return tempToken;
		}
		return allTokens.get(str);
	}
	
	/**
	 * Use reversedIndex to see if the Token is part of the reversedIndex.
	 * Remember, the reversedIndex maps a Token to a List of Documents.
	 * If the token is there, what should the Token be mapped to?
	 * If the Token isn't there, is the Token mapped to anything?  What should happen if it isn't mapped to anything?
	 * If the List of Documents mapped to by the Token does not contain the Document passed in, add it to the list.
	 * We need to make sure no duplicate docs are added to the List of Documents.
	 * This method should never return null, it should always return a List of Documents pointed to by the Token passed in.
	 * 
	 * @param token
	 * @param doc
	 * @return a List of Documents with the passed in Document possibly added to the List.
	 */
	protected List<Document> checkToken_Document(Token token, Document doc){
		//TODO - checkToken
		List<Document> tempList = new ArrayList<Document>(); 
		if (!reversedIndex.containsKey(token)) {
			tempList.add(doc);
			reversedIndex.put(token, tempList);
		
		}
		else {
			tempList = reversedIndex.get(token);
			if (!tempList.contains(doc)) {
				tempList.add(doc);
			}
		}
		return tempList;
	}
	
	
	/**
	 * Use the reversedIndex to answer the query and print out the list of documents that contain the term.
	 * If the query is not in the reversedIndex, Simply print out the query was not found.
	 * If the query is there:
	 * 		1)	Print out the token name and the list of documents containing the query.
	 * 			You may use the built in toString method for Lists to print them out.
	 * 		2)	For each document the query appears in ,print out each docID followed by the query location(s) for each document.
	 * See the driver output in the homework description for example output.
	 * 
	 * @param query
	 */
	public void singleQuery(String query) {
		//TODO - singleQuery
		System.out.println("\nSingle Query: " + query);
		if (!allTokens.containsKey(query)) {
			System.out.println("Query not found!");
			return;
		}
		Token tempToken = allTokens.get(query);
		System.out.println("Documents containing \"" + query + "\": " + reversedIndex.get(tempToken));
		for ( int i = 0; i<reversedIndex.get(tempToken).size(); i++) {
			Document tempDoc = reversedIndex.get(tempToken).get(i);
			System.out.println("Doc ID: " + tempDoc.getID() + ", DocPositions: " + tempToken.getPositions(tempDoc) + "\n");
		}
			
	}
	
	/**
	 * Graduate students must complete.
	 * Undergraduates may feel free to attempt this if they wish.
	 * Write the code to perform a two word query.
	 * This should print out a result if both words in the query occur next to each other.
	 * 
	 * @param query
	 */
	public void twoWordQuery(String[] query) {
		
		//TODO - twoWordQuery
		//Remove the print statement when you try to complete this method.
		System.out.println("Two word queries method not implemented yet.");
		
		
	}
		
	/**
	 * A simple method that prints out all Documents that have been seen.
	 * Use the list containing allDocsSorted to print them out.
	 * 
	 */
	public void printOutAllDocs() {
		
		//TODO - printOutAllDocs
		for ( int i = 0; i<allDocsSorted.size(); i++) {
			Document tempDoc = allDocsSorted.get(i);
			System.out.println("Doc ID: " + tempDoc.getID() + ", DocName: " + tempDoc.getName());
		}
	
	}
	
}
