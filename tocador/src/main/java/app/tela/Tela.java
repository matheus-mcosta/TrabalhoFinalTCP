package app.tela;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import app.backend.Texto;
// import app.backend.Texto;
import app.tela.componentes.AreaTexto;
import app.tela.componentes.Botoes;

/**
 * Tela
 */

enum ListaInstrumentos {
    teste, teste2, teste3, test4
}

public class Tela extends JFrame {
    // constantes do tamanho da tela
    static final int LARGURA = 960;
    static final int ALTURA = 600;

    // variaveis
    Texto texto;

    public Tela() {
        // incializadores da tela geral
        // setBounds(0, 0, LARGURA, ALTURA);
        setTitle("Tocador de Notas Musicais");
        setSize(LARGURA, ALTURA);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        inicializaPaineis();

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
        AreaTexto caixaTexto = new AreaTexto();

        p1.add(caixaTexto);
        // incializa texto e botooes da tela
        Texto texto = new Texto();
        inicializaBotoes(p1, texto);
        add(p1);
    }

    private void inicializaBotoes(JPanel p, Texto t) {
        // botoes da esquerda
        Botoes playButton = new Botoes("Play", 185, 475);
        Botoes stopButton = new Botoes("Stop", 335, 475);
        p.add(playButton);
        p.add(stopButton);

        // botoes da direita
        Botoes importButton = new Botoes("Import", 650, 250);
        t.importAction(importButton);
        p.add(importButton);

        Botoes exportButton = new Botoes("Export", 800, 250);
        p.add(exportButton);

    }

}
