package lesson3;

import java.util.Scanner;

public class LengtonAnt {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[][] TABLE = new String[6][6];
    private static final Ant ANT = new Ant();

    public static void main(String[] args) {
        initGame();
        tableView();
        initAntStartPosition();
        tableView();
        System.out.println(ANT);
        System.out.println("Please enter number of Ant next moves");
        int antMovesCount = numberAsk();
        int counter = 0;
        while (counter < antMovesCount) {
            antMoveController();
            if (!ANT.isGameStatus()) {
                break;
            }
            counter++;
            tableView();
            System.out.println(ANT);
        }
    }

    public static void antMoveController() {
        String lookingOn = ANT.getLookingOn();
        String typeOfField = ANT.getTypeOfField();
        int vertical = ANT.getVertical();
        int horizontal = ANT.getHorizontal();
        String turnUp = "Up";
        String turnDown = "Down";
        String turnLeft = "Left";
        String turnRight = "Right";
        try {
            if (typeOfField.equals("B")) {
                TABLE[vertical][horizontal] = "W";
                switch (lookingOn) {
                    case ("Up"): {
                        horizontal--;
                        antDetailsChange(vertical, horizontal, turnLeft);
                        break;
                    }
                    case ("Down"): {
                        horizontal++;
                        antDetailsChange(vertical, horizontal, turnRight);
                        break;
                    }
                    case ("Right"): {
                        vertical--;
                        antDetailsChange(vertical, horizontal, turnUp);
                        break;
                    }
                    case ("Left"): {
                        vertical++;
                        antDetailsChange(vertical, horizontal, turnDown);
                        break;
                    }
                }
            }
            if (typeOfField.equals("W")) {
                TABLE[vertical][horizontal] = "B";
                switch (lookingOn) {
                    case ("Up"): {
                        horizontal++;
                        antDetailsChange(vertical, horizontal, turnRight);
                        break;
                    }
                    case ("Down"): {
                        horizontal--;
                        antDetailsChange(vertical, horizontal, turnLeft);
                        break;
                    }
                    case ("Right"): {
                        vertical++;
                        antDetailsChange(vertical, horizontal, turnDown);
                        break;
                    }
                    case ("Left"): {
                        vertical--;
                        antDetailsChange(vertical, horizontal, turnUp);
                        break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("GAME OVER! \n(Ant leave the table)");
            ANT.setGameStatus(false);
        }
    }

    private static void antDetailsChange(int vertical, int horizontal, String lookingOn) {
        ANT.setTypeOfField(TABLE[vertical][horizontal]);
        TABLE[vertical][horizontal] = "*";
        ANT.setAntPosition(vertical, horizontal);
        ANT.setLookingOn(lookingOn);
    }

    private static void initGame() {
        System.out.println("NEW GAME IS STARTED! \n");
        for (int i = 0; i < TABLE.length; i++) {
            for (int j = 0; j < TABLE[0].length; j++) {
                TABLE[i][j] = randomField();
            }
        }
    }

    private static void initAntStartPosition() {
        String antMark = "*";
        int vertical = -1;
        while (vertical < 0 || vertical > TABLE.length - 1) {
            System.out.println("Choose Ant vertical position from 0 to " + (TABLE.length - 1) + ":");
            vertical = numberAsk();
        }
        int horizontal = -1;
        while (horizontal < 0 || horizontal > TABLE[0].length - 1) {
            System.out.println("Choose Ant horizontal position from 0 to " + (TABLE[0].length - 1 + ":"));
            horizontal = numberAsk();
        }
        ANT.setTypeOfField(TABLE[vertical][horizontal]);
        TABLE[vertical][horizontal] = antMark;
        ANT.setAntPosition(vertical, horizontal);
    }

    private static String randomField() {
        if (Math.random() > 0.5) {
            return "W";
        } else {
            return "B";
        }
    }

    private static void tableView() {
        for (int i = 0; i < TABLE.length; i++) {
            for (int j = 0; j < TABLE[0].length; j++) {
                System.out.print(TABLE[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int numberAsk() {
        while (!SCANNER.hasNextInt()) {
            SCANNER.next();
            System.out.println("Its not a number. Try again");
        }
        System.out.println();
        return SCANNER.nextInt();
    }

    private static class Ant {
        private int vertical;
        private int horizontal;
        private String lookingOn = "Up";
        private String typeOfField;
        private boolean gameStatus = true;

        public int getVertical() {
            return vertical;
        }

        public int getHorizontal() {
            return horizontal;
        }

        public void setAntPosition(int vertical, int horizontal) {
            this.vertical = vertical;
            this.horizontal = horizontal;
        }

        public String getLookingOn() {
            return lookingOn;
        }

        public void setLookingOn(String lookingOn) {
            this.lookingOn = lookingOn;
        }

        public void setTypeOfField(String typeOfField) {
            this.typeOfField = typeOfField;
        }

        public String getTypeOfField() {
            return typeOfField;
        }

        public void setGameStatus(boolean gameStatus) {
            this.gameStatus = gameStatus;
        }

        public boolean isGameStatus() {
            return gameStatus;
        }

        public String toString() {
            return "Current Ant position: [" + vertical + ", " + horizontal + "]  (vertical, horizontal)\n" +
                    "Ant stay on field: " + typeOfField + "\n" +
                    "Ant looking on: " + lookingOn + "\n" +
                    "------------------------------\n";
        }
    }
}