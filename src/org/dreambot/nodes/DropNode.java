package org.dreambot.nodes;

import org.dreambot.MainScript;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/11/2014
 * Time: 6:00 PM
 */
public class DropNode extends TaskNode {

    private MainScript script;
    private List<Item> keptItems = new ArrayList<>();

    public DropNode(MainScript script) {
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
        return 3; //Make this mid level-ish priority.
    }

    /**
     * The method which is used to determine if the
     *
     * @return boolean which determines if the execute() method
     * should be ran.
     */
    @Override
    public boolean accept() {
        return getInventory().isFull() &&
                script.hasJunkFish() &&
                getPlayers().myPlayer().getInteractingIndex() == -1;
    }

    private List<Item> getKeptItemList () {
        keptItems.clear();
        for(Item item : getInventory().getItems()){
            if(!script.getSettings().getFishTypeList().isEmpty()) {
                script.getSettings().getFishTypeList().stream().filter(t ->
                        item.getName().equals(t.toString())).forEach(type ->
                        keptItems.add(getInventory().getItem(type.toString())));
            }
            if(script.getSettings().getEquipmentList().isEmpty()) {
                script.getSettings().getEquipmentList().stream().filter(t ->
                        item.getId() == t.getId()).forEach(type ->
                        keptItems.add(getInventory().getItem(type.toString())));
            }
        }
        return keptItems;
    }

    /**
     * The method which handles the actions of the node.
     *
     * @return int the amount of time in ms to return after the
     * node has been executed.
     */
    @Override
    public int execute() {
        return (int)Calculations.gRandom(800, 150);
    }

}
