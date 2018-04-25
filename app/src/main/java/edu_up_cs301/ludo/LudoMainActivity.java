package edu_up_cs301.ludo;

import java.util.ArrayList;

import edu_up_cs301.game.GameMainActivity;
import edu_up_cs301.game.GamePlayer;
import edu_up_cs301.game.LocalGame;
import edu_up_cs301.game.config.GameConfig;
import edu_up_cs301.game.config.GamePlayerType;
/*
 * [-25..0] Does the GUI work correctly?
 * ------> Yes the GUI is working correctly
 * [-10..+10] Is the GUI effective and particularly easy to use?
 * ------>Yes, all the player needs to do is roll the dice and touch his/her pieces
 * [-15..0] Does the dumb AI work?
 * ------>Yes, the dumb AI is fully functional
 * [-15..+10] Is the smart AI smarter than the dumb. Is it particularly challenging?
 * ------>Yes, the smart AI is wayy smarter than the dumb AI and is really complex
 * [-30..0] The game does not crash.
 * ------>Yes, the game does not crash
 * [-10..0] Did you appropriately address all the bugs that were reported against the game?
 * ------>Yes, all the bugs were addressed
 * [-10..0] Does the game support network play?
 * ------>Yes, the game supports Network play
 * [-30..0] Does the game fully implement the rules of play you defined in your requirements?
 * ------>Yes, the game fully implements all the rules we defined
 [-15..0] Does your game clearly derive from the design you started with?
 * ------>Yes, the game clearly derives from the design we started with
 * [-20..+5] Does the game follow the CS301 coding standard? Is it well documented?
 * ------>Yes, the game follows the coding standard and is well documented
 * [-100..0] Did you acknowledge the places where you got help with the code as per the coding standard?
 * ------>Yes, all external citations are added where necessary
 * [-10..0] Are your unit tests still present and still passing? Are they a reasonable set of tests for your game state?
 * ------>Yes, all the unit tests are still there and are passing and are reasonable
 * [-10..+5] Is the game visually pleasing?
 * ----->Yes, the GUI and game is beautiful
 * [0..+15] Does the game incorporate extra features that enhance the overall play experience?
 * ----->Yes, our start up screen is beautiful and colorful, we have added music with a bunch of differnt songs
 * that the user can select, and our GUI is all done by Java graphics and Nuxoll has expressed how beautful our
 * GUI is. In addition, the pieces move on their own when there is only one move available, which is really nice for
 * whoever is playing our game. In addition, we also have a rules button that explains the rules of the game. A lot of
 * features were added to this game.
 * [-10..0] Did you follow instructions in this assignment?
 * -----> Yes, all instructions were followed in this assignment.
 *
 *
 */

/**
 * LudoMainActivity
 * It is the default start up screen
 */
public class LudoMainActivity extends GameMainActivity {

    // the port number that this game will use when playing over the network
    private static final int PORT_NUMBER = 2278;

    /**
     * Create the default configuration for this game:
     * - one human player vs. one computer player
     * - minimum of 1 player, maximum of 4
     *
     * @return
     * 		the new configuration object, representing the default configuration
     */
    @Override
    public GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        // Ludo has two player types:  human and computer
        playerTypes.add(new GamePlayerType("Local Human") {
            public GamePlayer createPlayer(String name) {
                return new HumanPlayer(name);
            }});


        playerTypes.add(new GamePlayerType("Smart Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new ComputerSmartPlayer(name);
            }});

        playerTypes.add(new GamePlayerType("Computer Easy") {
            public GamePlayer createPlayer(String name) {
                return new ComputerPlayer(name);
            }});

        // Create a game configuration class for Ludo:
        GameConfig defaultConfig = new GameConfig(playerTypes, 1, 4, "Ludo", PORT_NUMBER);
        defaultConfig.addPlayer("Human", 0); // player 1: a human player
        defaultConfig.addPlayer("ComputerEasy2", 1); // player 2: a computer player
        defaultConfig.addPlayer("ComputerEasy3", 1);
        defaultConfig.addPlayer("ComputerEasy4", 1);
        defaultConfig.setRemoteData("Remote Human Player", "", 0);

        return defaultConfig;
    }//createDefaultConfig

    /**
     * create a local game
     *
     * @return
     * 		the local game, a Ludo game
     */
    @Override
    public LocalGame createLocalGame() {
        return new LudoLocalGame();
    }


}




