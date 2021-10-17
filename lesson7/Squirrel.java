package lesson7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Squirrel {
    private static final String PATH = "/Users/xa3uk/Desktop/hillel/github-homework/lesson7/journalEvents_ru.csv";
    private static final int ROW_COUNT = fileLength(PATH);
    private static final String[][] events = new String[ROW_COUNT][];
    private static final boolean[] squirrel = new boolean[ROW_COUNT];

    public static void main(String[] args) {
        convertCsvFileToArray();
        String[] allActions = new String[allActionsCount()];
        String[] uniqueActions = deleteDuplicates(allActions);
        correlationResultsAnnouncer(uniqueActions);
        String[] actionsWithMinMaxEffect = minMaxEffectFinder(uniqueActions);
        int[] minMaxActionsStats = calcComboStats(actionsWithMinMaxEffect);
        resultAnnouncer(actionsWithMinMaxEffect, minMaxActionsStats);
    }

    public static String[] minMaxEffectFinder(String[] uniqueActions) {
        double min = 0;
        double max = 0;
        String actionMin = null;
        String actionMax = null;
        double result;
        for (String uniqueAction : uniqueActions) {
            int[] actionStats = calcSingleStats(uniqueAction);
            result = correlationFormula(actionStats);
            if (result > 0.1 || result < -0.1) {
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

    public static int[] calcComboStats(String[] actions) {
        int[] actionStat = new int[4];
        for (int i = 0; i < events.length; i++) {
            if (!isAction(actions[0], events[i]) && (isAction(actions[1], events[i]) && squirrel[i])) {
                actionStat[2]++;
            }
            if (isAction(actions[0], events[i]) && !isAction(actions[1], events[i]) && squirrel[i]) {
                actionStat[3]++;
            } else if (isAction(actions[0], events[i]) && !isAction(actions[1], events[i])) {
                actionStat[1]++;
            }
        }
        actionStat[0] = events.length - actionStat[1] - actionStat[2] - actionStat[3];
        return actionStat;
    }

    public static int[] calcSingleStats(String action) {
        int[] actionStat = new int[4];
        for (int i = 0; i < events.length; i++) {
            if (!isAction(action, events[i]) && squirrel[i]) {
                actionStat[2]++;
            }
            if (isAction(action, events[i]) && (squirrel[i])) {
                actionStat[3]++;
            } else if (isAction(action, events[i])) {
                actionStat[1]++;
            }
        }
        actionStat[0] = events.length - actionStat[1] - actionStat[2] - actionStat[3];
        return actionStat;
    }

    public static double correlationFormula(int[] actionStats) {
        double upper = actionStats[3] * actionStats[0] - actionStats[2] * actionStats[1];
        double lower = Math.sqrt((actionStats[2] + actionStats[3]) * (actionStats[0] + actionStats[1])
                * (actionStats[1] + actionStats[3]) * (actionStats[0] + actionStats[2]));
        return upper / lower;
    }

    public static void correlationResultsAnnouncer(String[] uniqueActions) {
        DecimalFormat dF = new DecimalFormat("#.#########");
        System.out.println("Для корреляции > 0.1 или < -0.1");
        double result;
        for (String uniqueAction : uniqueActions) {
            int[] actionStats = calcSingleStats(uniqueAction);
            result = correlationFormula(actionStats);
            if (result > 0.1 || result < -0.1) {
                System.out.println(uniqueAction + " :" + dF.format(result));
            }
        }
    }

    public static void resultAnnouncer(String[] combinedAction, int[] combinedActionsStats) {
        DecimalFormat dFF = new DecimalFormat("#.000000000");
        System.out.println("\nДля нового события");
        String[] actionOne = combinedAction[0].split(" ");
        String[] actionTwo = combinedAction[1].split(" ");
        System.out.println(actionOne[actionOne.length - 1] + "-" + actionTwo[actionTwo.length - 1]
                + " :" + dFF.format(correlationFormula(combinedActionsStats)));
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
        replaceActionsToOneArray(array);
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

    public static void replaceActionsToOneArray(String[] actions) {
        int index = 0;
        for (String[] action : events) {
            for (String s : action) {
                actions[index] = s;
                index++;
            }
        }
    }

    public static int allActionsCount() {
        int count = 0;
        for (String[] action : events) {
            count = count + action.length;
        }
        return count;
    }

    public static void convertCsvFileToArray() {
        String line;
        int index = 0;
        BufferedReader br = bufferedReader(PATH);
        while ((line = reader(br)) != null) {
            String[] tempArray = line.split(",");
            events[index] = new String[tempArray.length - 1];
            System.arraycopy(tempArray, 0, events[index], 0, events[index].length);
            squirrel[index] = whichBoolean(tempArray[tempArray.length - 1]);
            index++;
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
