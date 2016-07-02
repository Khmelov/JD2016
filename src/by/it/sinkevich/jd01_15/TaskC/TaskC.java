package by.it.sinkevich.jd01_15.TaskC;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for jd01_15 TaskC
 *
 * @author Sinkevich Denis
 */
class TaskC {

    private static StringBuilder currentDirectory = new StringBuilder(System.getProperty("user.dir"));

    public static void main(String[] args) {
        System.out.print(currentDirectory + ">");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            while (!line.isEmpty()) {
                checkLine(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkLine(String line) {
        if (line.startsWith("cd ")) {
            checkLine(line.substring(3));
            return;
        }
        switch (line) {
            case "dir":
                System.out.println("\nСожержимое папки " + currentDirectory);
                File directory = new File(currentDirectory.toString());
                for (File file : directory.listFiles()) {
                    long fileSize = file.length();
                    String fileName = file.getName();
                    if (file.isDirectory()) {
                        System.out.printf("%5s %10s %s%n", "<DIR>", "", fileName);
                    } else {
                        System.out.printf("%5s %10d %s%n", "", fileSize, fileName);
                    }
                }
                break;
            case "..":
                int index = currentDirectory.lastIndexOf("\\");
                currentDirectory.delete(index, currentDirectory.length());
                System.out.print(currentDirectory + ">");
                break;
            default:
                currentDirectory.append("\\").append(line);
                System.out.print(currentDirectory + ">");
                break;
        }
    }
}
