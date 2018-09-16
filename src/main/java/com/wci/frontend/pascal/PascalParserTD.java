// stands for PascalParserTopDown

package com.wci.frontend.pascal;

import com.wci.frontend.*;
import com.wci.message.*;

import static com.wci.message.MessageType.PARSER_SUMMARY;

/**
 * <h1> PascalParserTD </h1>
 * <p> The top-down Pascal parser. </p>
 */

public class PascalParserTD extends Parser{

	/**
	 * Constructor.
	 * @param scanner the scanner to be used with this parser.
	 */
	public PascalParserTD(Scanner scanner){
		super(scanner);
	}

	/**
	 * Parse a pascal source program and generate the intermediate code and symbol table.
	 */
	public void parse() throws Exception{
		Token token;
		long startTime = System.currentTimeMillis();

		while(!((token = nextToken()) instanceof EofToken)){

		}

		// Send the parser summary message.
		float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
		// 1000f becuase 1 sec = 1000 millisec;so dividing by 1000f will give us time in seconds (floating point number).

		sendMessage(new Message(PARSER_SUMMARY, new Number[] {
				token.getLineNum(), getErrorCount(), elapsedTime
		}));
	}

	/**
	 * Return the number of syntax errors found by the parser.
	 * @return the error count.
	 */
	public int getErrorCount(){
		return 0;
	}
}
