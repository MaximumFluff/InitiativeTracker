package InitiativeTracker;

import java.util.Comparator;

public class Creature implements Comparable<Creature>
{
    private int health, initiative, ac;
    private String name;
    private boolean isPlayer;

    public Creature() {};

    public Creature(String name, int health, int ac, int initiative, boolean isPlayer)
    {
        this.name = name;
        this.health = health;
        this.initiative = initiative;
        this.ac = ac;
        this.isPlayer = isPlayer;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    @Override
    public int compareTo(Creature p1)
    {
        return this.initiative - p1.initiative;
    }

    // TODO improve this shit
    @Override
    public String toString() {
        return
                name + ", Initiative: " + initiative + ", hit points: " + health;
    }
}

// Used this link to help implement sorting method: https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property