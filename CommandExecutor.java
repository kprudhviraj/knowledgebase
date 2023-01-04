import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    public static String[] executeCommand(String[] command) throws IOException {
        // Execute the command using the ProcessBuilder class
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        // Read the command output using the BufferedReader class
        List<String> output = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
        }

        // Return the command output as a string array
        return output.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        // Set the path to the folder you want to list files from
        String folder = "/path/to/folder";

        // Set the start and end dates for the date range
        String startDate = "2022-01-01"; // start date is January 1st, 2022
        String endDate = "2022-12-31"; // end date is December 31st, 2022

        // Set the command and its arguments for each operating system
        String[] windowsCommand = {"cmd.exe", "/c", "dir", folder, "/T:W", "/O:D", "/S", "/B", "/A:-D", "/minage:" + startDate, "/maxage:" + endDate};
        String[] unixCommand = {"bash", "-c", "ls", "-l", "--time-style=+%Y-%m-%d", "--sort=time", folder};
        String[] macCommand = {"bash", "-c", "find", folder, "-type", "f", "-newermt", startDate, "-not", "-newermt", endDate, "-ls"};

        // Determine the operating system
        String osName = System.getProperty("os.name").toLowerCase();
        String[] command;
        if (osName.contains("windows")) {
            command = windowsCommand;
        } else if (osName.contains("mac")) {
            command = macCommand;
        } else {
            command = unixCommand;
        }

        // Execute the command and get the result as a string array
        String[] output = executeCommand(command);

        // Print the command output
        for (String line : output) {
            System.out.println(line);
        }
    }
}
