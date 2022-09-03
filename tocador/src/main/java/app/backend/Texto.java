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

import org.jfugue.pattern.Pattern;

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
    //

    Pattern pattern = new Pattern(
            " :CON(7, 40) I[TROMBONE] Rh G5is E5i Ri | G5s Ris E5q Rs :CON(7, 100) | G5q E5i Rs D5q rs C5h Rs I[AGOGO] Rh G5is E5i Ri | G5s Ris E5q Rs | G5q E5i Rs D5q rs C5h Rs ");
    JFugue tocador = new JFugue(pattern);
    Thread threadTocador;

    public Texto() {

        setLineWrap(true);
        setWrapStyleWord(true);
        setText("");
        setOpaque(true);
        setBackground(Color.decode("#b8b6cc"));
    }

    private void setContent(String texto) {

        this.content = texto;
    }

    public String getContent() {
        return this.content;
    }

    public void setArquivoTexto(File arquivoTexto) {
        this.arquivoTexto = arquivoTexto;
    }

    public void importAction(Botoes botao) {
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser arquivo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                if (arquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    // se abrir com sucesso faz isso ->
                    // achar um jeito de modular isso para outra classe
                    arquivoTexto = arquivo.getSelectedFile();
                    try {
                        content = Files.readString(Paths.get(arquivoTexto.toURI()));
                        setText(content);
                        Tokenizer.createToken(content);

                        Tokenizer.PrintToken();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    private void playSound() {

        // implementa threads para poder dar stop no som!!!
        threadTocador = new Thread(tocador);
        threadTocador.start();
        System.out.println(threadTocador.getId());
    }

    private void stopSound() {

        System.out.println("entrou");
        // troca pattern a ser tocado para vazio, mesmo que stop no som
        tocador.stopSound();
    }

    public void playAction(Botoes botao) {

        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setContent(getText());

                Tokenizer.createToken(content);

                Tokenizer.PrintToken();
                playSound();

            }

        });

    }

    public void stopAction(Botoes botao) {

        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setContent(getText());

                stopSound();

            }

        });

    }

}
