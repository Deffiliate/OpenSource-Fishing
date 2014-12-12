package org.dreambot.data;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/11/2014
 * Time: 9:23 PM
 */
public enum FishingType {

    NET,
    LURE,
    BAIT,
    CAGE,
    HARPOON;

    @Override
    public String toString() {
        String s = super.toString().replace('_',' ');
        return s.charAt(0) + s.substring(1, s.length()).toLowerCase();
    }
}
