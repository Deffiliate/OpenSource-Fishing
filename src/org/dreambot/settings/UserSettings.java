package org.dreambot.settings;

import org.dreambot.data.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/11/2014
 * Time: 9:59 PM
 */
public class UserSettings {

    private FishingArea fishingArea;
    private BankArea bankArea;
    private FishingType fishingType;
    private boolean isBanking;
    private final List<FishType> fishTypeList = new ArrayList<>();
    private final List<FishingEquipment> equipmentList = new ArrayList<>();

    public List<FishingEquipment> getEquipmentList() {
        return equipmentList;
    }

    public void addEquipment (FishingEquipment... equipment) {
        Collections.addAll(equipmentList, equipment);
    }

    public List<FishType> getFishTypeList() {
        return fishTypeList;
    }

    public void addFish (FishType... fishTypes) {
        Collections.addAll(fishTypeList, fishTypes);
    }

    public FishingArea getFishingArea() {
        return fishingArea;
    }

    public BankArea getBankArea() {
        return bankArea;
    }

    public void setBankArea(BankArea bankArea) {
        this.bankArea = bankArea;
    }

    public void setFishingArea(FishingArea fishingArea) {
        this.fishingArea = fishingArea;
    }

    public FishingType getFishingType() {
        return fishingType;
    }

    public boolean isBanking() {
        return isBanking;
    }

    public void setBanking(boolean isBanking) {
        this.isBanking = isBanking;
    }

    public void setFishingType(FishingType fishingType) {
        this.fishingType = fishingType;
    }
}
