public class Game {

    private AbstractBoard board;
    private Player turn;
    private Player player1;
    private Player player2;

    Game(AbstractBoard board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;

        this.turn = player1;
    }

    public void swapTurn() {
        if(turn.equals(player1)) {
            turn = player2;
        } else {
            turn = player1;
        }
    }

    public Player getTurn() {
        return turn;
    }

    public Player getWinner() {
        return board.getWinner();
    }

    public boolean hasWinner() {
        return board.getWinner() != null;
    }

    public AbstractBoard getBoard() {
        return board;
    }
}
