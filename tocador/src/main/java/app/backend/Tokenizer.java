package app.backend;

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
    static final int MIN_VOLUME = 19;
    static final int MAX_VOLUME = 79;
    static final int OITAVA_DEFAULT = 3;
    static final int MAX_OITAVA = 9;
    static final int MAX_MIDI = 127;

    static String stringConvertida;
    static int oitava;
    static int instrumento;
    static int volume;
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
                dropList = MIN_VOLUME;
                break;
            default:
                break;
        }
    }

    public static void createToken(String texto) {
        instrumento = dropList;
        volume = MIN_VOLUME;

        oitava = OITAVA_DEFAULT;
        stringConvertida = " :CON(7, " + volume + ")"
                + " I" + instrumento;
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
                    // MIDI MAX VALUE = 127
                    if ((instrumento + (texto.charAt(i) - '0')) < MAX_MIDI) {
                        instrumento += (texto.charAt(i) - '0');
                    } else {
                        instrumento = 0;
                    }

                    stringConvertida += " I" + instrumento;
                    System.out.println(instrumento);
                    break;
                case ' ':
                    if (volume < MAX_VOLUME) {
                        volume *= 2;
                    } else {
                        volume = MIN_VOLUME;
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
                    if (oitava < MAX_OITAVA) {
                        oitava++;
                    } else {
                        oitava = OITAVA_DEFAULT;
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
