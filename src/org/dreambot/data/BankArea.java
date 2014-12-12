package org.dreambot.data;

import org.dreambot.api.methods.map.Area;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 11/13/13
 * Time: 11:05 PM
 */
public enum BankArea {

    DRAYNOR(new Area(3088, 3239, 3098, 3247, 0)),
    FALADOR_EAST(new Area(3008,3352,3019,3359, 0)),
    AL_KHARID(new Area(3268, 3161, 3273, 3174, 0)),
    EDGEVILLE(new Area(3090,3488,3100,3500, 0)),
    CATHERBY(new Area(2805,3433,2816,3446, 0)),
    CATHERBY_SHOP(new Area(2831,3441,2837,3447, 0)),
    FISHING_GUILD(new Area(2584,3419,2587,3422, 0)),
    SHILO_VILLAGE(new Area(2845,2950,2860,2960, 0)),
    PICATORIS(new Area(2320,3680,2320,3700, 0)),
    BARBARIAN_FISHING(new Area(2500,3487,2503,3491, 0)),
    ARDOUGNE(new Area(2610,3325,2625,3335, 0)),
    JATIZSO(new Area(2410,3795,2420,3805, 0)),
    RELLEKKA_SHOPS(new Area(2630,3670,2640,3685, 0)),
    BARBARIAN_OUTPOST(new Area(2525,3555,2540,3580, 0)),
    SEERS(new Area(2720,3490,2730,3500, 0));

    private Area area;

    public Area getArea() {
        return area;
    }

    private BankArea(Area area) {
        this.area = area;
    }
}