package lesson4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CvsReader {
    public static void main(String[] args) {
        String path = "/Users/Xa3uK/Desktop/hillel/lesson4/journalEvents_ru.csv";
        String line = null;
        int rowCount = fileLength(path);
        String[][] words = new String[rowCount][];
        boolean[] booleans = new boolean[rowCount];
        int innerArrayNumber = 0;

        BufferedReader br = bufferedReader(path);
        while ((line = reader(br)) != null) {
            String[] tempArray = line.split(",");
            words[innerArrayNumber] = new String[tempArray.length - 1];
            for (int i = 0; i < words[innerArrayNumber].length; i++) {
                words[innerArrayNumber][i] = tempArray[i];
            }
            booleans[innerArrayNumber] = whichBoolean(tempArray[tempArray.length - 1]);
            innerArrayNumber++;
        }
        System.out.println(Arrays.deepToString(words));
        System.out.println(Arrays.toString(booleans));
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
        boolean bool = str.equals("true");
        if (str.equals("false")) {
            bool = false;
        }
        return bool;
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
