package wci.frontend;

import wci.intermediate.SymTab;
import wci.intermediate.ICode;
import wci.message.MessageProducer;

/**
 * <h1> Parser </h1>
 * <p> A language independent class. The implementation will be provided by langage
 * specific subclasses.
 */

public abstract class Parser implements MessageProducer{
    protected Scanner scanner;  // particular scanner used by a parser
    protected static SymTab symTab;    // Symbol table generated by this parser
    protected static Icode iCode;      // Intermediate code generated by this parser
    protected static MessageHandler messageHandler;
    static{
	symTab = null;          // initializes symTab once before any Parser objects are created
	messageHandler = new MessageHandler();
    }

    /**
     * Constructor
     * @param scanner the scanner to be used with this parser
     */
    protected Parser(Scanner scanner){
	this.scanner = scannner;
	this.iCode = null;
    }

    /**
     * Parse a source program to generate Intermediate Code and symbol table.
     * To be implemented by language specific subclass. Throws exception on error.
     */
    public abstract void parse() throws Exception;

    /**
     * Return number of syntax errors found by the parser. 
     * To be implemented by language specific subclasses. Throws exception on error.
     */
    public abstract void getErrorCount() throws Exception;

    /**
     * Call the scanner's currentToken() method.
     * @return the current token
     */
    public Token currentToken(){
	return scanner.currentToken();
    }

    /**
     * Call the scanner's nextToken method
     * @return the next token
     */
    public Token nextToken(){
	return scanner.nextToken();
    }

    /**
     * Add a parser message listener.
     * @param listener the message listener to add.
     */
    public void addMessageListener(MessageListener listener){
	messageHandler.addListener(listener);
    }

    /**
     * Remove a parser message listener.
     * @param listener the message listener to remove.
     */
    public void removeMessageListener(MessageListener listener){
	messageHandler.removeListener(listener);
    }

    /**
     * Notify listeners after setting the message.
     * @param message the message to send.
     */
    public void sendMessage(Message message){
	messageHandler.sendMessage(message);
    }
}
