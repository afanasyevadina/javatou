package hibernateapplication;

public class WindDirection {

    private Integer id;
    private String name;

    public WindDirection() {
    }

    public WindDirection(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("WindDirection [id=%s, name=%s]", id, name);
    }
}
