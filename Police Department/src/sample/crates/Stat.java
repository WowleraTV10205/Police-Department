package sample.crates;

public class Stat {
    String Badge, Surname, Post , Intruders, Patrols;

    public Stat(String badge, String surname, String post, String intruders, String patrols) {
        Badge = badge;
        Surname = surname;
        Post = post;
        Intruders = intruders;
        Patrols = patrols;
    }

    public String getBadge() {
        return Badge;
    }

    public void setBadge(String badge) {
        Badge = badge;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getIntruders() {
        return Intruders;
    }

    public void setIntruders(String intruders) {
        Intruders = intruders;
    }

    public String getPatrols() {
        return Patrols;
    }

    public void setPatrols(String patrols) {
        Patrols = patrols;
    }
}
