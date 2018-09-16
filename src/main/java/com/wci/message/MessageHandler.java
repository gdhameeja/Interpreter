package com.wci.message;

import java.util.ArrayList;
import com.wci.message.*;
import com.wci.message.Message;
/**
 * <h1> MessageHandler </h1>
 * <p> A helper class to which message producer classes delegate the task of 
 * maintaining and notifying listeners. </p>
 */



public class MessageHandler{
    private Message message;      // message
    private ArrayList<MessageListener> listeners;   // listener list

    /**
     * Constructor.
     */
    public MessageHandler(){
	this.listeners = new ArrayList<MessageListener>();
    }

    /**
     * Add a listener to the listener list.
     * @param listener the listener to add to the list.
     */
    public void addListener(MessageListener listener){
	listeners.add(listener);
    }

    /**
     * Remove a listener from the listener list.
     * @param listener the listener to remove. 
     */
    public void removeListener(MessageListener listener){
	listeners.remove(listener);
    }

    /**
     * Notify listeners after setting the message.
     * @param message the message to set.
     */
    public void sendMessage(Message message){
	this.message = message;
	notifyListeners();
    }

    /**
     * Notify each listener in the listener list by calling listener's 
     * messageReceived() method.
     */
    private void notifyListeners(){
	    for(MessageListener listener : listeners){
	        listener.messageReceived(message);
	    }
    }
}
