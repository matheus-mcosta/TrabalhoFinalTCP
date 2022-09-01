package app.backend;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * JFugue
 */
public class JFugue {

    Player player = new Player();

    public void playSound(Pattern pattern) {
        player.play(pattern);
    }
}
