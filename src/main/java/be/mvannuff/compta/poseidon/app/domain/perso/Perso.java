package be.mvannuff.compta.poseidon.app.domain.perso;

import be.mvannuff.compta.poseidon.app.domain.perso.caract.Caract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Perso {
    private Caract caract = new Caract();

}
