package app.backend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import app.tela.componentes.Botoes;

/**
 * Texto
 */
abstract class Arquivo extends JTextArea {

    File arquivoTexto;
    String content;
}

public class Texto extends Arquivo {
    // private ArrayList<String> texto = new ArrayList<>();

    public Texto() {

        setLineWrap(true);
        setWrapStyleWord(true);
        setText("");
        setOpaque(true);
        setBackground(Color.decode("#b8b6cc"));
    }

    public String getContent() {
        return content;
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
                    try {
                        content = Files.readString(Paths.get(arquivoTexto.toURI()));
                        setText(content);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

}
