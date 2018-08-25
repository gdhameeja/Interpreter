# Pascal Interpreter
Interpreter is a computer program that reads the source code written in a particular language and executes the instructions.
On the other hand compiler is a computer program that converts the source code written in one language into a lower level language which can then be run to execute the instructions.

## Language of implementation:
Python
- Python itself is an interpreted language.

## Design
- Token class: Specifies the different types of tokens we support. Example `'INTEGERS', 'PLUS', 'EOF'`
- Interpreter class: That actually goes through the program classifying each token at a time.
