package lesson3;

import java.util.*;

public class KrestikiNolikiVsComp {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[][] GAME_FIELD = new String[3][3];
    private static final HashSet<String> POSSIBLE_MOVES_LIST = new HashSet<>();

    public static void main(String[] args) {
        boolean winnerStatus = false;
        boolean playerTurn = Math.random() > 0.5;
        initGame(GAME_FIELD, POSSIBLE_MOVES_LIST);
        gameTableView(GAME_FIELD);
        while (!winnerStatus) {
            gameController(GAME_FIELD, playerMove(GAME_FIELD, playerTurn, POSSIBLE_MOVES_LIST), playerTurn);
            gameTableView(GAME_FIELD);
            playerTurn = !playerTurn;
            winnerStatus = winCheck(GAME_FIELD);
            if (isPossibleMovesListEmpty(POSSIBLE_MOVES_LIST)) {
                break;
            }
        }
        winAnnouncer(playerTurn, winnerStatus);
    }

    private static void gameController(String[][] gameField, String playerMove, boolean playerTurn) {
        String playerType;
        if (playerTurn) {
            playerType = "o";
        } else {
            playerType = "x";
        }
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (gameField[i][j].equals(playerMove)) {
                    gameField[i][j] = playerType;
                }
            }
        }
    }

    private static String playerMove(String[][] gameField, boolean playerTurn, HashSet possibleMovesList) {
        String move;
        if (playerTurn) {
            System.out.println("Player 'O'\nChoose number of your move:");
            move = numberAsk();
        } else {
            move = compMove(gameField, possibleMovesList);
            System.out.println("Computer 'X'\nComp move is: " + move);
        }
        while (!isPossibleMove(possibleMovesList, move)) {
            System.out.println("Bad move, bro! Choose another one");
            move = numberAsk();
        }
        return move;
    }

    private static boolean isPossibleMove(HashSet possibleMovesList, String playerMove) {
        if (possibleMovesList.contains(playerMove)) {
            possibleMovesList.remove(playerMove);
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPossibleMovesListEmpty(HashSet possibleMovesList) {
        return possibleMovesList.isEmpty();
    }

    private static String compMove(String[][] gameField, HashSet possibleMovesList) {
        String move;
        if (possibleMovesList.contains("5")) {
            move = "5";
        } else {
            if (!compMoveHorizontalAnalyzer(gameField).equals("not find")) {
                return compMoveHorizontalAnalyzer(gameField);
            }
            if (!compMoveVerticalAnalyzer(gameField).equals("not find")) {
                return compMoveVerticalAnalyzer(gameField);
            }
            if (!compMoveDiagonalAnalyzer(gameField).equals("not find")) {
                return compMoveDiagonalAnalyzer(gameField);
            } else {
                return compRandomMove(possibleMovesList);
            }
        }
        return move;
    }

    private static String compRandomMove(HashSet possibleMovesList) {
        List<String> moves = new ArrayList<>(possibleMovesList);
        return moves.get((int) (Math.random() * (possibleMovesList.size() - 1)));
    }

    private static String compMoveHorizontalAnalyzer(String[][] gameField) {
        String bestMove = "not find";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                if (gameField[i][j].equals(gameField[i][j + 1]) && isEmpty(gameField[i][j + 2])) {
                    bestMove = gameField[i][j + 2];
                    if (gameField[i][j].equals("x")) {
                        return bestMove;
                    }
                }
                if (gameField[i][j + 1].equals(gameField[i][j + 2]) && isEmpty(gameField[i][j])) {
                    bestMove = gameField[i][j];
                    if (gameField[i][j + 1].equals("x")) {
                        return bestMove;
                    }
                }
                if (gameField[i][j].equals(gameField[i][j + 2]) && isEmpty(gameField[i][j + 1])) {
                    bestMove = gameField[i][j + 1];
                    if (gameField[i][j].equals("x")) {
                        return bestMove;
                    }
                }
            }
        }
        return bestMove;
    }

    private static String compMoveVerticalAnalyzer(String[][] gameField) {
        String bestMove = "not find";
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField[i][j].equals(gameField[i + 1][j]) && isEmpty(gameField[i + 2][j])) {
                    bestMove = gameField[i + 2][j];
                    if (gameField[i][j].equals("x")) {
                        return bestMove;
                    }
                }
                if (gameField[i][j].equals(gameField[i + 2][j]) && isEmpty(gameField[i + 1][j])) {
                    bestMove = gameField[i + 1][j];
                    if (gameField[i][j].equals("x")) {
                        return bestMove;
                    }
                }
                if (gameField[i + 1][j].equals(gameField[i + 2][j]) && isEmpty(gameField[i][j])) {
                    bestMove = gameField[i][j];
                    if (gameField[i + 1][j].equals("x")) {
                        return bestMove;
                    }
                }
            }
        }
        return bestMove;
    }

    private static String compMoveDiagonalAnalyzer(String[][] gameField) {
        String bestMove = "not find";
        for (int i = 0; i < 1; i++) {
            if (gameField[i][0].equals(gameField[i + 1][1]) && isEmpty(gameField[i + 2][2])) {
                bestMove = gameField[i + 2][2];
            }
            if (gameField[i][0].equals(gameField[i + 2][2]) && isEmpty(gameField[i + 1][1])) {
                bestMove = gameField[i + 1][1];
            }
            if (gameField[i + 1][1].equals(gameField[i + 2][2]) && isEmpty(gameField[i][0])) {
                bestMove = gameField[i][0];
            }
            if (gameField[i + 2][0].equals(gameField[i + 1][1]) && isEmpty(gameField[i][2])) {
                bestMove = gameField[i][2];
            }
            if (gameField[i + 2][0].equals(gameField[i][2]) && !isEmpty(gameField[i + 1][1])) {
                bestMove = gameField[i + 1][1];
            }
            if (gameField[i + 1][1].equals(gameField[i][2]) && isEmpty(gameField[i + 2][0])) {
                bestMove = gameField[i + 2][0];
            }
        }
        return bestMove;
    }

    private static boolean isEmpty(String field) {
        return !field.equals("o") && !field.equals("x");
    }

    private static void winAnnouncer(boolean playerTurn, boolean winnerStatus) {
        if (winnerStatus) {
            if (playerTurn) {
                System.out.println("Game Over!\nComputer 'X' won!");
            } else {
                System.out.println("Congratulations! Player 'O' won!");
            }
        } else {
            System.out.println("Gentlemen, its a draw!");
        }
    }

    private static boolean winCheck(String[][] gameField) {
        for (int i = 0; i < 3; i++) {
            if (GAME_FIELD[i][0].equals(GAME_FIELD[i][1]) && GAME_FIELD[i][0].equals(GAME_FIELD[i][2]) ||
                    (GAME_FIELD[0][i].equals(GAME_FIELD[1][i]) && (GAME_FIELD[0][i].equals(GAME_FIELD[2][i])))) {
                return true;
            }
        }
        return GAME_FIELD[0][0].equals(GAME_FIELD[1][1]) && GAME_FIELD[1][1].equals(GAME_FIELD[2][2]) ||
                GAME_FIELD[2][0].equals(GAME_FIELD[1][1]) && GAME_FIELD[1][1].equals(GAME_FIELD[0][2]);
    }

    private static void initGame(String[][] gameField, HashSet possibleMovesList) {
        String fields = "123456789";
        int counter = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                gameField[i][j] = Character.toString(fields.charAt(counter));
                counter++;
            }
        }
        possibleMovesList.addAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        System.out.println("GAME IS STARTED!\n");
    }

    private static void gameTableView(String[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                System.out.print(gameField[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static String numberAsk() {
        return SCANNER.next();
    }
}