import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Player player1 = new Player("Sander", "S");
        Player player2 = new Player("Edwin", "E");
        Game game = new Game(new TicTacToeBoard(player1, player2), player1, player2);

        try (Scanner scanner = new Scanner(System.in)) {
            while (!((TicTacToeBoard)game.getBoard()).tilesLeft() && !game.hasWinner()) {
                System.out.println(game.getBoard());
                System.out.println("It is " + game.getTurn().getName() + "'s turn");
                System.out.println("Select square: ");
                int input = scanner.nextInt();

                if (!game.getBoard().legalMove(input)) {
                    System.out.println("That move is not valid, try again!");
                    continue;
                }

                game.getBoard().makeMove(input, game.getTurn());
                game.swapTurn();
            }
        }

        if (game.hasWinner()) {
            System.out.println("VICTORY!");
            System.out.println("The winner is: " + game.getWinner().getName());
            System.out.println(game.getBoard());
        }
    }
}
