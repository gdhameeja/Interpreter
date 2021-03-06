package com.wci.frontend.pascal;

import static com.wci.frontend.Source.EOF;

import com.wci.frontend.*;

/**
 *
 *
 * <h1>PascalScanner </h1>
 *
 * <p>The Pascal scanner.
 */
public class PascalScanner extends Scanner {
  /**
   * Constructor
   *
   * @param source the source to be used with this scanner.
   */
  public PascalScanner(Source source) {
    super(source);
  }

  /**
   * Extract and return the next Pascal token from the source.
   *
   * @return the next token.
   * @throws Exception if error occurred.
   */
  public Token extractToken() throws Exception {
    Token token;

    // Construct the next token. The current character determines the token type.
    char currentChar = currentChar();
    if (currentChar == EOF) {
      token = new EofToken(source);
    } else {
      token = new Token(source);
    }
    return token;
  }
}
