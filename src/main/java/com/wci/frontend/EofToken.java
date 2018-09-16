package com.wci.frontend;

/**
 * <h1> EofToken </h1>
 * <p> The generic end-of-file token </p>
 */
import com.wci.frontend.*;

public class EofToken extends Token{

    /**
     * Constructor
     * @param source the source where to fetch subsequent characters from.
     * @throws Exception if an error occurred.
     */
    public EofToken(Source source) throws Exception{
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
