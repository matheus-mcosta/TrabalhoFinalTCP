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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
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

    JFugue tocador;
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
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto .TXT", "txt");
                arquivo.addChoosableFileFilter(filter);
                arquivo.setAcceptAllFileFilterUsed(false);

                if (arquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    // se abrir com sucesso faz isso ->
                    // achar um jeito de modular isso para outra classe
                    arquivoTexto = arquivo.getSelectedFile();
                    try {
                        content = Files.readString(Paths.get(arquivoTexto.toURI()));
                        setText(content);
                        Tokenizer.createToken(content);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public void exportAction(Botoes botao) {
//TODO: IMPLEMENTAR EXPORT EM MIDI
    }

    private void playSound(JFugue tocador) {

        // implementa threads para poder dar stop no som!!!
        threadTocador = new Thread(tocador);
        threadTocador.start();
        System.out.println(threadTocador.getId());
    }

    private void stopSound(JFugue tocador) {

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
                Pattern pattern = new Pattern(Tokenizer.stringConvertida);
                tocador = new JFugue(pattern);
                playSound(tocador);

            }

        });

    }

    public void stopAction(Botoes botao) {

        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setContent(getText());

                stopSound(tocador);

            }

        });

    }

}
