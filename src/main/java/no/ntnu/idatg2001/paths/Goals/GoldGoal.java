package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

import java.util.List;

public class GoldGoal implements Goal{

    private int minimumGold;

    public int goldGoal(int minimumGold){
        return minimumGold;
    }

    @Override
    public boolean isFullfilled(Player player) {
        return false;
    }
}
