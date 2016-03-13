package sortlinesofafilealphabetically;

import java.io.*;
import java.util.*;

/**
 *
 * @author Alex
 */
public class SortLinesOfAFileAlphabetically {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("rsc\\ToSort.txt")));
        } catch (FileNotFoundException exception) {
            System.err.println("Cannot open file");
        } finally {
            if (bufferedReader != null) {
                try {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        lines.add(line);
                    }
                } catch (IOException exception) {
                    System.err.println("Cannot read file");
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (IOException exception) {
                        System.err.println("Cannot close bufferedReader");
                    }
                }
            }
        }
        Collections.sort(lines);
        try {
            printWriter = new PrintWriter(new FileWriter(new File("rsc\\Sorted.txt")), true);
            for (String line : lines) {
                printWriter.println(line);
            }
        } catch (IOException exception) {
            System.err.println("Cannot create file");
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
