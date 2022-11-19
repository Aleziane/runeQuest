package be.mvannuff.compta.poseidon.app.domain.perso.caract.derived;


import lombok.Getter;

@Getter
public class BonusDeg {

    public static String bonusDeg(int force){
        if(force> 20){
            return "+2d6";
        }else {
            return "+1d4";
        }
    }
}
