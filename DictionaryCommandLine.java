import com.sun.crypto.provider.DESCipher;

public class DictionaryCommandLine {
    public void showAllWords() {
        System.out.printf("%-12s%-12s%s\n", "No", "|English", "|Vietnamese");
        int n = DictionaryManagement.words.size();
        for (int i = 0; i < n; ++i) {
            System.out.printf("%-12d%-12s%s\n", i+1, "|" + DictionaryManagement.words.get(i).getWord_tager(),
                   "|" + DictionaryManagement.words.get(i).getWord_explain());
        }
    }
}
