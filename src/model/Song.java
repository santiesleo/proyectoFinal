package model;

/**
 *
 */
public class Song extends Audio{
    private String album;
    private String albumCover;
    private int salesNumber;
    private double price;
    private Genre typeGenre;

    /**
     *
     * @param name
     * @param duration
     * @param album
     * @param albumCover
     * @param price
     * @param option
     */
    public Song(String name, int duration, String album, String albumCover, double price, int option) {
        super(name, duration);
        this.album = album;
        this.albumCover = albumCover;
        salesNumber = 0;
        this.price = price;
        switch (option) {
            case 1:
                typeGenre = Genre.ROCK;
                break;
            case 2:
                typeGenre = Genre.POP;
                break;
            case 3:
                typeGenre = Genre.TRAP;
                break;
            case 4:
                typeGenre = Genre.HOUSE;
                break;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Song{" +
                super.toString() +
                "album='" + album + '\'' +
                ", albumCover='" + albumCover + '\'' +
                ", salesNumber=" + salesNumber +
                ", price=" + price +
                ", typeGenre=" + typeGenre +
                '}';
    }

    /**
     *
     * @return
     */
    public String getAlbum() {
        return album;
    }

    /**
     *
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     *
     * @return
     */
    public String getAlbumCover() {
        return albumCover;
    }

    /**
     *
     * @param albumCover
     */
    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    /**
     *
     * @return
     */
    public int getSalesNumber() {
        return salesNumber;
    }

    /**
     *
     * @param salesNumber
     */
    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public Genre getTypeGenre() {
        return typeGenre;
    }

    /**
     *
     * @param typeGenre
     */
    public void setTypeGenre(Genre typeGenre) {
        this.typeGenre = typeGenre;
    }
}
