#!/usr/bin/python3

INTEGER, PLUS, EOF = 'INTEGER', 'PLUS', 'EOF'

class Token:

    def __init__(self, type, value):
        """ 
        type -> 'INTEGER', 'PLUS', 'EOF' 
        value -> As of now only integer values
        """
        self.type = type
        self.value = value

    def __str__(self):
        return 'Token {type} {value}'.format(type=self.type, value=self.value)

class Interpreter:
    """ 
    Actual interpreter class. Tokenises the input and processses each token 
    """
    def __init__(self, text):
        """ text is the source code of the program interpreter will operate upon """ 
        self.text = text
        self.pos = 0  # current_pos initialised to the beginning of the program
        
    def get_current_token(self):
        text = self.text
        # EOF
        if self.pos > len(self.text) - 1:
            return Token(EOF, None)

        current_character = self.text[self.pos]
        
        if current_character.isdigit():
            self.pos += 1
            return Token(INTEGER, int(current_character))
        
        if current_character == "+":
            self.pos += 1
            return Token(PLUS, current_character)

    def calculate(self):
        left = self.get_current_token()
        if not left.type == INTEGER:
            raise Exception("First token needs to be an integer")
        op = self.get_current_token()
        if not op.type == PLUS:
            raise Exception("Second token should be an operator")
        right = self.get_current_token()
        if not right.type == INTEGER:
            raise Exception("Last token needs to be an integer")
        return left.value + right.value
        
def main():
    
    print("Calci ver 0.0.0")
    print("Authored by Gaurav Dhameeja")
    print("Press 'q' to exit")
    while True:
        source = input("calci> ")
        if source == "q":
            break
        interpreter = Interpreter(source)
        print(interpreter.calculate())
        
        
if __name__ == '__main__':
    main()

        


        
