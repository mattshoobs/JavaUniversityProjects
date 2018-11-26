package hw8;


public class Document {

	private int docID;
	private String docName;
	
	
	public Document(int docID, String docName) {
		this.docID = docID;
		this.docName = docName;
	}
	
	public String getName() {
		return this.docName;
	}
	
	public int getID() {
		return this.docID;
	}
	
	public String toString() {
		return "DocID: " + this.docID + " ";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Document) {
			if (((Document) o).getID() == this.docID && ((Document) o).getName().equals(this.docName)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	
	
	
}
