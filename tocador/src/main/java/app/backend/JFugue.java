package app.backend;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * JFugue
 */
public class JFugue implements Runnable {

    Pattern pattern;
    Player player;

    JFugue(final Pattern patternInput) {
        this.pattern = new Pattern(patternInput);
        this.player = new Player();
    }

    // funcao de thread para tocar em paralelo para permitir stopSound
    // e abrir janela de arquivo enquanto toca, assim nao depende da 
    // musica acabar para fazer outras operacoes
    @Override
    public void run() {
        this.player.play(this.pattern);
    }

    // faz tocar pattern vazio, mesmo que dar stop na musica
    public void stopSound() {
        this.player.play("");
    }
}
