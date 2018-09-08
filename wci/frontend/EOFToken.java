package wci.frontend;

/**
 * <h1> EOFToken </h1>
 * <p> The generic end-of-file token </p>
 */

public class EOFToken extends Token{

    /**
     * Constructor
     * @param source the source where to fetch subsequent characters from.
     * @throws Exception if an error occurred.
     */
    public EOFToken() throws Exception{
	super(source);
    }

    /**
     * Do nothing. Do not consume any souce characters.
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if error occurred.
     */
    public Token extract(Source source) throws Exception{
	
    }
}
