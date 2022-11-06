package model;

import java.time.Duration;

/**
 *
 */
public abstract class Audio {
    private String name;
    private String duration;
    private int numberReproductions;

    /**
     *
     * @param name
     * @param duration
     */
    public Audio(String name, String duration) {
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
        return "Audio{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", numberReproductions=" + numberReproductions +
                '}';
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
     *
     * @return
     */
    public String getDuration() {
        return duration;
    }

    /***
     *
     * @param duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

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
