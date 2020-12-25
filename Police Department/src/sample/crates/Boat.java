package sample.crates;

public class Boat {
    String Boat_Num, Mark, Engine_Num, Color, Recorder;

    public Boat(String boat_Num, String mark, String engine_Num, String color, String recorder) {
        Boat_Num = boat_Num;
        Mark = mark;
        Engine_Num = engine_Num;
        Color = color;
        Recorder = recorder;
    }

    public String getBoat_Num() {
        return Boat_Num;
    }

    public void setBoat_Num(String boat_Num) {
        Boat_Num = boat_Num;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public String getEngine_Num() {
        return Engine_Num;
    }

    public void setEngine_Num(String engine_Num) {
        Engine_Num = engine_Num;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getRecorder() {
        return Recorder;
    }

    public void setRecorder(String recorder) {
        Recorder = recorder;
    }
}
