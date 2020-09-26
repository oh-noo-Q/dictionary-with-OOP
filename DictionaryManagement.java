import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    public static ArrayList <Word> words = new ArrayList<>();
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        String newWord = sc.nextLine();
        String meaning = sc.nextLine();
        Word AddWord = new Word(newWord,meaning);
        words.add(AddWord);
    }
}
