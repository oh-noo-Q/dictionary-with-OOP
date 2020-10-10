import com.sun.crypto.provider.DESCipher;

import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandLine {
    /**
     * in ra toan bo du lieu tu dien .
     */
    public void showAllWords() {
        System.out.printf("%-12s%-12s%s\n", "No", "|English", "|Vietnamese");
        int n = DictionaryManagement.words.size();
        for (int i = 0; i < n; ++i) {
            System.out.print(DictionaryManagement.words.get(i).getWord_tager() + " " +
                    DictionaryManagement.words.get(i).getWord_pronun() + "\n" +
                    DictionaryManagement.words.get(i).getWord_explain() + "\n**************\n");
        }
    }

    /**
     * goi ham insertFromFile() .
     * goi ham showAllWords() .
     * goi ham dictionaryLookup() .
     */
    public void dictionaryAdvanced() throws IOException {
        DictionaryManagement management = new DictionaryManagement();
        management.insertFromFile();
        showAllWords();
        management.dictionaryLookup();
    }

    /**
     * in ta tat ca tu bat dau bang cac ky tu cho truoc .
     * @throws IOException
     */
    public void dictionarySearch() throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                c += 'a' - 'A';
                s = s.replace(s.charAt(i),c);
            }
        }
        sc.nextLine();
        boolean checkFound = false;
        for (int i = 0; i < DictionaryManagement.words.size(); ++i) {
            if (DictionaryManagement.words.get(i).getWord_tager().length() < s.length()) continue;
            boolean check = true;
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) != DictionaryManagement.words.get(i).getWord_tager().charAt(j)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                checkFound = true;
                System.out.print(DictionaryManagement.words.get(i).getWord_tager() + " " +
                        DictionaryManagement.words.get(i).getWord_pronun() + "\n" +
                        DictionaryManagement.words.get(i).getWord_explain() + "\n**************\n");
            }
        }
        if (!checkFound) System.out.println("Not found");
    }
}
