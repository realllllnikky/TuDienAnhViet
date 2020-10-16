package sample;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();
    Scanner in = new Scanner(System.in);

    public Dictionary insertFromCommandline() {
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

    public void addFromCommandline() {
        String english, vietnamese;
        System.out.println("Nhap tu ban can them: ");
        System.out.println("English: ");
        english = in.nextLine();
        System.out.println("Vietnamese: ");
        vietnamese = in.nextLine();
        Word newWord = new Word(english, vietnamese);
        dictionary.getDic().add(newWord);
    }

    public void deleteFromCommandline() {
        String english;
        System.out.println("Chon tu ban muon xoa: ");
        english = in.nextLine();
        Word j = null;
        for (Word i : dictionary.getDic()) {
            if (i.getWord_target().equals(english)) {
                j = i;
            }
        }
        dictionary.getDic().remove(j);
    }

    public void editFromCommandline() {
        String english, newEnglish, newVietnamese;
        System.out.println("Chon tu ban muon sua: ");
        english = in.nextLine();
        int j = 0;
        for (Word i : dictionary.getDic()) {
            j++;
            if (i.getWord_target().equals(english)) {
                System.out.println("Ban sua tu nay thanh: ");
                System.out.println("English: ");
                newEnglish = in.nextLine();
                System.out.println("Vietnamese: ");
                newVietnamese = in.nextLine();
                Word w = new Word(newEnglish, newVietnamese);
                dictionary.getDic().set(j - 1, w);
            }
        }
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
        System.out.println("Xin nhap tu vung ban muon tra cuu: ");
        String lookUp = in.nextLine();
        for (int i = 0; i < dictionary.getDic().size(); i++) {
            if (lookUp.equals(dictionary.getDic().get(i).getWord_target())) {
                System.out.println(dictionary.getDic().get(i).getWord_explain());
            }
        }
    }

    public void addNewWord() throws FileNotFoundException, UnsupportedEncodingException {
        String english, vietnamese;
        PrintWriter printWriter = new PrintWriter("dictionaries.txt", "UTF-8");
        System.out.println("So luong tu vung can them vao tu dien: ");
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("English: ");
            english = in.nextLine();
            System.out.println("Vietnamese: ");
            vietnamese = in.nextLine();
            printWriter.println(english + "\t" + vietnamese);
        }
        printWriter.close();
    }


    public void dictionaryExportToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("dictionaries.txt", "UTF-8");
        for (Word i : dictionary.getDic()){
            printWriter.append(i.getWord_target() + "\t" + i.getWord_explain() + "\n");
        }
        printWriter.close();
    }
}

