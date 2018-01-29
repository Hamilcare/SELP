package lexer;
import lexer.utils.ASCIIUtils;


import java.io.*;

public class Lexer {
	private InputStream in;
	private int i; // current ASCII character (coded as an integer)
	
	public Lexer(InputStream in) throws IOException {
		this.in = in;
		i = in.read(); // initialize current character
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
                    StringBuilder buffer = new StringBuilder("");
                    while (ASCIIUtils.estUnChiffre(i)) {
                        buffer.append(Character.getNumericValue(i));
                        i = in.read();
                    }
                    return new LiteralToken(Integer.parseInt(buffer.toString()));
                }

                if(i>='a' && i <= 'z'){
                    StringBuilder buffer = new StringBuilder("");
                    while(ASCIIUtils.estUneMinuscule(i)||ASCIIUtils.estUnChiffre(i)){
                        if(ASCIIUtils.estUnChiffre(i)){
                            buffer.append(Character.getNumericValue(i));
                        }
                        else{
                            buffer.append(Character.toString((char)i));
                        }

                        i = in.read();
                    }if(buffer.toString().equals("if"))
                        return new If();
                    else if(buffer.toString().equals("defun"))
                        return new FuncDef();
                    else
                        return new Identifier(buffer.toString());
                }

                i = in.read();
			    throw new UnexpectedCharacter(i);
		}
	}
}


