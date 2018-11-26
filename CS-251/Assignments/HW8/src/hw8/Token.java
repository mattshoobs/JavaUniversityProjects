
package hw8;
//TODO
//Import all necessary libraries.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Token {

	private String token;
	private Map<Document, List<Integer>> positionalIndex;
	
	public Token(String str) {
		//TODO
		//Declare all instance variables
		//Set the variables.
		this.token = str;
		positionalIndex = new HashMap<Document, List<Integer>>();
		
	}
	
	/**
	 * Get the positions of the Token for the document passed in.
	 * If the Token has no positions in the document, meaning there is no Map from the doc to the list, return null.
	 * 
	 * @param doc
	 * @return list of integers or null
	 */
	public List<Integer> getPositions(Document doc){
		
		//TODO - getPositions
		
		return positionalIndex.get(doc);
		
	}

	/**
	 * Sets the position of the Token in the document passed in.
	 * If doc already occurs in the postionalIndex, it means the token has already appeared in the document.
	 * If doc doesn't exist in positionalIndex, it means this is the first time the token appeared in the document.
	 * How can you check for this?
	 * After checking, what should be done for either case to make sure the list of integers is correct?
	 * 
	 * @param doc
	 * @param p
	 */
	public void setPositions(Document doc, Integer p) {
		
		//TODO - setPostions
		if (positionalIndex.containsKey(doc) && !(positionalIndex.get(doc).contains(p))) {
			positionalIndex.get(doc).add(p);
		}
		else if(!(positionalIndex.containsKey(doc))) {
			List<Integer> tempList = new ArrayList<Integer>();
			tempList.add(p);
			
			positionalIndex.put(doc, tempList);
		}
	}

	@Override
	public String toString() {
		//TODO - toString
		//toString only returns the String instance variable.
		return token;
	}
	
	@Override
	public boolean equals(Object o) {
		//TODO - equals method
		//equals only checks if the passed in Object is a Token and the String variables match.
		
		if (o instanceof Token) {
			if (((Token) o).toString().equals(this.token)) {
				return true;
			}
		}
		return false;
	}

}
