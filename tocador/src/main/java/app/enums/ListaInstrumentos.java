package app.enums;

public enum ListaInstrumentos {
    AGOGO("Agogo"),
    HARPSICHORD("Harpsichord"),
    TUBULARBELLS("Tubular Bells"),
    PANFLUTE("Pan Flute"),
    CHURCHORGAN("Church Organ");

    private String nome;

    private ListaInstrumentos(final String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
