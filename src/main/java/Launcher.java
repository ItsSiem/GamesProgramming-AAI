import aai.game.GameFrame;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class Launcher {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame("AAI", 1000, 1000);
        frame.run();
    }
}