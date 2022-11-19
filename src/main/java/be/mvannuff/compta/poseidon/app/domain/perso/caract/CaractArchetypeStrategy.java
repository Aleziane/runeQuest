package be.mvannuff.compta.poseidon.app.domain.perso.caract;

import java.util.List;

public interface CaractArchetypeStrategy {

   Caract spreadCaract(List<Integer> baseStat, List<Integer> exceptionalStat);

   boolean support(CaractArchetype caractArchetype);

}
