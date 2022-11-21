package model;

import java.time.LocalDate;

/**
 * The User class
 */
public abstract class User {
    private String nickname;
    private String id;
    private LocalDate bindingDate;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class user.<br>
     */
    public User(String nickname, String id) {
        this.nickname = nickname;
        this.id = id;
        bindingDate = LocalDate.now();
    }

    /**
     * The attributes of the class user
     */
    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", id='" + id + '\'' +
                ", bindingDate=" + bindingDate +
                '}';
    }

    /**
     *
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname The nickname of the class user
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return identifier
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id The identifier of tha class user
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return blinding date
     */
    public LocalDate getBindingDate() {
        return bindingDate;
    }

    /**
     *
     * @param bindingDate The blinding date of the class user
     */
    public void setBindingDate(LocalDate bindingDate) {
        this.bindingDate = bindingDate;
    }
}
