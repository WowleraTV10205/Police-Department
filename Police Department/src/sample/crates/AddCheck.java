package sample.crates;

public class AddCheck {
    String Badge, Patrol_ID;

    public AddCheck(String badge, String patrol_ID) {
        Badge = badge;
        Patrol_ID = patrol_ID;
    }

    public String getBadge() {
        return Badge;
    }

    public void setBadge(String badge) {
        Badge = badge;
    }

    public String getPatrol_ID() {
        return Patrol_ID;
    }

    public void setPatrol_ID(String patrol_ID) {
        Patrol_ID = patrol_ID;
    }
}
