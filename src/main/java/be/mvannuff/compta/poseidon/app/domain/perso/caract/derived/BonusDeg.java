package be.mvannuff.compta.poseidon.app.domain.perso.caract.derived;

import be.mvannuff.compta.poseidon.app.domain.perso.caract.Caract;

public class BonusDeg {


    public static String bonusDeg(Caract carac) {
        int stat = totStat(carac);
        if (stat < 13) {
            return "-1d4";
        } else if (stat < 25) {
            return "0";
        } else if (stat < 33) {
            return "+1d4";
        } else if (stat < 41) {
            return "+1d6";
        } else if (stat < 57) {
            return "+2d6";
        } else {
            int temp = (stat - 56) / 16;
            temp = temp + 2;
            return "+"+temp + "d6";
        }
    }

    private static int totStat(Caract c) {
        return c.getForce() + c.getTaille();
    }
}
