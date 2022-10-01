package app.tela.componentes;

import javax.swing.JButton;

/**
 * Classe padrao dos botoes da interface
 */
public class Botoes extends JButton {

    public Botoes(String nome, int x, int y) {
        setText(nome);
        setHorizontalAlignment(CENTER);
        setBounds(x, y, 130, 45);
    }

}
