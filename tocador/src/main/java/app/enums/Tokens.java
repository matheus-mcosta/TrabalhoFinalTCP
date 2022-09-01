package app.enums;

public enum Tokens {
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
