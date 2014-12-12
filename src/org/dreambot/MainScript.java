package org.dreambot;

import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.impl.NodeScript;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.data.FishingArea;
import org.dreambot.data.FishingEquipment;
import org.dreambot.nodes.FishNode;
import org.dreambot.settings.UserSettings;


/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 11/24/2014
 * Time: 4:55 PM
 */
@ScriptManifest(name = "OpenFishing", description = "Open Source Fishing", version = 1.0, category = Category.FISHING, author = "Notorious")
public class MainScript extends NodeScript {

    private UserSettings settings;

    @Override
    public void onStart() {
        settings = new UserSettings();
        /* Later we can handle this using a GUI */
        //We add our equipment we need to use
        settings.addEquipment(FishingEquipment.SMALL_NET);
        //We set which location we want to fish at
        settings.setFishingArea(FishingArea.DRAYNOR_VILLAGE);
        addNodes(new FishNode(this));
        setFailLimit(-1); // By settings this to -1, we ignore the fail counter, meaning it will stop the script.
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    public UserSettings getSettings() {
        return settings;
    }

    public boolean isReadyToFish () {
        return !getInventory().isFull() &&
                hasAllEquipment() &&
                getPlayers().myPlayer().getInteractingIndex() == -1;
    }

    public boolean hasAllEquipment () {
        return !settings.getEquipmentList().stream().filter(e -> !getInventory().contains(e.getId())).findFirst().isPresent();
    }
    public boolean hasJunkFish () {
        if(!settings.getFishTypeList().isEmpty()) {
            for (Item item : getInventory().getItems()) {
                if (item.getName().contains("Raw") || item.getName().contains("Leaping")) {
                    if (!settings.getFishTypeList().stream().filter(t -> item.getName().equals(t.toString())).findFirst().isPresent()) {
                        return true;
                    }
                }
            }
        }  else {
            for (Item item : getInventory().getItems()) {
                if(item.getName().contains("Raw") || item.getName().contains("Leaping")){
                    return true;
                }
            }
        }
        return false;
    }
}
