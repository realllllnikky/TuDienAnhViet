package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TextArea textEnglish;
    @FXML
    private TextArea textVietnamese;

    private static DictionaryManagement management = new DictionaryManagement();
    private static Dictionary dictionary = new Dictionary();

    static {
        try {
            dictionary = management.insertFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAll() {
        List<Word> wordList = dictionary.getDic();
        System.out.println(wordList.size());
        String word_target = "";
        String word_explain = "";
        for (Word word : wordList) {
            word_target += word.getWord_target() + "\n";
            word_explain += word.getWord_explain() + "\n";
        }
        textEnglish.setText(word_target);
        textVietnamese.setText(word_explain);
    }
}
