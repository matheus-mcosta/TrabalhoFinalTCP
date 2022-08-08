package app.gui;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

// import app.backend.Texto;
import app.gui.componentes.AreaTexto;
import app.gui.componentes.Botoes;

/**
 * Gui
 */
enum ListaInstrumentos {
    teste, teste2, teste3, test4
}

public class Gui extends JFrame {
    // constantes do tamanho da tela
    static final int LARGURA = 960;
    static final int ALTURA = 600;

    public Gui() {
        // incializadores da tela geral
        // setBounds(0, 0, LARGURA, ALTURA);
        setTitle("Tocador de Notas Musicais");
        setSize(LARGURA, ALTURA);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        inicializaPaineis();
        inicializaTexto();

    }

    private void inicializaTexto() {
        // Texto t = new Texto();
    }

    private void setPanel(JPanel p, int largura, int altura) {
        p.setSize(largura, altura);

    }

    private void inicializaPaineis() {

        // divididos dois paineis
        JPanel p1 = new JPanel(null);
        setPanel(p1, 600, 600);
        p1.setBackground(Color.decode("#797887"));

        // dropdown list de instrumentos
        JComboBox<ListaInstrumentos> instrumentos = new JComboBox<>(ListaInstrumentos.values());
        instrumentos.setBounds(650, 150, 280, 50);
        p1.add(instrumentos);

        // adiciona caixa de texto para input
        AreaTexto t = new AreaTexto();
        p1.add(t);
        inicializaBotoes(p1);
        add(p1);
    }

    private void inicializaBotoes(JPanel p) {
        // botoes da esquerda
        Botoes playButton = new Botoes("Play", 185, 475);
        Botoes stopButton = new Botoes("Stop", 335, 475);
        p.add(playButton);
        p.add(stopButton);
        // botoes da direita
        Botoes importButton = new Botoes("Import", 650, 250);
        importButton.addAction(importButton, 0);

        p.add(importButton);

        Botoes exportButton = new Botoes("Export", 800, 250);
        exportButton.addAction(exportButton, 1);
        p.add(exportButton);

    }

}
