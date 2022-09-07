package me.arjunpuri.pong.managers;

import java.util.HashMap;

import me.arjunpuri.pong.GameMain;
import me.arjunpuri.pong.screens.AbstractScreen;
import me.arjunpuri.pong.screens.GameScreen;

public class GameScreenManager {

    public final GameMain game;
    private HashMap<STATE, AbstractScreen> gameScreens;

    public enum STATE {
        MAIN_MENU,
        PLAY,
        SETTINGS
    }

    public GameScreenManager(final GameMain game) {
        this.game = game;
        this.initGameScreens();
        setScreen(STATE.PLAY);
    }

    private void initGameScreens() {
        this.gameScreens = new HashMap<STATE, AbstractScreen>();
        this.gameScreens.put(STATE.PLAY, new GameScreen(game));
    }

    public void setScreen(STATE nextScreen) {
        game.setScreen(gameScreens.get(nextScreen));
    }

    public void dispose() {
        for(AbstractScreen screen : gameScreens.values()) {
            if(screen != null) {
                screen.dispose();
            }
        }
    }

}
