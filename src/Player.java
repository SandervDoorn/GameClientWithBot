import java.util.Objects;

public class Player {

    private String name;
    private String icon;

    Player(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(icon, player.icon);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, icon);
    }
}
