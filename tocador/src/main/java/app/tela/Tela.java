package app.tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.backend.Texto;
import app.backend.Tokenizer;
import app.enums.ListaInstrumentos;
import app.tela.componentes.Botoes;

/**
 * Tela
 */

public class Tela extends JFrame {
    // constantes do tamanho da tela
    static final int LARGURA = 960;
    static final int ALTURA = 600;

    // variaveis
    Texto texto;

    public Tela() {
        // incializadores da tela geral
        setTitle("Tocador de Notas Musicais");
        setSize(LARGURA, ALTURA);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        inicializaPaineis();

    }

    private void setPanel(final JPanel p, final int largura, final int altura) {
        p.setSize(largura, altura);
    }

    private void inicializaPaineis() {

        // divididos dois paineis
        final JPanel painel1 = new JPanel(null);
        setPanel(painel1, 600, 600);
        painel1.setBackground(Color.decode("#c2c4cc"));

        // dropdown list de instrumentos
        final JComboBox<ListaInstrumentos> instrumentos = new JComboBox<ListaInstrumentos>(ListaInstrumentos.values());
        // eventListener da lista de instrumentos selecionaveis da lista
        instrumentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {

                Tokenizer.setDropList(instrumentos.getSelectedItem().toString());
            }
        });

        instrumentos.setBounds(650, 150, 280, 50);
        painel1.add(instrumentos);

        // adiciona caixa de texto para input
        final Texto texto = new Texto();
        final JScrollPane scrollPane = new JScrollPane(texto);
        scrollPane.setBounds(50, 50, 550, 400);
        painel1.add(scrollPane);
        // incializa texto e botooes da tela
        inicializaBotoes(painel1, texto);
        add(painel1);

    }

    private void inicializaBotoes(final JPanel painel, final Texto texto) {
        // botoes da esquerda
        final Botoes playButton = new Botoes("Play", 185, 475);
        texto.playAction(playButton);
        painel.add(playButton);

        final Botoes stopButton = new Botoes("Stop", 335, 475);
        texto.stopAction(stopButton);
        painel.add(stopButton);

        // botoes da direita
        final Botoes importButton = new Botoes("Import", 650, 250);
        texto.importAction(importButton);
        painel.add(importButton);

        final Botoes exportButton = new Botoes("Export", 800, 250);
        texto.exportAction(exportButton);
        painel.add(exportButton);

    }

}
