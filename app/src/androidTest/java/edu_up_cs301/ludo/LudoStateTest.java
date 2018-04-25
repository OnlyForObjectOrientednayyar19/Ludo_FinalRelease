package edu_up_cs301.ludo;

import org.junit.Test;

import static org.junit.Assert.*;

public class LudoStateTest {


    /**
     * newRollTest
     * Tests the functionality of a new roll be seeing if the dice value is greater than 1
     * and less than or equal to 6
     */
    @Test
    public void newRollTest() {
        LudoState state = new LudoState();
        state.newRoll();
        if(state.getDiceVal() <=6 && state.getDiceVal()>0){
            assertEquals(1,1);
        }
        else{    assertEquals(-1,1);
        }
    }

    /**
     * incPlayerScoreTest
     * Tests to see if the player's score is correctly increased
     */
    @Test
    public void incPlayerScoreTest() {
        LudoState state = new LudoState();
        state.incPlayerScore(0);
        assertEquals(state.getPlayerScore(0),1);
        state.incPlayerScore(0);
        state.incPlayerScore(0);
        state.incPlayerScore(0);
        assertEquals(state.getPlayerScore(0),4);
    }


    /**
     * changePlayerTurnTest
     * This tests to see if the changePlayerTurn methods changes the players turn
     * As an edge case, if it is player three's turn and the change player turn method
     * is called, it should wrap around to player 0's turn.
     */
    @Test
    public void changePlayerTurnTest(){
        LudoState state = new LudoState();
        assertEquals(state.getWhoseMove(),0);
        state.changePlayerTurn();
        assertEquals(state.getWhoseMove(),1);
        state.changePlayerTurn();
        state.changePlayerTurn();
        state.changePlayerTurn();
        //It should wrap around back to player 0
        assertEquals(state.getWhoseMove(),0);

    }

    /**
     * advanceTokenTest
     * This tests to see if the advanceToken method advances the specified token
     */
    @Test
    public void advanceTokenTest() {
        LudoState state = new LudoState();
        state.pieces[0].setIsMovable(true);
        state.newRoll();
        state.advanceToken(0,0);
        assertEquals(state.pieces[0].getNumSpacesMoved()+state.getDiceVal(),state.getDiceVal());
    }

    /**
     * getOrderTest
     * This test to se if the getOrder does indeed return the order in which the player's
     * pieces are. Whichever piece is in the array order's third index is the furthest player
     */
    @Test
    public void getOrderTest() {
        assertEquals(0,0);
        LudoState state = new LudoState();
        state.newRoll();
        state.advanceToken(0,0);
        assertEquals(state.getOrder(0)[3],0);

    }
}