package be.mvannuff.compta.poseidon.app.domain.perso.caract;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WizardCaract implements CaractArchetypeStrategy {

    @Override
    public Caract spreadCaract(List<Integer> baseStat, List<Integer> exceptionalStat) {
        baseStat.sort(Collections.reverseOrder());
        exceptionalStat.sort(Collections.reverseOrder());

        return Caract.builder()
                .pouvoir(baseStat.get(0))
                .dexterite(baseStat.get(1))
                .constitution(baseStat.get(2))
                .apparence(baseStat.get(3))
                .force(baseStat.get(4))

                .intelligence(exceptionalStat.get(0))
                .taille(exceptionalStat.get(1))
                .build();
    }

    @Override
    public boolean support(CaractArchetype caractArchetype) {
        return CaractArchetype.WIZARD == caractArchetype;
    }

}