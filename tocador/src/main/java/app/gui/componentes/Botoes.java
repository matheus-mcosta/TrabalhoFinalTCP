package app.gui.componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * botoes
 */
public class Botoes extends JButton {

    public Botoes(String nome, int x, int y) {
        setOpaque(true);
        setText(nome);
        setHorizontalAlignment(CENTER);
        setBorder(
                BorderFactory.createLineBorder(Color.decode("#ffffff"), 2, true));
        setBounds(x, y, 130, 45);
        setBackground(Color.decode("#789321"));
    }

    public void addAction(Botoes b, final int f) {
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser arquivo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                switch (f) {
                    case 0:

                        if (arquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                            // se abrir com sucesso faz isso ->
                            // achar um jeito de modular isso para outra classe
                            File teste = arquivo.getSelectedFile();
                            System.out.println(teste.getAbsolutePath());
                            System.out.println(teste.getName());

                        }
                        break;
                    case 1:
                        if (arquivo.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

                            // se escolher certo para salvar faz isso ->
                        }

                    default:
                        break;
                }
            }
        });

    }
}
