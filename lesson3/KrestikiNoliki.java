package lesson3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class KrestikiNoliki {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[][] GAME_FIELD = new String[3][3];
    private static final HashSet<Integer> POSSIBLE_MOVES_LIST = new HashSet<>();

    public static void main(String[] args) {
        boolean playerTurn = Math.random() > 0.5;
        boolean winnerStatus = false;
        initGame();
        gameStatusView();
        while (!winnerStatus) {
            gameController(playerMove(playerTurn), playerTurn);
            gameStatusView();
            winnerStatus = winCheck();
            playerTurn = !playerTurn;
            if (isPossibleMovesListEmpty()) {
                break;
            }
        }
        winAnnouncer(playerTurn, winnerStatus);
    }

    private static void gameController(int playerMove, boolean playerTurn) {
        String playerType;
        if (playerTurn) {
            playerType = "o";
        } else {
            playerType = "x";
        }
        for (int i = 0; i < GAME_FIELD.length; i++) {
            for (int j = 0; j < GAME_FIELD[0].length; j++) {
                if (GAME_FIELD[i][j].equals(String.valueOf(playerMove))) {
                    GAME_FIELD[i][j] = playerType;
                }
            }
        }
    }

    private static int playerMove(boolean playerTurn) {
        if (playerTurn) {
            System.out.println("Player 'O' choose number of your move.");
        } else {
            System.out.println("Player 'X' choose number of your move.");
        }
        int playerMove = numberAsk();
        while (!isPossibleMove(playerMove)) {
            System.out.println("Bad move, bro! Choose another one");
            playerMove = numberAsk();
        }
        return playerMove;
    }

    private static void initGame() {
        String fields = "123456789";
        int counter = 0;
        for (int i = 0; i < GAME_FIELD.length; i++) {
            for (int j = 0; j < GAME_FIELD[0].length; j++) {
                GAME_FIELD[i][j] = Character.toString(fields.charAt(counter));
                counter++;
            }
        }
        POSSIBLE_MOVES_LIST.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("GAME IS STARTED!");
    }

    private static void gameStatusView() {
        System.out.println();
        for (int i = 0; i < GAME_FIELD.length; i++) {
            for (int j = 0; j < GAME_FIELD[0].length; j++) {
                System.out.print(GAME_FIELD[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isPossibleMove(int playerMove) {
        if (POSSIBLE_MOVES_LIST.contains(playerMove)) {
            POSSIBLE_MOVES_LIST.remove(playerMove);
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPossibleMovesListEmpty() {
        return POSSIBLE_MOVES_LIST.isEmpty();
    }

    private static void winAnnouncer(boolean playerTurn, boolean winnerStatus) {
        if (winnerStatus) {
            if (playerTurn) {
                System.out.println("Congratulations! Player 'X' won!");
            } else {
                System.out.println("Congratulations! Player 'O' won!");
            }
        } else {
            System.out.println("Gentlemen, its a draw!");
        }
    }

    private static boolean winCheck() {
        for (int i = 0; i < 3; i++) {
            if (GAME_FIELD[i][0].equals(GAME_FIELD[i][1]) && GAME_FIELD[i][0].equals(GAME_FIELD[i][2]) ||
                    (GAME_FIELD[0][i].equals(GAME_FIELD[1][i]) && (GAME_FIELD[0][i].equals(GAME_FIELD[2][i])))) {
                return true;
            }
        }
        return GAME_FIELD[0][0].equals(GAME_FIELD[1][1]) && GAME_FIELD[1][1].equals(GAME_FIELD[2][2]) ||
                GAME_FIELD[2][0].equals(GAME_FIELD[1][1]) && GAME_FIELD[1][1].equals(GAME_FIELD[0][2]);
    }

    private static int numberAsk() {
        while (!SCANNER.hasNextInt()) {
            SCANNER.next();
            System.out.println("Its not a number. Try again");
        }
        return SCANNER.nextInt();
    }
}