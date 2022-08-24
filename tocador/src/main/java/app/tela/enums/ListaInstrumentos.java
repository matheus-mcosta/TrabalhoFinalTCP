package app.tela.enums;

public enum ListaInstrumentos {
    AGOGO("Agogo"),
    HARPSICHORD("Harpsichord"),
    TUBULARBELLS("Tubular Bells"),
    PANFLUTE("Pan Flute"),
    CHURCHORGAN("Churhc Organ");

    private String nome;

    private ListaInstrumentos(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
