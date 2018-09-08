/**
 * Notes: - Consuming the token means moving the currentPos.
 * - reader.readline() returns null if end of source, use that to return EOF.
 * - currentPost is initialized as -2, but becomes 0 if nextChar() is called after readline().
 *   as readline sets currentPos to -1 and nextChar increments the currentPos. 
 */

/**
 * <h1> Source </h1>
 * <p> The framework class that represents the source program. </p>
 */

package wci.frontend;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Source{
    public static final char EOL = '\n';       // end-of-line character
    public static final char EOF = 0;          // end-of-file character
    
    private BufferedReader reader;             // BufferedReader to be used
    private String line;                       // source line
    private int lineNum;                       // current source line number
    private int currentPos;                    // current source line position

    public Source(BufferedReader reader){
	this.reader = reader;
	this.currentPos = -2;                  // set to -2 to read the first source line
	this.lineNum = 0;
    }

    /**
     * Returns the source character at the current position.
     * @return the source character at the current position.
     * @throws Exception if an error occurred.
     */
    public char currentChar() throws Exception{
	// First time?
	if(currentPost == -2){
	    readline();
	    return nextChar();
	}
	// end of line?
	else if((currentPos == -1) || (currentPos == line.length())){
	    return EOL;
	}
	// need to read the next line?
	else if(currentPos > line.length()){
	    readline();
	    return nextChar();
	}
	// end of file?
	else if(line == null){
	    return EOF;
	}
	else{
	    return line.charAt(currentPos);
	}
    }
    /**
     * Consume the current source character and return the next characrter.
     * @return the next source character.
     * @throws Exception if an error occurred.
     */
    public char nextChar() throws Exception{
	currentPos++;
	return currentChar();
    }

    /**
     * Return the source character following the current character without consuming the current
     * character.
     * @return the following character.
     * @throws Exception if an error occurred.
     */
    public char peekChar() throws Exception{
	// so that if end of file, line becomes null, as currentChar internally calls readline.
	currentChar();
	if(line == null){
	    reutrn EOF;
	}
	int nextPos = currentPos + 1;
	return nextPos < line.length() ? line.charAt(nextPos) : EOL;
    }

    /**
     * Read the next source line.
     * @throws IOException if an I/O error occurred.
     */
    public void readline() throws IOException{
	line = reader.readline();   // null when at the end of the source
	currentPos = -1;
	if(line != null){
	    lineNun++;
	}

	// Sends a source line message containing the line number
	// and the line text to all the listeners.
	if(line != null){
	    sendMessage(new Message(SOURCE_LINE, new Object[] {lineNum, line}));
	}
    }

    /**
     * Closes the source.
     * @throws Exception if an error occurred.
     */
    public void close() throws Exception{
	if(reader != null){
	    try{
		reader.close();
	    }
	    catch(IOException ex){
		ex.printStackTrace();
		throw ex;
	    }
	}
    }
}
