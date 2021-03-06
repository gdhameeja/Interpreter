package com.wci.frontend;

/**
 *
 *
 * <h1>FrontendFactory </h1>
 *
 * <p>A factory class that creates parsers for a specific language
 */
import com.wci.frontend.pascal.*;

public class FrontendFactory {

  /**
   * Creates a parser.
   *
   * @param language the name of the source language (e.g. "pascal").
   * @param type the type of the parser (e.g "top-down").
   * @param source the source code.
   * @throws Exception if an error occurred.
   */
  public static Parser createParser(String language, String type, Source source) throws Exception {
    if (language.equalsIgnoreCase("Pascal") && type.equalsIgnoreCase("top-down")) {
      Scanner scanner = new PascalScanner(source);
      return new PascalParserTD(scanner);
    } else if (!language.equalsIgnoreCase("Pascal")) {
      throw new Exception("ParserFactory: Invalid language '" + language + "'");
    } else {
      throw new Exception("ParserFactory: Invalid type '" + type + "'");
    }
  }
}
