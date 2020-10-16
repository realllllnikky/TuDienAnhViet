package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    Scanner in = new Scanner(System.in);
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
        dictionaryManagement.addFromCommandline();
        showAllWords(dictionary);
        dictionaryManagement.deleteFromCommandline();
        showAllWords(dictionary);
        dictionaryManagement.editFromCommandline();
        showAllWords(dictionary);
        dictionaryManagement.dictionaryExportToFile();
        dictionarySearcher(dictionary);
    }

    public void dictionarySearcher(Dictionary dictionary){
        System.out.println("Search: ");
        String search = in.nextLine();
        for(Word i : dictionary.getDic()){
            if(search.equals(i.getWord_target().substring(0, search.length()))){
                System.out.println(i.getWord_target());
            }
        }
    }
}