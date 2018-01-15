package lexer;
import lexer.utils.ASCIIUtils;

import java.util.*;
import java.io.*;

public class Lexer {
	private InputStream in;
	private int i; // current ASCII character (coded as an integer)

    private final int CHIFFRE_1 = '1';
    private final int CHIFFRE_9 = '9';
    private final int CHIFFRE_0 = '0';
    private final int LETTRE_a = 'a';
    private final int LETTRE_z = 'z';
	
	public Lexer(InputStream in) throws IOException {
		this.in = in;
		i = in.read(); // initialize current character
	}
	
	public List<Token> lex() throws UnexpectedCharacter, IOException {
		// return the list of tokens recorded in the file
		List<Token> tokens = new ArrayList<Token>();
		
		try {
			Token token = getToken();
	
			while (! (token instanceof EOF)) {
				tokens.add(token);
				token = getToken();
			}
			tokens.add(token); // this is the EOF token
		} catch (IOException e){
				in.close(); // close the reader
				throw e; // pass the exception up the stack
		}
		return tokens;
	}
	
	public Token getToken() throws UnexpectedCharacter, IOException {
		switch (i){
		    case -1 :
			    in.close();
			    return new EOF();
            case ' ' :
                i=in.read();
                return getToken();
            case '\n':
                i =in.read();
                return getToken();
            case '\t':
                i=in.read();
                return getToken();
            case '\r':
                i=in.read();
                return getToken();
			case '(' :
                i = in.read();
				return new LPar();
            case ')':
                i = in.read();
                return new RPar();
            case '=':
                i = in.read();
                if(i=='='){
                    i=in.read();
                    return OPToken.EQUAL;
                }
                return new Defvar();
            case '+':
                i=in.read();
                return OPToken.PLUS;
            case '-':
                i=in.read();
                return OPToken.MINUS;
            case '*':
                i=in.read();
                return OPToken.TIMES;
            case '/':
                i=in.read();
                return OPToken.DIVIDE;
            case '<':
                i=in.read();
                return OPToken.LESS;
             //Chiffre
            case '0':
                i=in.read();
                return new LiteralToken(0);

		    default :

                if(ASCIIUtils.estUnChiffrePlusGrandQueUn(i)) {
                    String buffer = "";
                    while (ASCIIUtils.estUnChiffre(i)) {
                        buffer = buffer + Character.getNumericValue(i);
                        i = in.read();
                    }
                    return new LiteralToken(Integer.parseInt(buffer));
                }

                if(i>=LETTRE_a && i <= LETTRE_z){
                    String buffer = "";
                    while(ASCIIUtils.estUneMinuscule(i)||ASCIIUtils.estUnChiffre(i)){
                        System.out.println("buffer " + buffer);
                        if(ASCIIUtils.estUnChiffre(i)){
                            buffer = buffer + Character.getNumericValue(i);
                        }
                        else{
                            buffer = buffer + Character.toString((char)i);
                        }
                        i = in.read();
                    }if(buffer.equals("if"))
                        return new If();
                    else if(buffer.equals("defun"))
                        return new FuncDef();
                    else
                        return new Identifier(buffer);
                }

                i = in.read();
			    throw new UnexpectedCharacter(i);
		}
	}
}


