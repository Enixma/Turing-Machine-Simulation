import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// JTextFieldLimit class
public class JTextFieldLimit extends PlainDocument {
	
	// attribute
	private int limit;
	
	// constructor 
	JTextFieldLimit(int limit) {
		super();
	    this.limit = limit;
	}
	
	// constructor
	JTextFieldLimit(int limit, boolean upper) {
		super();
	    this.limit = limit;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;
	
	    if ((getLength() + str.length()) <= limit) {
	    	super.insertString(offset, str, attr);
	    }
	}
}
