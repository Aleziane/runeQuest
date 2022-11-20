package be.mvannuff.compta.poseidon.app.domain.perso.caract.derived;

import be.mvannuff.compta.poseidon.app.domain.perso.caract.Caract;

import java.util.Map;
import java.util.function.Function;

public class Pv {

    private static final Map<Localisation, Function<Integer, Integer>> pv = Map.of(
            Localisation.LEGS, (i) -> i,
            Localisation.BELLY, (i) -> i,
            Localisation.HEAD, (i) -> i,
            Localisation.CHEST, (Integer i) -> {
                int bonus = 1;
                int current = i;
                while ((current / 6) > 0) {
                    current = current / 6;
                    bonus++;
                }
                return i + bonus;
            },
            Localisation.ARMS, (Integer i) -> {
                int bonus = 0;
                int current = i;
                while ((current / 3) > 0) {
                    current = current / 3;
                    bonus++;
                }
                return i - bonus;
            }
    );

    public static Integer pvLegs(Caract caract) {
        return pv.get(Localisation.LEGS).apply(totIndex(caract));
    }

    public static Integer pvBelly(Caract caract) {
        return pv.get(Localisation.BELLY).apply(totIndex(caract));
    }

    public static Integer pvChest(Caract caract) {
        return pv.get(Localisation.CHEST).apply(totIndex(caract));
    }

    public static Integer pvArms(Caract caract) {
        return pv.get(Localisation.ARMS).apply(totIndex(caract));
    }

    public static Integer pvHead(Caract caract) {
        return pv.get(Localisation.HEAD).apply(totIndex(caract));
    }

    public static Integer totPv(Caract c) {
        return c.getConstitution() + c.getTaille();
    }

    private static int totIndex(Caract c) {
        return totPv(c) / 3;
    }

}
