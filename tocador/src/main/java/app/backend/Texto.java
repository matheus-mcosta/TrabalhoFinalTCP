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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.jfugue.midi.MidiFileManager;
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

    JFugue tocador;
    Thread threadTocador;

    public Texto() {
        // incializacao da caixa de texto da interface
        setLineWrap(true);
        setWrapStyleWord(true);
        setText("");
        setOpaque(true);
        setBackground(Color.decode("#f2f5fc"));
    }

    private void setContent(final String texto) {
        this.content = texto;
    }

    public String getContent() {
        return this.content;
    }

    public void setArquivoTexto(final File arquivoTexto) {
        this.arquivoTexto = arquivoTexto;
    }

    public void importAction(final Botoes botao) {

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // abre janela de arquivos e somente arquivos com extensao txt
                final JFileChooser arquivoAbrir = new JFileChooser(
                        FileSystemView.getFileSystemView().getHomeDirectory());
                final FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto .txt", "txt");
                arquivoAbrir.addChoosableFileFilter(filter);
                arquivoAbrir.setAcceptAllFileFilterUsed(false);

                if (arquivoAbrir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    arquivoTexto = arquivoAbrir.getSelectedFile();
                    try {
                        content = Files.readString(Paths.get(arquivoTexto.toURI()));
                        setText(content);
                        Tokenizer.createToken(content);

                    } catch (final IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public void exportAction(final Botoes botao) {

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // abre janela para salvar arquivo e salva em .MIDI
                final JFileChooser arquivoSalvar = new JFileChooser();
                final FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo .MIDI", "MIDI");
                arquivoSalvar.setFileFilter(filter);
                arquivoSalvar.setAcceptAllFileFilterUsed(false);
                arquivoSalvar.setFileSelectionMode(JFileChooser.FILES_ONLY);

                if (arquivoSalvar.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    final File arquivoMIDI = new File(arquivoSalvar.getSelectedFile().getAbsolutePath() + ".MIDI");
                    try {
                        MidiFileManager.savePatternToMidi(new Pattern(Tokenizer.stringConvertida),
                                arquivoMIDI);
                    } catch (final IOException err) {
                        err.printStackTrace();
                    }
                }
            }
        });
    }

    private void playSound(final JFugue tocador) {

        // implementa threads para poder dar stop no som!!!
        threadTocador = new Thread(tocador);
        threadTocador.start();
    }

    // le o texto contido na tela, chama conversor e passa para o tocador
    public void playAction(final Botoes botao) {
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                setContent(getText());
                Tokenizer.createToken(content);
                final Pattern pattern = new Pattern(Tokenizer.stringConvertida);
                tocador = new JFugue(pattern);
                playSound(tocador);
            }
        });
    }

    public void stopAction(final Botoes botao) {

        // chama metodo stopSound de tocador quando pressionar botao de stop
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                tocador.stopSound();
            }

        });

    }

}
