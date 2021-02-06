package Player;

import Grid.PlayerGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.security.Key;

public class PlayerController implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;
    private PlayerGrid playerGrid;

    public PlayerController(PlayerGrid playerGrid){
        keyboard = new Keyboard(this);
        player = new Player(playerGrid);

        this.playerGrid = playerGrid;

    }

    public void init() {
        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(eventUp);
        keyboard.addEventListener(eventDown);
        keyboard.addEventListener(eventLeft);
        keyboard.addEventListener(eventRight);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
       switch (keyboardEvent.getKey()) {
           case KeyboardEvent.KEY_DOWN:

               player.move(Direction.DOWN);
               break;

           case KeyboardEvent.KEY_UP:

               player.move(Direction.UP);
               break;

           case KeyboardEvent.KEY_LEFT:

               player.move(Direction.LEFT);
               break;

           case KeyboardEvent.KEY_RIGHT:

               player.move(Direction.RIGHT);
               break;

       }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
