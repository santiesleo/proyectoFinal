package model;

import java.time.LocalDate;

/**
 *
 */
public abstract class User {
    private String nickname;
    private String id;
    private LocalDate bindingDate;

    public User(String nickname, String id) {
        this.nickname = nickname;
        this.id = id;
        bindingDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", id='" + id + '\'' +
                ", bindingDate=" + bindingDate +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getBindingDate() {
        return bindingDate;
    }

    public void setBindingDate(LocalDate bindingDate) {
        this.bindingDate = bindingDate;
    }
}
