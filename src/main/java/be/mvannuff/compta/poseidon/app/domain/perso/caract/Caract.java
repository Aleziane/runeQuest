package be.mvannuff.compta.poseidon.app.domain.perso.caract;

import be.mvannuff.compta.poseidon.app.domain.perso.caract.derived.BonusDeg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Caract {

    private Integer force;
    private Integer constitution;
    private Integer taille;
    private Integer intelligence;
    private Integer pouvoir;
    private Integer dexterite;
    private Integer apparence;

    public Caract() {
        this(0, 0, 0, 0, 0, 0, 0);
    }

}
