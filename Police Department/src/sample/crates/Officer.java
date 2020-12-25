package sample.crates;

public class Officer {
    String Badge, Surname, Post, Enrolment, Birthday, Password;


    public Officer(String badge, String surname, String post, String enrolment, String birthday, String password) {
        Badge = badge;
        Surname = surname;
        Post = post;
        Enrolment = enrolment;
        Birthday = birthday;
        Password = password;
    }

    public Officer() {

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

    public String getEnrolment() {
        return Enrolment;
    }

    public void setEnrolment(String enrolment) {
        Enrolment = enrolment;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
