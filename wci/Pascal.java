import java.io.BufferedReader;
import java.io.FileReader;

import wci.frontend.*;
import wci.intermediate.*;
import wci.backend.*;
import wci.backend.message.*;

import static wci.message.MessageType.*;

/**
 * <h1> Pascal </h1>
 * <p> Compile or interpret a Pascal source program. </p>
 */

public class Pascal{
    private Parser parser;    // language-independent parser.
    private Source source;    // language-independent scanner.
    private ICode iCode;      // generated intermediate code.
    private SymTab symTab;    // generated symbol table.
    private Backend backend;  // backend.

    /**
     * Compile or interpret a Pascal source program.
     * @param operation either "compile" or "execute".
     * @param filepath source filepath.
     * @param flags the command line flags. 
     */
    public Pascal(String operation, String filepath, String flags){
	try{
	    boolean intermediate = flags.indexOf('i') > -1;
	    boolean xref         = flags.indexOf('x') > -1;

	    source = new Source(new BufferedReader(new FileReader(filepath)));
	    source.addMessageListener(new SourceMessageListener());

	    parser = FrontendFactory.createParser("Pascal", "top-down", source);
	    parser.addMessageListener(new ParserMessageListener());

	    parser.parser();
	    source.close();

	    iCode = parser.getICode();
	    symTab = parser.getSymTab();

	    backend.process(iCode, symTab);
	}
	catch(Exception ex){
	    System.out.println("*** Internal translator error . ***");
	    ex.printStackTrace();
	}
	
    }

    
}
