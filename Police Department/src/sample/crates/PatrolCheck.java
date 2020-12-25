package sample.crates;

public class PatrolCheck {
    String ID, Boat_Num, District, Start, Intruders;

    public PatrolCheck(String ID, String boat_Num, String district, String start, String intruders) {
        this.ID = ID;
        Boat_Num = boat_Num;
        District = district;
        Start = start;
        Intruders = intruders;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBoat_Num() {
        return Boat_Num;
    }

    public void setBoat_Num(String boat_Num) {
        Boat_Num = boat_Num;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getIntruders() {
        return Intruders;
    }

    public void setIntruders(String intruders) {
        Intruders = intruders;
    }
}
