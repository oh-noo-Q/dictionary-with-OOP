package dictionary;

import com.sun.speech.freetts.VoiceManager;

public class Voice {
    private String text;

    private com.sun.speech.freetts.Voice voice;

    public Voice(String text) {
        this.text = text;
        this.voice = VoiceManager.getInstance().getVoice(this.text);
        this.voice.allocate();
    }

    public void say(String something) {
        this.voice.speak(something);
    }
}
