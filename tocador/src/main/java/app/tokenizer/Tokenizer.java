import java.util.ArrayList;

package app.tokenizer.Tokenizer;

/*
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < args.length; i++) {
            System.out.println(args[i]);
            System.out.println(Tokenizer.Tokenizer(args[i]));
        }
    }
}
*/

enum Tokens {
    NOTA_LA,
    NOTA_SI,
    NOTA_DO,
    NOTA_RE,
    NOTA_MI,
    NOTA_FA,
    NOTA_SOL,
    TROCA_AGOGO,
    TROCA_HARPSICHORD,
    TROCA_BELLS,
    TROCA_FLUTE,
    TROCA_CHURCH,
    // Tocador irá decidir
    SILENCIO_OU_PAUSA,
    // Tocador irá decidir se consegue ou não dobrar o volume
    VOLUME_DOBRO,
    // Tocador irá decidir se consegue ou não aumentar a oitava
    AUMENTA_OITAVA,
    // Tocador deve somar o próximo valor
    INSTRUMENTO_DIGITO,
    FIM
}

public class Tokenizer {
    public static ArrayList<Tokens> Tokenizer(String texto) {
        ArrayList<Tokens> tokens = new ArrayList<Tokens>();
        int stringSize = texto.length();
        int lastChar = 1;

        for (int i = 0; i < stringSize; i++) {
            switch (texto.charAt(i)) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                    // As notas estão declaradas em ordem
                    tokens.add(Tokens.values()[Tokens.NOTA_LA.ordinal() + texto.charAt(i) - 'A']);
                    break;
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    tokens.add(Tokens.TROCA_HARPSICHORD);
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    tokens.add(Tokens.INSTRUMENTO_DIGITO);
                    // O Tocador deverá considerar o Token como dígito
                    tokens.add(Tokens.values()[texto.charAt(i) - '0']);
                    break;
                case ' ':
                    tokens.add(Tokens.VOLUME_DOBRO);
                    break;
                case '!':
                    tokens.add(Tokens.TROCA_AGOGO);
                    break;
                case '?':
                case '.':
                    tokens.add(Tokens.AUMENTA_OITAVA);
                    break;
                case '\n':
                    tokens.add(Tokens.TROCA_BELLS);
                    break;
                case ';':
                    tokens.add(Tokens.TROCA_FLUTE);
                    break;
                case ',':
                    tokens.add(Tokens.TROCA_CHURCH);
                    break;
                default:
                    if (lastChar >= 'A' && lastChar <= 'G') {
                        tokens.add(tokens.get(tokens.size()-1));
                    } else {
                        tokens.add(Tokens.SILENCIO_OU_PAUSA);
                    }

                    break;
            }

            lastChar = texto.charAt(i);
        }

        tokens.add(Tokens.FIM);

        return tokens;
    }
}
