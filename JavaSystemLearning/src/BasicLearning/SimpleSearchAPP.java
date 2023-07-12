package BasicLearning;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import MyTools.PrintTools;

public class SimpleSearchAPP {

    static long globalStartTime = System.nanoTime();

    public static void main(String[] args) {

        String target = "constructed";
        StringBuilder content;
        content = ReadTheFile_V2("Assets/Article.txt");
        PrintTools.PrintExecutionTime("ReadFile", globalStartTime);
        PrintTools.println(FindSting_Gen0(content, target).toString());
        Print("asd");
        PrintTools.PrintExecutionTime("FindSting_Gen0", globalStartTime);
        PrintTools.println(FindSting_Gen1("Assets/Article.txt", target).toString());
        PrintTools.PrintExecutionTime("FindSting_Gen1", globalStartTime);
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
        PrintTools.println("The Content Length: " + contentBuilder.length());
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
        PrintTools.println("The Content Length: " + contentBuilder.length());
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
                // PrintTools.println(lastLineLength);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultIndexList;
    }

    /**
     * @deprecated use PrintTools.println() instead
     * @param s
     */
    @Deprecated
    public static void Print(String s) {
        System.out.println(s);
    }

}
