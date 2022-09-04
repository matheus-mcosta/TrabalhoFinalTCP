package app.backend;

import java.util.ArrayList;

import app.enums.Tokens;

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

public class Tokenizer {
    static ArrayList<Tokens> tokens = new ArrayList<Tokens>();

    static String stringConvertida = "";
    static int oitava = 3;
    static int instrumento;
    static int volume = 20;
    static int dropList = 113;

    public static void setDropList(String entrada) {
        switch (entrada) {
            case "Agogo":
                dropList = 113;
                break;
            case "Harpsichord":
                dropList = 6;
                break;
            case "Tubular Bells":
                dropList = 14;
                break;
            case "Pan Flute":
                dropList = 75;
                break;
            case "Church Organ":
                dropList = 19;
                break;
            default:
                break;
        }
    }

    public static void createToken(String texto) {
        // empty start for ArrayList
        instrumento = dropList;
        volume = 20;
        oitava = 3;
        tokens.removeAll(tokens);
        stringConvertida = " :CON(7, " + volume + ")"
                + " I" + instrumento;
        int stringSize = texto.length();
        int lastChar = 1;

        // TODO: TROCAR ARRAYLIST TOKENS PARA ESCRITA DIRETA STRING
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
                    stringConvertida += " "
                            + Tokens.values()[Tokens.NOTA_LA.ordinal() + texto.charAt(i) - 'A'].getData()
                            + oitava;
                    break;
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    instrumento = Integer.parseInt(Tokens.TROCA_HARPSICHORD.getData());
                    stringConvertida += " I" + instrumento;
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
                    if ((instrumento + (texto.charAt(i) - '0')) < 127) {
                        instrumento += (texto.charAt(i) - '0');
                    } else {
                        instrumento = 0;
                    }

                    stringConvertida += " I" + instrumento;
                    System.out.println(instrumento);
                    break;
                case ' ':
                    if (volume < 70) {
                        volume *= 2;
                    } else {
                        volume = 20;
                    }

                    stringConvertida += " :CON(7, " + volume + ")";
                    // :CON(7, 40)

                    break;
                case '!':
                    instrumento = Integer.parseInt(Tokens.TROCA_AGOGO.getData());
                    stringConvertida += " I" + instrumento;
                    break;
                case '?':
                case '.':
                    if (oitava < 9) {
                        oitava++;
                    } else {
                        oitava = 3;
                    }
                    break;
                case '\n':
                    instrumento = Integer.parseInt(Tokens.TROCA_BELLS.getData());
                    stringConvertida += " I" + instrumento;
                    break;
                case ';':
                    instrumento = Integer.parseInt(Tokens.TROCA_FLUTE.getData());
                    stringConvertida += " I" + instrumento;
                    break;
                case ',':
                    instrumento = Integer.parseInt(Tokens.TROCA_CHURCH.getData());
                    stringConvertida += " I" + instrumento;
                    break;
                default:
                    if (lastChar >= 'A' && lastChar <= 'G') {
                        stringConvertida += stringConvertida.substring(stringConvertida.length() - 3);
                    } else {
                        stringConvertida += " " + Tokens.SILENCIO_OU_PAUSA.getData();
                    }

                    break;
            }

            lastChar = texto.charAt(i);
        }

        System.out.println(stringConvertida);
    }
}
