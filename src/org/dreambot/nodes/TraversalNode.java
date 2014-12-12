package org.dreambot.nodes;

import org.dreambot.MainScript;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.TaskNode;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/11/2014
 * Time: 6:00 PM
 */
public class TraversalNode extends TaskNode {

    private MainScript script;
    private boolean isHeadingToSpot;

    public TraversalNode(MainScript script) {
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
        return 1; //Make this a lower priority than other actions, since we don't want to walk before completing our other actions first.
    }

    /**
     * The method which is used to determine if the
     *
     * @return boolean which determines if the execute() method
     * should be ran.
     */
    @Override
    public boolean accept() {
        if(!script.getSettings().getFishingArea().getArea().contains(getPlayers().myPlayer()) && script.isReadyToFish()){
            isHeadingToSpot = true;
            return true;
        } else if ((!script.getSettings().getBankArea().getArea().contains(getPlayers().myPlayer()) && !script.isReadyToFish())){
            isHeadingToSpot = false;
            return true;
        }
        return false;
    }

    /**
     * The method which handles the actions of the node.
     *
     * @return int the amount of time in ms to return after the
     * node has been executed.
     */
    @Override
    public int execute() {
        if(isHeadingToSpot){
            getWalking().walkGlobalTile(script.getSettings().getFishingArea().getArea().getRandomTile());
        } else {
            getWalking().walkGlobalTile(script.getSettings().getBankArea().getArea().getRandomTile());
        }
        return (int)Calculations.gRandom(800, 150);
    }

}
