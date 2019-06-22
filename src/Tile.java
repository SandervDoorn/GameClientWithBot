import java.util.Objects;

public class Tile {
    private Player owner;
    private int position;

    Tile(int position) {
        owner = null;
        this.position = position;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPosition() {
        return position;
    }

    public String getPlayerIcon() {
        return owner != null ? owner.getIcon() : " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return position == tile.position &&
                Objects.equals(owner, tile.owner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(owner, position);
    }
}
