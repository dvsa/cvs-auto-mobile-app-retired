package data.util;

import data.AtfData;
import model.Atf;

import java.util.List;

public class AtfService {

    private List<Atf> atfData = AtfData.buildAtfData();

    public String getUniqueIdentifier(int index) {
        return atfData.get(index).getAtfName() + " " + atfData.get(index).getAtfNumber();
    }

    public String getFirstLetter(int index) {
        return atfData.get(index).getAtfName().substring(0, 1).toUpperCase();
    }

    public Atf getAtfByIndex(int index) {
        return atfData.get(index);
    }
}
