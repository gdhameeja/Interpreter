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
