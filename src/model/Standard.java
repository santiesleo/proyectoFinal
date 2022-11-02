package model;

public class Standard extends Consumer{
    private Playlist[] playlists;
    private Audio[] audios;

    public Standard(String nickname, String id, String name) {
        super(nickname, id, name);
        playlists = new Playlist[20];
        audios = new Audio[100];
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    public Audio[] getAudios() {
        return audios;
    }

    public void setAudios(Audio[] audios) {
        this.audios = audios;
    }
}
