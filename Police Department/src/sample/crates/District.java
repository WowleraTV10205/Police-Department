package sample.crates;

public class District {
    String ID, Name, Priority, Enter_Coordinates, Exit_Coordinates;

    public District(String ID, String name, String priority, String enter, String exit) {
        this.ID = ID;
        Name = name;
        Priority = priority;
        Enter_Coordinates = enter;
        Exit_Coordinates = exit;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getEnter_Coordinates() {
        return Enter_Coordinates;
    }

    public void setEnter(String enter) {
        Enter_Coordinates = enter;
    }

    public String getExit_Coordinates() {
        return Exit_Coordinates;
    }

    public void setExit_Coordinates(String exit) {
        Exit_Coordinates = exit;
    }
}


