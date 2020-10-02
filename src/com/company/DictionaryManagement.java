package com.company;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();

    public Dictionary insertFromCommandline() {
        Scanner in = new Scanner(System.in);
        String english, vietnamese;
        System.out.println("Nhap so luong tu moi: ");
        int n = in.nextInt();
        in.nextLine();
        //Dictionary Dic = new Dictionary();
        for (int i = 0; i < n; i++) {
            System.out.println("English: ");
            english = in.nextLine();
            System.out.println("Vietnamese: ");
            vietnamese = in.nextLine();
            Word newWord = new Word(english, vietnamese);
            dictionary.getDic().add(newWord);
        }
        return dictionary;
    }

    public Dictionary insertFromFile() throws IOException {
        Scanner scanner = new Scanner(Paths.get("dictionaries.txt"), "UTF-8");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] word = line.split("\t");
            Word w = new Word(word[0], word[1]);
            dictionary.getDic().add(w);
        }
        return dictionary;
    }

    public void dictionaryLookup() {
        Scanner in = new Scanner(System.in);
        System.out.println("Xin nhap tu vung ban muon tra cuu: ");
        String lookUp = in.nextLine();
        for (int i = 0; i < dictionary.getDic().size(); i++) {
            if (lookUp.equals(dictionary.getDic().get(i).getWord_target())) {
                System.out.println(dictionary.getDic().get(i).getWord_explain());
            }
        }
    }
}
