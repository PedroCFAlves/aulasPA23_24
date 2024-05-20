package pt.isec.pa.mosquito.model.data;

public class MosquitoData {
    private enum LandingZone {NONE, ANIMAL, OBJECT}
    private int numberMoves = 0;
    private int numberCrushAttempts = 0;
    private int numberBites = 0;
    private LandingZone landedOn = LandingZone.NONE;
    private boolean isDead = false;

    public int getNumberMoves() {
        return numberMoves;
    }

    public int getNumberCrushAttempts() {
        return numberCrushAttempts;
    }

    public int getNumberBites() {
        return numberBites;
    }

    public boolean isOnAnimal() {
        return landedOn == LandingZone.ANIMAL;
    }

    public boolean isOnObject() {
        return landedOn == LandingZone.OBJECT;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean tryToCrush() {
        numberCrushAttempts++;

        if (isDead)
            return true;

        isDead = Math.random()>=0.5;

        return isDead;
    }

    public void move() {
        if (isDead)
            return;

        numberMoves++;

        double r = Math.random();

        if (r <= .2)
            landedOn=LandingZone.ANIMAL;
        else if (r <= .5)
            landedOn=LandingZone.OBJECT;
        else
            landedOn=LandingZone.NONE;
    }

    public void bite() {
        if (isOnAnimal() && !isDead)
            numberBites++;
    }

    public boolean takeOff() {
        if (isDead)
            return false;
        landedOn=LandingZone.NONE;
        return true;
    }
}