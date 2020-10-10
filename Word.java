public class Word {
    private String word_tager;
    private String word_explain;
    private String word_pronun;


    public String getWord_tager() {
        return word_tager;
    }
    public void setWord_tager(String word_tager) {
        this.word_tager = word_tager;
    }
    public String getWord_explain() {
        return word_explain;
    }
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    public String getWord_pronun() {return word_pronun;}
    public void setWord_pronun(String word_pronun) {
        this.word_pronun = word_pronun;
    }
    Word(String word_tager, String word_explain) {
        this.word_tager = word_tager;
        this.word_explain = word_explain;
        this.word_pronun = "";
    }
    Word() {
        this.word_tager = "";
        this.word_explain = "";
        this.word_pronun = "";
    }
    Word(String word_tager, String word_explain, String word_pronun) {
        this.word_tager = word_tager;
        this.word_explain = word_explain;
        this.word_pronun = word_pronun;
    }
}
