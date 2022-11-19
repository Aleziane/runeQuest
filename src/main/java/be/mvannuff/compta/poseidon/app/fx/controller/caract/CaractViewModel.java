package be.mvannuff.compta.poseidon.app.fx.controller.caract;

import be.mvannuff.compta.poseidon.app.domain.perso.caract.Caract;
import be.mvannuff.compta.poseidon.app.service.DataHolder;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.WritableValue;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Scope("prototype")
@Getter
public class CaractViewModel {

    private final DataHolder dataHolder;

    private final IntegerProperty force = new SimpleIntegerProperty();
    private final IntegerProperty constitution = new SimpleIntegerProperty();
    private final IntegerProperty taille = new SimpleIntegerProperty();
    private final IntegerProperty intelligence = new SimpleIntegerProperty();
    private final IntegerProperty pouvoir = new SimpleIntegerProperty();
    private final IntegerProperty dexterite = new SimpleIntegerProperty();
    private final IntegerProperty apparence = new SimpleIntegerProperty();

    private final StringProperty bonusDeg_bonus = new SimpleStringProperty();

    public CaractViewModel(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
        update(dataHolder.getCaract());

        force.addListener(listener(force, (v) -> dataHolder.getCaract().setForce(v.intValue())));
        constitution.addListener(listener(constitution, (v) -> dataHolder.getCaract().setConstitution(v.intValue())));
        taille.addListener(listener(taille, (v) -> dataHolder.getCaract().setTaille(v.intValue())));
        intelligence.addListener(listener(intelligence, (v) -> dataHolder.getCaract().setIntelligence(v.intValue())));
        pouvoir.addListener(listener(pouvoir, (v) -> dataHolder.getCaract().setPouvoir(v.intValue())));
        dexterite.addListener(listener(dexterite, (v) -> dataHolder.getCaract().setDexterite(v.intValue())));
        apparence.addListener(listener(apparence, (v) -> dataHolder.getCaract().setApparence(v.intValue())));
    }

    public void update(Caract newCaract){
        force.set(newCaract.getForce());
        constitution.set(newCaract.getConstitution());
        taille.set(newCaract.getTaille());
        intelligence.set(newCaract.getIntelligence());
        pouvoir.set(newCaract.getPouvoir());
        dexterite.set(newCaract.getDexterite());
        apparence.set(newCaract.getApparence());
        bonusDeg_bonus.set(newCaract.getBonusDeg());
    }

    private <T> ChangeListener<T> listener(WritableValue<T> value, Consumer<T> updater) {
        return (observable, oldValue, newValue) -> {
            //good to have validation there
            value.setValue(newValue);
            updater.accept(newValue);
            bonusDeg_bonus.set(dataHolder.getCaract().getBonusDeg());
        };
    }
}
