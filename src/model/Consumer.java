package model;

/**
 *
 */
public abstract class Consumer extends User{
    private String name;

    /**
     *
     * @param nickname
     * @param id
     * @param name
     */
    public Consumer(String nickname, String id, String name) {
        super(nickname, id);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                super.toString() +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
