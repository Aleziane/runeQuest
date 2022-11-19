package be.mvannuff.compta.poseidon.app.domain.perso.caract;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PoliticianCaract implements CaractArchetypeStrategy {

    @Override
    public Caract spreadCaract(List<Integer> baseStat, List<Integer> exceptionalStat) {
        baseStat.sort(Collections.reverseOrder());
        exceptionalStat.sort(Collections.reverseOrder());

        return Caract.builder()
                .apparence(baseStat.get(0))
                .pouvoir(baseStat.get(1))
                .constitution(baseStat.get(4))
                .dexterite(baseStat.get(2))
                .force(baseStat.get(3))

                .intelligence(exceptionalStat.get(0))
                .taille(exceptionalStat.get(1))
                .build();
    }

    @Override
    public boolean support(CaractArchetype caractArchetype) {
        return CaractArchetype.POLITICIAN == caractArchetype;
    }
}
