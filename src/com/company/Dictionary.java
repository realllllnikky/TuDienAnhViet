package com.company;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> Dic = new ArrayList<Word>();

    public ArrayList<Word> getDic() {
        return this.Dic;
    }

    public void setDic(ArrayList<Word> dic) {
        this.Dic = dic;
    }

    public Dictionary() {
        this.Dic = new ArrayList<>();
    }
}
