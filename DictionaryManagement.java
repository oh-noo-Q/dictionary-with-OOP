import java.io.*;
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
    public static void insertFromFile() throws IOException {
        String file_name = "dictionaries.txt";
        ArrayList<String> allword = new ArrayList<>();
        String allTextinFile = null;
        File file = new File(file_name);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        allTextinFile = new String(data,"UTF-8");
        String[] wordArray = allTextinFile.split("@");
        for (String word : wordArray) {
            if (word.equals("")) continue;
            String[] Target_Pronun_Meaning = word.split("\n", 2);
            String[] Target_Pronun = Target_Pronun_Meaning[0].split("/",2);
            String word_target = Target_Pronun[0].trim();
            String word_pronun = "";
            if (Target_Pronun.length > 1) {
                word_pronun = "/" + Target_Pronun[1];
            }
            String word_explain = Target_Pronun_Meaning[1];
            Word new_word = new Word(word_target, word_explain, word_pronun);
            words.add(new_word);
        }
    }

    /**
     * tra tu .
     */
    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                c += 'a' - 'A';
                s = s.replace(s.charAt(i),c);
            }
        }
        boolean checkFound = false;
        for (int i = 0; i < words.size(); ++i) {
            if (words.get(i).getWord_tager().equals(s)) {
                System.out.println(s + " " + words.get(i).getWord_pronun() + "\n" + words.get(i).getWord_explain());
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
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                c += 'a' - 'A';
                s = s.replace(s.charAt(i),c);
            }
        }
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
                    System.out.print(DictionaryManagement.words.get(i).getWord_tager() + " " +
                            DictionaryManagement.words.get(i).getWord_pronun() + "\n" +
                            DictionaryManagement.words.get(i).getWord_explain() + "\n**************\n");
                    break;
                } else if (c.equals("m")) {
                    String edit = sc.nextLine();
                    words.get(i).setWord_explain(edit);
                    System.out.print(DictionaryManagement.words.get(i).getWord_tager() + " " +
                            DictionaryManagement.words.get(i).getWord_pronun() + "\n" +
                            DictionaryManagement.words.get(i).getWord_explain() + "\n**************\n");
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
             for (int i = 0; i < words.size(); ++i) {
                 myWriter.write(words.get(i).getWord_tager() + " " + words.get(i).getWord_pronun() + "\n" + words.get(i).getWord_explain() +"\n");
             }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
