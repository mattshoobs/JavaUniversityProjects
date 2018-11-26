package lab11;

public class FileParser {
	private String inLine;
	
	public FileParser (String inLine) {
		this.inLine = inLine;
		
	}

	public String parse() {
		
		String[] tmp = inLine.split(":");
		
		String line = tmp[0];
		
		int index1 = Integer.parseInt(tmp[1]);
		int index2 = Integer.parseInt(tmp[2]);
		
		if (index1 > index2) {
			return "i > j, invalid indicies.";
		}
		else if (index1 > line.length() || index2 > line.length()) {
			return "i or j are larger than string length";
		}
		line = line.substring(index1, index2);
		return line;
		
	}
	
	
	
}
