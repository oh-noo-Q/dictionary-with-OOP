import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
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
        //sc.close();
    }

    /**
     * lay du lieu tu dien tu file .
     * @throws IOException
     */
    public void insertFromFile() throws IOException {
        Scanner scFile = new Scanner(Paths.get("Dictionary.txt"),"UTF-8");
        while (scFile.hasNextLine()) {
            String newWord = scFile.next();
            String meaning = scFile.nextLine().trim();
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
        sc.nextLine();
        //sc.close();
    }

    /**
     * sua tu, xoa tu .
     */
    public void editDictionary()  {
        //Scanner scFile = new Scanner(Paths.get("D:\\Minh\\BT\\OOP\\Dictionary.txt"), "UTF-8");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean checkFound = false;
        for (int i = 0; i < words.size(); ++i) {
            if (words.get(i).getWord_tager().equals(s) || words.get(i).getWord_explain().equals(s)) {
                checkFound = true;
                System.out.printf("%s\n%s\n%s\n%s\n", "If you want to edit word_taget, press T and your word_tager",
                        "If you want to edit word_explain, press M and your word_explain",
                        "If you want to delete it press D","Exit: Press E");
                String c = sc.next();
                sc.nextLine();
                if (c.equals("e")) break;
                else if (c.equals("t")) {
                    String edit = sc.nextLine();
                    words.get(i).setWord_tager(edit);
                    System.out.println(words.get(i).getWord_tager() + ": " + words.get(i).getWord_explain());
                    break;
                } else if (c.equals("m")) {
                    String edit = sc.nextLine();
                    words.get(i).setWord_explain(edit);
                    System.out.println(words.get(i).getWord_tager() + ": " + words.get(i).getWord_explain());
                    break;
                } else if (c.equals("d")) {
                    words.remove(i);
                    break;
                }
            }
        }
        if (checkFound == false) {
            System.out.println("This word doesn't exist in this dictionary");
        }
        //scFile.close();
    }

    /**
     *  in ket qua ra file .
     */
    public void dictionaryExportToFile() {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
             for (int i = 0; i < words.size(); ++i) {
                 myWriter.write(words.get(i).getWord_tager() + ":   " + words.get(i).getWord_explain() +"\n");
             }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
