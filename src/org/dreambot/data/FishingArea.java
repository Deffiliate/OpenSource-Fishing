package org.dreambot.data;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/11/2014
 * Time: 9:23 PM
 */
public enum FishingArea {

    DRAYNOR_VILLAGE(new Area(
            new Tile(3083, 3235, 0),
            new Tile(3088, 3239, 0),
            new Tile(3094, 3233, 0),
            new Tile(3094, 3224, 0),
            new Tile(3088, 3216, 0),
            new Tile(3085, 3221, 0),
            new Tile(3086, 3225, 0),
            new Tile(3085, 3230, 0)
    ));

    private Area area;

    public Area getArea() {
        return area;
    }

    private FishingArea (Area area) {
        this.area = area;
    }
}
