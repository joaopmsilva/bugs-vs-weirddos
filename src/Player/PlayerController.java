package Player;

import Game.Game;
import Grid.CollisionDetector;
import Grid.PlayerGrid;
import Props.Cpu;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerController implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;
    private Game game;

    public PlayerController(PlayerGrid playerGrid, Cpu cpu, CollisionDetector collisionDetector, Game game){
        this.game = game;
        keyboard = new Keyboard(this);
        player = new Player(playerGrid, cpu, collisionDetector);
    }

    public Player getPlayer(){
        return player;
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

        KeyboardEvent eventUse = new KeyboardEvent();
        eventUse.setKey(KeyboardEvent.KEY_E);
        eventUse.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventQuit = new KeyboardEvent();
        eventQuit.setKey(KeyboardEvent.KEY_Q);
        eventQuit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventStart = new KeyboardEvent();
        eventStart.setKey(KeyboardEvent.KEY_SPACE);
        eventStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(eventUp);
        keyboard.addEventListener(eventDown);
        keyboard.addEventListener(eventLeft);
        keyboard.addEventListener(eventRight);
        keyboard.addEventListener(eventUse);
        keyboard.addEventListener(eventQuit);
        keyboard.addEventListener(eventStart);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
       switch (keyboardEvent.getKey()) {
           case KeyboardEvent.KEY_DOWN:
               if(!game.isStarted) return;
               player.move(Direction.DOWN);
               break;
           case KeyboardEvent.KEY_UP:
               if(!game.isStarted) return;
               player.move(Direction.UP);
               break;
           case KeyboardEvent.KEY_LEFT:
               if(!game.isStarted) return;
               player.move(Direction.LEFT);
               break;
           case KeyboardEvent.KEY_RIGHT:
               if(!game.isStarted) return;
               player.move(Direction.RIGHT);
               break;
           case KeyboardEvent.KEY_E:
               if(!game.isStarted || game.stage < 3) return;
               player.killAll();
               break;
           case KeyboardEvent.KEY_Q:
               System.exit(1);
               break;
           case KeyboardEvent.KEY_SPACE:
               game.isStarted = true;
               break;
       }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
