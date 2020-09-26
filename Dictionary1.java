import java.io.IOException;
import java.util.Scanner;

public class Dictionary1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DictionaryManagement management = new DictionaryManagement();
        DictionaryCommandLine commandLine = new DictionaryCommandLine();
        commandLine.dictionaryAdvanced();
    }
}
