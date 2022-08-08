package app.backend;

import java.io.File;
// import java.util.ArrayList;

/**
 * Texto
 */
abstract class Arquivo {

    File arquivoTexto;
}

public class Texto extends Arquivo {
    // private ArrayList<String> texto = new ArrayList<>();

    public Texto() {

    }

    public void setArquivoTexto(File arquivoTexto) {
        this.arquivoTexto = arquivoTexto;
    }

    public void printFile(File arquivoTexto) {

        System.out.println(this.arquivoTexto);
    }

}
