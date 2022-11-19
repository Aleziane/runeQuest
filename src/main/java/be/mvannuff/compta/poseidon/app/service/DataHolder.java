package be.mvannuff.compta.poseidon.app.service;

import be.mvannuff.compta.poseidon.app.domain.perso.Perso;
import be.mvannuff.compta.poseidon.app.domain.perso.caract.Caract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataHolder {

    private final Perso perso = new Perso();

    public Caract getCaract(){
        return perso.getCaract();
    }

}
