package be.mvannuff.compta.poseidon.app.domain.perso.caract;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WariorCaract implements CaractArchetypeStrategy {

    @Override
    public Caract spreadCaract(List<Integer> baseStat, List<Integer> exceptionalStat) {
        baseStat.sort(Collections.reverseOrder());
        exceptionalStat.sort(Collections.reverseOrder());

        return Caract.builder()
                .force(baseStat.get(0))
                .constitution(baseStat.get(1))
                .dexterite(baseStat.get(2))
                .pouvoir(baseStat.get(3))
                .apparence(baseStat.get(4))

                .taille(exceptionalStat.get(0))
                .intelligence(exceptionalStat.get(1))
                .build();
    }

    @Override
    public boolean support(CaractArchetype caractArchetype) {
        return CaractArchetype.WARRIOR == caractArchetype;
    }
}
