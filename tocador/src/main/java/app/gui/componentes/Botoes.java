package app.gui.componentes;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

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
}
