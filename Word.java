public class Word {
    private String word_tager;
    private String word_explain;

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

    Word( String word_tager, String word_explain) {
        this.word_tager = word_tager;
        this.word_explain = word_explain;
    }
    Word() {
        this.word_tager = "";
        this.word_explain = "";
    }
}
