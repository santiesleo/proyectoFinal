package model;

public class Song extends Audio{
    private String album;
    private String albumCover;
    private int salesNumber;
    private double price;
    private Genre typeGenre;

    public Song(String name, String duration, String album, String albumCover, double price, int option) {
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getTypeGenre() {
        return typeGenre;
    }

    public void setTypeGenre(Genre typeGenre) {
        this.typeGenre = typeGenre;
    }
}
