package data.util;

import data.PreparerData;
import model.Preparer;

import java.util.List;

public class PreparerService {

    private List<Preparer> preparerData = PreparerData.buildPreparerData();


    public Preparer getPreparerByIndex(int index) {
        return preparerData.get(index);
    }

}
