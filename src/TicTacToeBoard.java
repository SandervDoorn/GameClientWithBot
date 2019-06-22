public class TicTacToeBoard extends AbstractBoard {

    private Player player1;
    private Player player2;

    //TODO: Work with interfaces for players and move makeMove to there
    //TODO: Refactor so that players get the gamestate in their constructor

    TicTacToeBoard(Player player1, Player player2) {
        super(3, 3);
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean tilesLeft() {
        return getTiles().stream()
                .allMatch(tile -> tile.getOwner() != null);
    }

    @Override
    public Player getWinner() {
        // Returns Player object of the winner if it is found, null if no winner is found
        if (checkHorizontal() != null) {
            return checkHorizontal();
        }

        if (checkVertical() != null) {
            return checkVertical();
        }

        return null;
    }

    private Player checkVertical() {
        for (int i = 0; i < getWidth(); i++) {
            Tile tile = checkDirectionForPlayer(Angle.S, i, player1);
            if (tile != null && tile.getPosition() == i * getLength() + 6)
                return player1;

            tile = checkDirectionForPlayer(Angle.S, i, player2);
            if (tile != null && tile.getPosition() == i * getLength() + 6)
                return player2;
        }
        return null;
    }

    private Player checkHorizontal() {
        for (int i = 0; i < getLength(); i++) {
            Tile tile = checkDirectionForPlayer(Angle.E, i * getWidth(), player1);
            if (tile != null && tile.getPosition() == i * getWidth() + 2)
                return player1;

            tile = checkDirectionForPlayer(Angle.E, i * getWidth(), player2);
            if (tile != null && tile.getPosition() == i * getWidth() + 2)
                return player2;
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
