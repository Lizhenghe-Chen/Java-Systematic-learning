package BasicLearning;
import java.io.*;
import java.util.ArrayList;

public class SimpleSearchAPP {

    static long globalStartTime = System.nanoTime();

    public static void main(String[] args) {

        String target = "constructed";
        StringBuilder content = ReadTheFile("Assets/Article.txt");
        Print(FindSting_Gen0(content, target).toString());
        PrintExecutionTime();
        Print(FindSting_Gen1("Assets/Article.txt", target).toString());
        PrintExecutionTime();
    }

    public static void PrintExecutionTime() {
        long TotalTime = System.nanoTime() - globalStartTime;
        // print total time
        Print("Total Time: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
        // chang the original
        globalStartTime = System.nanoTime();
        // Print(String.valueOf(globalStartTime));
    }

    public static StringBuilder ReadTheFile(String filePath) {
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
