package be.mvannuff.compta.poseidon.app.domain.random;

import be.mvannuff.compta.poseidon.app.domain.perso.caract.Caract;
import be.mvannuff.compta.poseidon.app.domain.perso.caract.CaractArchetype;
import be.mvannuff.compta.poseidon.app.domain.perso.caract.CaractArchetypeStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RandomService {
    private final Random random = new Random();
    private final List<CaractArchetypeStrategy> caractArchetypeStrategies;

    private int rollDice(int nbOfDice, int diceValue) {
        int res = 0;
        for (int i = 0; i < nbOfDice; i++) {
            res += (random.nextInt(diceValue) + 1);
        }
        return res;
    }

    public Caract randomizeCaract(RandomCaractLauncher randomCaractLauncher, CaractArchetype archetype){
        var archetypeStrategy = caractArchetypeStrategies.stream()
                .filter(s -> s.support(archetype))
                .findFirst()
                .orElseThrow();

        List<Integer> baseStat = new ArrayList<>();
        List<Integer> exceptionalStat = new ArrayList<>();

        for(int i = 0; i<5; i++){
            baseStat.add(rollDice(3,6)+randomCaractLauncher.getAverageModifier());
        }
        for(int i = 0; i<2; i++){
            exceptionalStat.add(rollDice(2,6)+6+randomCaractLauncher.getAverageModifier());
        }

        return archetypeStrategy.spreadCaract(baseStat, exceptionalStat);
    }
}
