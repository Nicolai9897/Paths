package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

public class HealthGoal implements Goal {

    private int minimumHealth;

    public int healthGoal(int minimumHealth){
        return minimumHealth;
    }
    @Override
    public boolean isFullfilled(Player player) {
        return false;
    }
}
