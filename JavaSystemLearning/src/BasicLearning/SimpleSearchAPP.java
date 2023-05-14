package BasicLearning;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import MyTools.Tools;

public class SimpleSearchAPP {

    static long globalStartTime = System.nanoTime();

    public static void main(String[] args) {

        String target = "constructed";
        StringBuilder content;
        content = ReadTheFile_V2("Assets/Article.txt");
        Tools.PrintExecutionTime("ReadFile",globalStartTime);
        Print(FindSting_Gen0(content, target).toString());
        Tools.PrintExecutionTime("FindSting_Gen0",globalStartTime);
        Print(FindSting_Gen1("Assets/Article.txt", target).toString());
        Tools.PrintExecutionTime("FindSting_Gen1",globalStartTime);
    }

    /**
     * read the file with BufferedReader
     * 
     * @param filePath
     * @return the content of the file in StringBuilder
     */
    public static StringBuilder ReadTheFile_V1(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
            while (bufferedReader.ready()) {
                contentBuilder.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Print("The Content Length: " + contentBuilder.length());
        return contentBuilder;
    }

    /**
     * read the file with Scanner
     * https://stackoverflow.com/questions/26516020/try-with-resources-vs-try-catch
     * https://stackoverflow.com/questions/30564069/java-scanner-hasnextline-returns-false
     * 
     * @param filePath
     * @return the content of the file in StringBuilder
     */
    public static StringBuilder ReadTheFile_V2(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Scanner myReader = new Scanner(new File(filePath), StandardCharsets.UTF_8.name())) {
            while (myReader.hasNextLine()) {
                contentBuilder.append(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Print("The Content Length: " + contentBuilder.length());
        return contentBuilder;
    }

    public static ArrayList<Integer> FindSting_Gen0(StringBuilder content, String target) {
        ArrayList<Integer> resultIndexList = new ArrayList<>();
        int index = 0;
        while (index < content.length()) {
            index = content.indexOf(target, index);
            if (index == -1) {
                break;
            }
            resultIndexList.add(index);
            index += target.length();
        }
        return resultIndexList;
    }

    public static ArrayList<Integer> FindSting_Gen1(String filePath, String target) {
        ArrayList<Integer> resultIndexList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
            int lastLineLength = 0;
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                int index = 0;
                while (index < line.length()) {
                    index = line.indexOf(target, index);
                    if (index == -1) {
                        break;
                    }
                    resultIndexList.add(index + lastLineLength);
                    index += target.length();
                }
                lastLineLength += line.length();
                // Print(lastLineLength);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultIndexList;
    }

    public static void Print(String s) {
        System.out.println(s);
    }
}
