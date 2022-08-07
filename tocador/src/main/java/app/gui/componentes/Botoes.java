package app.gui.componentes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * botoes
 */
public class Botoes extends JButton {

    public Botoes(String nome, int x, int y) {
        // this.setContentAreaFilled(true);
        this.setOpaque(true);
        this.setText(nome);
        this.setHorizontalAlignment(CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff"), 2, true));
        this.setBounds(x, y, 150, 50);
        this.setBackground(Color.decode("#789321"));
    }
}
