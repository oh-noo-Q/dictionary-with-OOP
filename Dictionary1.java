import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DictionaryManagement management = new DictionaryManagement();
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            management.insertFromCommandline();
        }
        DictionaryCommandLine commandLine = new DictionaryCommandLine();
        commandLine.showAllWords();
    }
}
