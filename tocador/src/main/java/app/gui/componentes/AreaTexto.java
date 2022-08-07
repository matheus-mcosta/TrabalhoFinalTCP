package app.gui.componentes;

import java.awt.Color;

import javax.swing.JTextArea;

/**
 * AreaTexto
 */
public class AreaTexto extends JTextArea {

    public AreaTexto() {
        setBounds(50, 50, 550, 400);
        setLineWrap(true);
        setWrapStyleWord(true);
        setText("");
        setOpaque(true);
        setBackground(Color.decode("#b8b6cc"));

    }
}
