package model;

public class Consumer extends User{
    private String name;

    public Consumer(String nickname, String id, String name) {
        super(nickname, id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
