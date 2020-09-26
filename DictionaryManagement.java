import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * management .
 */
public class DictionaryManagement {
    public static ArrayList <Word> words = new ArrayList<>();

    /**
     * chen tu vao cuoi tu dien .
     */
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        String newWord = sc.nextLine();
        String meaning = sc.nextLine();
        Word AddWord = new Word(newWord,meaning);
        words.add(AddWord);
        sc.close();
    }

    /**
     * lay du lieu tu dien tu file .
     * @throws IOException
     */
    public void insertFromFile() throws IOException {
        Scanner scFile = new Scanner(Paths.get("D:\\Minh\\BT\\OOP\\Dictionary.txt"),"UTF-8");
        while (scFile.hasNextLine()) {
            String newWord = scFile.next();
            String meaning = scFile.nextLine();
            Word NW = new Word(newWord,meaning);
            words.add(NW);
        }
        scFile.close();
    }

    /**
     * tra tu .
     */
    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean checkFound = false;
        for (int i = 0; i < words.size(); ++i) {
            if (words.get(i).getWord_tager().equals(s)) {
                System.out.println(s + ": " + words.get(i).getWord_explain());
                checkFound = true;
                break;
            }
        }
        if (!checkFound) System.out.println("This word doesn't exist in this dictionary");
    }
}
