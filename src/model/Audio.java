package model;

/**
 * The Audio class
 */
public abstract class Audio {
    private String name;
    private int duration;
    private int numberReproductions;
    private int numberSales;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Audio.<br>
     */
    public Audio(String name, int duration) {
        this.name = name;
        this.duration = duration;
        numberReproductions = 0;
        setNumberSales(0);
    }

    /**
     *
     * @return The attributes of the playlist
     */
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", numberReproductions=" + numberReproductions;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name of the playlist
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /***
     *
     * @param duration The duration of the playlist
     */
    public void setDuration(int duration) {this.duration = duration;}

    /**
     *
     * @return numer reproductions
     */
    public int getNumberReproductions() {
        return numberReproductions;
    }

    /**
     *
     * @param numberReproductions The number of reproductions of the playlist
     */
    public void setNumberReproductions(int numberReproductions) {
        this.numberReproductions = numberReproductions;
    }

    /**
     *
     * @return number sales
     */
    public int getNumberSales() {
        return numberSales;
    }

    /**
     *
     * @param numberSales Number of sales
     */
    public void setNumberSales(int numberSales) {
        this.numberSales = numberSales;
    }
}
