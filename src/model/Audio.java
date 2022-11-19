package model;

/**
 *
 */
public abstract class Audio {
    private String name;
    private int duration;
    private int numberReproductions;

    /**
     *
     * @param name
     * @param duration
     */
    public Audio(String name, int duration) {
        this.name = name;
        this.duration = duration;
        numberReproductions = 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", numberReproductions=" + numberReproductions;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /***
     *
     * @param duration
     */
    public void setDuration(int duration) {this.duration = duration;}

    /**
     *
     * @return
     */
    public int getNumberReproductions() {
        return numberReproductions;
    }

    /**
     *
     * @param numberReproductions
     */
    public void setNumberReproductions(int numberReproductions) {
        this.numberReproductions = numberReproductions;
    }
}
