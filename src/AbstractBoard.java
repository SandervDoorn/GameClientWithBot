import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

abstract class AbstractBoard {
    private List<Tile> tiles = new ArrayList<>();
    private int width;
    private int length;

    AbstractBoard(int width, int length) {
        this.width = width;
        this.length = length;
        setup();
    }

    private void setup() {
        int size = width * length;
        for (int i = 0; i < size; i++) {
            tiles.add(new Tile(i));
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    private Tile findTileWithPosition(int position) {
        return tiles.stream()
                .filter(tile -> tile.getPosition() == position - 1)
                .findFirst()
                .orElse(null);
    }

    public abstract Player getWinner();


    public void makeMove(int position, Player player) {
        Tile tileToEdit = findTileWithPosition(position);
        tileToEdit.setOwner(player);
    }


    Tile checkDirectionForPlayer(Angle direction, int startPosition, Player player) {
        int factor = getDirectionFactor(direction);

        int i = 0;
        boolean samePlayer = true;
        Tile lastTile = null;

        while(samePlayer && (startPosition+factor*++i < tiles.size()-1 && startPosition+factor*i >= 0)) {
            if (tiles.get(startPosition + factor*i).getOwner() == null) {
                return null;
            }

            if (tiles.get(startPosition + factor*i).getOwner().equals(player)) {
                lastTile = tiles.get(startPosition + factor*i);
            }
            else {
                samePlayer = false;
            }
        }
        return lastTile;
    }

    private int getDirectionFactor(Angle direction) {
        switch (direction) {
            case N:
                return 0 - getWidth();
            case NE:
                //TODO: Get factor
            case E:
                return 1;
            case SE:
                //TODO: Get factor
            case S:
                return getWidth();
            case SW:
                //TODO: Get factor
            case W:
                return -1;
            case NW:
                //TODO: Get factor
        }
        return 0;
    }

    public boolean legalMove(int position) {
        Predicate<Tile> validTile = tile -> tile.getPosition() == position - 1
                && tile.getOwner() == null;

        return tiles.stream()
                .anyMatch(validTile);               //Check if position isn't already owned
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        int pos = 0;
        String board = "*********";
        for (int y = 0; y < length; y++) {
            board = board.concat("\n*");
            for (int x = 0; x < width; x++) {
                board = board.concat(tiles.get(pos++).getPlayerIcon() + "*");
            }
        }
        board = board.concat("\n*********\n");
        return board;
    }
}
