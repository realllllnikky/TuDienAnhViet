package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Dictionary dic = new Dictionary();
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
//      dictionaryCommandline.dictionaryBasic(dic);
//        Scanner in = new Scanner(System.in);
//        int n;
//        while (true) {
//            System.out.println("============DICTIONARY============");
//            System.out.println("1. Them tu vung moi vao tu dien.");
//            System.out.println("2. Tra cuu tu dien.");
//            System.out.println("3. Xem tu dien.");
//            System.out.println("4. Thoat.");
//            System.out.println("Lua chon cua ban la: ");
//            n = in.nextInt();
//            if (n == 1){
//
//            }
//        }
        dictionaryCommandline.dictionaryAdvanced(dic);
    }
}
