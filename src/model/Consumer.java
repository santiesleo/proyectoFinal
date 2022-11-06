package model;

/**
 *
 */
public abstract class Consumer extends User{

    /**
     *
     * @param nickname
     * @param id
     */
    public Consumer(String nickname, String id) {
        super(nickname, id);
    }

    @Override
    public String toString() {
        return "Consumer{" +
                super.toString() +
                '}';
    }

}
