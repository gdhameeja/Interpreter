package com.wci.frontend;

/**
 * <h1> Token </h1>
 * <p> The framework class that represetns a token returned by scanner. </p>
 */

public class Token{
    protected TokenType type;   // language-specific token type
    protected Source source;    // source 
    protected int lineNum;      // line number of where the token is found in source.
    protected Object value;     // value of the token
    protected String text;      // text of the token
    protected int position;     // position of the first token character

    /**
     * Constructor.
     * @param source the source from where to fetch token's characters.
     * @throws throws Exception if error occurred.
     */
    public Token(Source source) throws Exception{
        this.source = source;
        this.lineNum = source.getLineNum();
        this.position = source.getCurrentPos();

        extract();
    }

    /**
     * Default method to extract only one-character tokens from the source.
     * Subclasses can override this method to construct lanugage-specific tokens.
     * After extracting the token the current, the current source line will be one 
     * beyond the last token character.
     * @throws Exception if error occurred.
     */
    public void extract() throws Exception{
        text = Character.toString(currentChar());
        value = null;

        nextChar();   // consume the current character.
    }

    /**
     * Call the Source's currentChar method.
     * @return the current character from the source.
     * @throws Exception if erroc occurred. 
     */
    protected char currentChar() throws Exception{
        return source.currentChar();
    }

    /**
     * Call the Source's nextChar() method.
     * @return the next character from the source after moving forward.
     * @throws Exception if error occurred.
     */
    protected char nextChar() throws Exception{
        return source.nextChar();
    }

    /**
     * Call the Source's peekChar() method.
     * @return the next character from the source without moving forward.
     * @throws Exception if an error occurred.
     */
    protected char peekChar() throws Exception{
        return source.peekChar();
    }

    public TokenType getType() {
        return type;
    }

    public Source getSource() {
        return source;
    }

    public int getLineNum() {
        return lineNum;
    }

    public Object getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public int getPosition() {
        return position;
    }
}
