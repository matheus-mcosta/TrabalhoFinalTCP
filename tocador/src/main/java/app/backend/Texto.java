package app.backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
// import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import app.tela.componentes.Botoes;

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

    public void importAction(Botoes b) {
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser arquivo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                if (arquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    // se abrir com sucesso faz isso ->
                    // achar um jeito de modular isso para outra classe
                    arquivoTexto = arquivo.getSelectedFile();
                    System.out.println(arquivoTexto.getAbsolutePath());
                    System.out.println(arquivoTexto.getName());

                    System.out.println(arquivoTexto);

                }
            }
        });
    }

    public void exportAction(Botoes b) {
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser arquivo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                if (arquivo.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

                    // TODO: salvar o arquivo em uma variavel primeiro
                    // funcao de exportar o som para um arquivo
                }
            }
        });
    }

}
