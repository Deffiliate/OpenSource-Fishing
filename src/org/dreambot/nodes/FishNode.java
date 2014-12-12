package org.dreambot.nodes;

import org.dreambot.MainScript;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.interactive.NPC;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/11/2014
 * Time: 6:00 PM
 */
public class FishNode extends TaskNode {

    private MainScript script;
    private NPC currentSpot;

    public FishNode(MainScript script) {
        this.script = script;
    }

    /**
     * Used to determine the order which the nodes should be ran.
     *
     * @return int to be used to determine which node should be ran, if
     * more than one is accepted.
     */
    @Override
    public int priority() {
        return 4; //Since I want this execute over any other node that may also be accepted.
    }

    /**
     * The method which is used to determine if the
     *
     * @return boolean which determines if the execute() method
     * should be ran.
     */
    @Override
    public boolean accept() {
        if(script.getSettings().getFishingArea().getArea().contains(getPlayers().myPlayer())) {
            if(currentSpot == null || !currentSpot.exists())
                currentSpot = getBestFishingSpot(script.getSettings().getFishingType().toString());
            return currentSpot != null &&
                    !getInventory().isFull() &&
                    script.isReadyToFish() &&
                    !getPlayers().myPlayer().isMoving() &&
                    getPlayers().myPlayer().getInteractingCharacter() != null;
        }
        return false;
    }

    private NPC getBestFishingSpot (String action) {
        return getNpcs().getClosest(npc -> npc.getName().equals("Fishing spot") &&
                Arrays.asList(npc.getActions()).contains(action) &&
                npc.getModel() != null && npc.getModel().getVertexCount() < 50);
    }

    /**
     * The method which handles the actions of the node.
     *
     * @return int the amount of time in ms to return after the
     * node has been executed.
     */
    @Override
    public int execute() {
        if(currentSpot != null){
            if(currentSpot.distance(getPlayers().myPlayer()) > 5)
                getWalking().walkGlobalTile(currentSpot.getTile());
            if(!currentSpot.isOnScreen()) {
                if (Math.random() > .40) // 60% chance of using the mouse to rotate, 40% chance of using keys
                    getCamera().mouseRotateToEntity(currentSpot);
                else
                    getCamera().rotateToEntity(currentSpot);
            }
            if(currentSpot.distance(getPlayers().myPlayer()) < 5 && currentSpot.isOnScreen()){
                currentSpot.interact(script.getSettings().getFishingType().toString());
            }
        }
        return (int)Calculations.gRandom(1000, 100);
    }

}
