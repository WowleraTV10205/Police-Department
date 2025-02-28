package sample.crates;

public class Patrol {
    String Boat_Num, District, Start, Intruders, Loss, Reward;

    public Patrol(String boat_Num, String district, String start, String intruders, String loss, String reward) {
        Boat_Num = boat_Num;
        District = district;
        Start = start;
        Intruders = intruders;
        Loss = loss;
        Reward = reward;
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

    public String getLoss() {
        return Loss;
    }

    public void setLoss(String loss) {
        Loss = loss;
    }

    public String getReward() {
        return Reward;
    }

    public void setReward(String reward) {
        Reward = reward;
    }
}
