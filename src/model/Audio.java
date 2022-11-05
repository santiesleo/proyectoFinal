package model;

import java.time.Duration;

public abstract class Audio {
    private String name;
    private String duration;
    private int numberReproductions;

    public Audio(String name, String duration) {
        this.name = name;
        this.duration = duration;
        numberReproductions = 0;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", numberReproductions=" + numberReproductions +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getNumberReproductions() {
        return numberReproductions;
    }

    public void setNumberReproductions(int numberReproductions) {
        this.numberReproductions = numberReproductions;
    }
}
