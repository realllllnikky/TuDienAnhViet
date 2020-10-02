package com.company;

import java.io.IOException;

public class DictionaryCommandline {
    public void showAllWords(Dictionary dictionary) {
        System.out.println("N0\t|" + "English\t\t| Vietnamese");
        for (int i = 0; i < dictionary.getDic().size(); i++) {
            System.out.println(i + 1 + " " + "\t|" + dictionary.getDic().get(i).getWord_target() + "\t\t\t| "
                    + dictionary.getDic().get(i).getWord_explain());
        }
    }

    public void dictionaryBasic(Dictionary dictionary) {
        DictionaryManagement dicMan = new DictionaryManagement();
        dictionary = dicMan.insertFromCommandline();
        showAllWords(dictionary);
    }

    public void dictionaryAdvanced(Dictionary dictionary) throws IOException {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionary = dictionaryManagement.insertFromFile();
        dictionaryManagement.dictionaryLookup();
        showAllWords(dictionary);
    }
}
