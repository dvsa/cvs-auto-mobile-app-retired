package data;

import model.Preparer;

import java.util.Arrays;
import java.util.List;

public class PreparerData {

    public static List<Preparer> buildPreparerData() {

        Preparer preparerOne = new Preparer()
                .setPreparerId("TC7524")
                .setPreparerName("Avello Edinburgh Ltd");

        Preparer preparerTwo = new Preparer()
                .setPreparerId("FQ9939")
                .setPreparerName("Tayside Repairs Ltd");

        return Arrays.asList(preparerOne, preparerTwo);

    }
}
