package lesson7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Squirrel {
    private static final String PATH = "D:\\git\\github-homework\\lesson7\\journalEvents_ru.csv";
    private static final int ROW_COUNT = fileLength(PATH);
    private static final String[][] actions = new String[ROW_COUNT][];
    private static final boolean[] squirrel = new boolean[ROW_COUNT];

    public static void main(String[] args) {
        csvToArrays();
        String[] allActionsInOneArray = new String[totalActionsSum()];
        allRowsToOneArray(allActionsInOneArray);
        String[] uniqueActions = deleteDuplicates(allActionsInOneArray);
        String[] combinedAction = minMaxActionsFinder(uniqueActions);
        int[] combinedActionStat = addCombinedStats(combinedAction);
        resultEvent(combinedAction, combinedActionStat);
    }

    public static String[] minMaxActionsFinder(String[] uniqueActions) {
        DecimalFormat dF = new DecimalFormat("#.#########");
        System.out.println("Для корреляции > 0.1 или < -0.1");
        double min = 0;
        double max = 0;
        String actionMin = null;
        String actionMax = null;
        double result;
        for (String uniqueAction : uniqueActions) {
            int[] actionStats = addSimpleStats(uniqueAction);
            result = correlationFormula(actionStats);
            if (result > 0.1 || result < -0.1) {
                System.out.println(uniqueAction + " :" + dF.format(result));
                if (result > max) {
                    max = result;
                    actionMax = uniqueAction;
                }
                if (result < min) {
                    min = result;
                    actionMin = uniqueAction;
                }
            }
        }
        return new String[]{actionMax, actionMin};
    }

    public static int[] addCombinedStats(String[] action) {
        int[] actionStat = new int[4];
        for (int i = 0; i < actions.length; i++) {
            if (!isAction(action[0], actions[i]) && (isAction(action[1], actions[i]) && squirrel[i])) {
                actionStat[2]++;
            }
            if (isAction(action[0], actions[i]) && !isAction(action[1], actions[i]) && squirrel[i]) {
                actionStat[3]++;
            } else if (isAction(action[0], actions[i]) && !isAction(action[1], actions[i])) {
                actionStat[1]++;
            }
        }
        actionStat[0] = actions.length - actionStat[1] - actionStat[2] - actionStat[3];
        return actionStat;
    }

    public static int[] addSimpleStats(String action) {
        int[] actionStat = new int[4];
        for (int i = 0; i < actions.length; i++) {
            if (!isAction(action, actions[i]) && squirrel[i]) {
                actionStat[2]++;
            }
            if (isAction(action, actions[i]) && (squirrel[i])) {
                actionStat[3]++;
            } else if (isAction(action, actions[i])) {
                actionStat[1]++;
            }
        }
        actionStat[0] = actions.length - actionStat[1] - actionStat[2] - actionStat[3];
        return actionStat;
    }

    public static double correlationFormula(int[] actionStat) {
        double upper = actionStat[3] * actionStat[0] - actionStat[2] * actionStat[1];
        double lower = Math.sqrt((actionStat[2] + actionStat[3]) * (actionStat[0] + actionStat[1])
                * (actionStat[1] + actionStat[3]) * (actionStat[0] + actionStat[2]));
        return upper / lower;
    }

    public static void resultEvent(String[] combinedAction, int[] combinedActionStat) {
        DecimalFormat dFF = new DecimalFormat("#.000000000");
        System.out.println("\nДля нового события");
        String[] actionOne = combinedAction[0].split(" ");
        String[] actionTwo = combinedAction[1].split(" ");
        System.out.println(actionOne[actionOne.length - 1] + "-" + actionTwo[actionTwo.length - 1]
                + " :" + dFF.format(correlationFormula(combinedActionStat)));
    }

    public static boolean isAction(String action, String[] actions) {
        boolean bool = false;
        for (String s : actions) {
            if (action.equals(s)) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public static String[] deleteDuplicates(String[] array) {
        Arrays.sort(array);
        int uniqueActionCounter = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (!array[i].equals(array[i + 1])) {
                uniqueActionCounter++;
            }
        }
        int index = 0;
        String[] uniqueActions = new String[uniqueActionCounter];
        for (int i = 0; i < array.length - 1; i++) {
            if (!array[i].equals(array[i + 1])) {
                uniqueActions[index] = array[i];
                index++;
            }
        }
        if (index < uniqueActionCounter) {
            uniqueActions[index] = array[array.length - 1];
        }
        return uniqueActions;
    }

    public static void allRowsToOneArray(String[] uniqueActions) {
        int uniqueActIndex = 0;
        for (String[] action : actions) {
            for (String s : action) {
                uniqueActions[uniqueActIndex] = s;
                uniqueActIndex++;
            }
        }
    }

    public static int totalActionsSum() {
        int arraysLength = 0;
        for (String[] action : actions) {
            arraysLength = arraysLength + action.length;
        }
        return arraysLength;
    }

    public static void csvToArrays() {
        String line;
        int innerArrayNumber = 0;
        BufferedReader br = bufferedReader(PATH);
        while ((line = reader(br)) != null) {
            String[] tempArray = line.split(",");
            actions[innerArrayNumber] = new String[tempArray.length - 1];
            System.arraycopy(tempArray, 0, actions[innerArrayNumber], 0, actions[innerArrayNumber].length);
            squirrel[innerArrayNumber] = whichBoolean(tempArray[tempArray.length - 1]);
            innerArrayNumber++;
        }
    }

    public static int fileLength(String path) {
        int rowCount = 0;
        BufferedReader br = bufferedReader(path);
        while ((reader(br) != null)) {
            rowCount++;
        }
        return rowCount;
    }

    public static boolean whichBoolean(String str) {
        return str.equals("true");
    }

    public static BufferedReader bufferedReader(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("File by this Path not found");
        }
        return br;
    }

    public static String reader(BufferedReader br) {
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.exit(1);
        }
        return str;
    }
}
