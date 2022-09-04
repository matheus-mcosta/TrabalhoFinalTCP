package app.enums;

public enum Tokens {
    NOTA_LA("A"),
    NOTA_SI("B"),
    NOTA_DO("C"),
    NOTA_RE("D"),
    NOTA_MI("E"),
    NOTA_FA("F"),
    NOTA_SOL("G"),
    TROCA_AGOGO("113"),
    TROCA_HARPSICHORD("6"),
    TROCA_BELLS("14"),
    TROCA_FLUTE("75"),
    TROCA_CHURCH("19"),
    // Tocador irá decidir
    SILENCIO_OU_PAUSA("R"),
    // Tocador irá decidir se consegue ou não dobrar o volume
    // :CON(7, 40)
    VOLUME_DOBRO(""),
    // Tocador irá decidir se consegue ou não aumentar a oitava
    AUMENTA_OITAVA(""),
    // Tocador deve somar o próximo valor
    INSTRUMENTO_DIGITO("");

    private final String data;

    private Tokens(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
