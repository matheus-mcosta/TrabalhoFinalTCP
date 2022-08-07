package app.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.gui.componentes.Botoes;

/**
 * Gui
 */
public class Gui extends JFrame {
    // constantes do tamanho da tela
    static final int LARGURA = 1280;
    static final int ALTURA = 800;

    public Gui() {
        // incializadores da tela geral
        // setBounds(0, 0, LARGURA, ALTURA);
        setSize(LARGURA, ALTURA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tocador de Notas Musicais");
        setResizable(false);

        // importa componentes
        JPanel botoes = new JPanel(null);
        botoes.setBackground(Color.decode("#2f2f2f"));
        botoes.setSize(1000, 600);
        getBotoes(botoes);
        add(botoes);

    }

    private void getBotoes(JPanel botoes) {
        Botoes playButton = new Botoes("Play", 100, 600);
        Botoes stopButton = new Botoes("stopButton", 300, 600);
        botoes.add(playButton);
        botoes.add(stopButton);

    }
}
