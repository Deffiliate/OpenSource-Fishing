package org.dreambot.data;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 11/14/13
 * Time: 5:31 PM
 */
public enum FishType {

    RAW_SHRIMPS,
    RAW_HERRING,
    RAW_MACKEREL,
    RAW_SARDINES,
    RAW_BASS,
    RAW_LOBSTER,
    RAW_TUNA,
    RAW_TROUT,
    RAW_SWORDFISH,
    RAW_SHARK,
    RAW_MONKFISH,
    SEAWEED,
    RAW_COD,
    CASKET,
    OYSTER,
    RAW_PIKE,
    RAW_SALMON,
    RAW_ANCHOVIES,
    LEAPING_TROUT,
    LEAPING_STURGEON,
    LEAPING_SALMON;

    @Override
    public String toString() {
        final String s = super.toString().replace('_', ' ');
        return s.charAt(0) + s.substring(1,s.length()).toLowerCase();
    }
}
