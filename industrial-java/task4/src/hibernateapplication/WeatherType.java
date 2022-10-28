package hibernateapplication;

public class WeatherType {

    private Integer id;
    private String name;

    public WeatherType() {
    }

    public WeatherType(String name) {
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
        return String.format("WeatherType [id=%s, name=%s]", id, name);
    }
}
