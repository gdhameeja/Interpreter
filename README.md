# Pascal Interpreter
Interpreter is a computer program that reads the source code written in a particular language and executes the instructions.
On the other hand compiler is a computer program that converts the source code written in one language into a lower level language which can then be run to execute the instructions.

## Language of implementation:
Java

Based on book by Ronal Mak


### My understanding
- Compiler has two ends - frontend and a backend.
- Frontend does the initial translation and syntax checking etc.
- Frontend consists of Parser, Scanner, Source and Token.
- Parser controls the frontend execution.
- Parser calls scanner methods to get next token and/or current token.
- Scanner tokenizes the the source program.
- Source represents the source program.


### Intermediate Code
This is truely awesome. The frontend generates an Intermediate code and a symbol table which the backend of a compiler can process.
Intermediate code is predigested form of source code that backend can work with and symbol table is a table of the values of identifiers.
- Backend does not need to know the source language the program was written in as long as it has the intermediate code and the symbol table. Backend distinguishes between if code has to be interpreted or compiled. 
- Frontend needs to know the source program language but doesn't care if the code is going to be compiled or interpreted.
- Basically we can use the same frontend to supply code to multiple backends and we can use a single backend to process multiple source languages. Awesome.


### Messages
Messages allow for parser/scanner or any other entity to report information.
For example, parser may want to report a syntax error. Similarly, a source may want to report a line read.
- Any MessageProducer (parser/source etc) does not care who receives the message or what they do with the message.

##### Power of Interfaces
- In our case if someone wants to be a message producer, they need to implement Message Producer interface and implement the methods it offers.
- After implementing the interface, the Parser/Source may not define the methods themselves, they delegate control to MessageHandler class which defines these functionalities. It is like saying, I want to be a message producer, so I implement the MessageProducer interface and its methods, but I let MessageHandler take care of the functionalities for me. I love OOP.

##### Power of delegation
- The functionality of a message producer is actually defined in `MessageHandler` class. This allows other classes to use `MessageHandler`. This is more useful than defining the functionality in the message producer such as `Parser` or `Source` as now any other class that wants to use this functionality doesn't need to extend from `Parser` or `Source`. 