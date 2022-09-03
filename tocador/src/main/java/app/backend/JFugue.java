package app.backend;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * JFugue
 */
public class JFugue implements Runnable {

    Pattern pattern;
    Player player;

    JFugue(Pattern patternInput) {

        this.pattern = new Pattern(patternInput);
        this.player = new Player();

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        this.player.play(this.pattern);
    }


    // faz tocar pattern vazio, mesmo que dar stop na musica
    public void stopSound() {
        this.player.play("");
    }
}
