package wci.frontend;

/**
 * <h1> Scanner </h1>
 * <p> A language-independent framework class. This abstract scanner class will be implemented 
 * by language specific sub-classes. </p>
 */

public abstract class Scanner{
    private Source source;   // source
    private Token currentToken;   // current token

    /**
     * Constructor
     * @param source the source to be used with this scanner.
     */
    public Scanner(Source source){
	this.source = source;
    }

    /**
     * Returns the current token.
     * @return the current token.
     */
    public Token currentToken(){
	return currentToken;
    }

    /**
     * Return the next token from the source.
     * @return the next token from the source.
     * @throws Exception if error occurred.
     */
    public Token nextToken() throws Exception{
	currentToken = extractToken();
	return currentToken;
    }

    /**
     * Do the actual work of extracting and returning the next token from the 
     * source. Implemented by scanner subclass.
     * @return the next token
     * @throws Exception if error occurred.
     */
    public abstract Token extractToken() throws Exception;

    /**
     * Call the source's currentChar() method.
     * @return the current char from the source.
     * @throws Exception if an error occurred.
     */
    public char currentChar(){
	return source.currentChar();
    }

    /**
     * Call the source's nextChar() method.
     * @return the next char from the source.
     * @throws Exception if an error occurred.
     */
    public char nextChar() throws Exception{
	return source.nextChar();
    }
}

