package lexer.utils;

public class ASCIIUtils {
    public static boolean estUnChiffre(int i){
        return i>='0' && i<='9';
    }

    public static boolean estUnChiffrePlusGrandQueUn(int i){
        return i>='1' && i<='9';
    }

    public static boolean estUneMinuscule(int i){
        return i>='a' && i <='z';
    }
}
