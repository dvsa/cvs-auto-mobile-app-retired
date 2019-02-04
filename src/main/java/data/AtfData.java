package data;

import model.Atf;

import java.util.Arrays;
import java.util.List;

public class AtfData {

    public static List<Atf> buildAtfData() {

        // First topAtfOne needs to be first in search list

        Atf topAtfOne = new Atf()
                .setAtfId("9")
                .setAtfNumber("09-4129632")
                .setAtfName("Abshire-Kub");

        Atf secondAtf = new Atf()
                .setAtfId("6")
                .setAtfNumber("95-1291781")
                .setAtfName("Bergnaum Group");

        Atf thirdAtf = new Atf()
                .setAtfId("2")
                .setAtfNumber("84-926821")
                .setAtfName("Larson, Nader and Okuneva");

        Atf fourthAtf = new Atf()
                .setAtfId("5")
                .setAtfNumber("00-3024646")
                .setAtfName("Nienow-Wunsch");


        return Arrays.asList(topAtfOne, secondAtf, thirdAtf, fourthAtf);
    }
}