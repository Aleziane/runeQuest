package be.mvannuff.compta.poseidon.app.fx.controller.caract;

import be.mvannuff.compta.poseidon.app.domain.perso.caract.CaractArchetype;
import be.mvannuff.compta.poseidon.app.domain.random.RandomCaractLauncher;
import be.mvannuff.compta.poseidon.app.domain.random.RandomService;
import be.mvannuff.compta.poseidon.app.fx.controller.AbstractController;
import be.mvannuff.compta.poseidon.app.fx.lib.CombolistValueLabel;
import be.mvannuff.compta.poseidon.app.fx.lib.ValueLabelListCell;
import be.mvannuff.compta.poseidon.app.fx.router.Routable;
import be.mvannuff.compta.poseidon.app.fx.router.Route;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class CaractController extends AbstractController implements Routable {

    private final Resource fxmlFile = new ClassPathResource("view/caract.fxml");

    private final CaractViewModel caractViewModel;
    private final RandomService randomService;

    @FXML
    private ComboBox<CombolistValueLabel<RandomCaractLauncher>> powerCB;

    @FXML
    private ComboBox<CombolistValueLabel<CaractArchetype>> archetypeCB;
    @FXML
    private TextField force;
    @FXML
    private TextField intel;
    @FXML
    private TextField tai;
    @FXML
    private TextField constit;
    @FXML
    private TextField app;
    @FXML
    private TextField pou;
    @FXML
    private TextField dex;
    @FXML
    private Label bonusDeg;


    @FXML
    private Label pv_arms1;
    @FXML
    private Label pv_arms2;
    @FXML
    private Label pv_legs1;
    @FXML
    private Label pv_legs2;
    @FXML
    private Label pv_head;
    @FXML
    private Label pv_chest;
    @FXML
    private Label pv_belly;

    @FXML
    public void initialize() {
        registerComboboxValue();
        binds();
    }

    @FXML
    void randomize(ActionEvent event) {
        var randomizer = powerCB.getValue().getValue();
        var archetype = archetypeCB.getValue().getValue();
        //Null check plz
        var newCaract = randomService.randomizeCaract(randomizer, archetype);
        caractViewModel.update(newCaract);
    }

    @Override
    public Route identify() {
        return Route.CARACT;
    }

    private void binds() {
        force.textProperty().bindBidirectional(caractViewModel.getForce(), new NumberStringConverter());
        intel.textProperty().bindBidirectional(caractViewModel.getIntelligence(), new NumberStringConverter());
        tai.textProperty().bindBidirectional(caractViewModel.getTaille(), new NumberStringConverter());
        constit.textProperty().bindBidirectional(caractViewModel.getConstitution(), new NumberStringConverter());
        app.textProperty().bindBidirectional(caractViewModel.getApparence(), new NumberStringConverter());
        pou.textProperty().bindBidirectional(caractViewModel.getPouvoir(), new NumberStringConverter());
        dex.textProperty().bindBidirectional(caractViewModel.getDexterite(), new NumberStringConverter());

        pv_arms1.textProperty().bind(caractViewModel.getPv_arms());
        pv_arms2.textProperty().bind(caractViewModel.getPv_arms());
        pv_legs1.textProperty().bind(caractViewModel.getPv_legs());
        pv_legs2.textProperty().bind(caractViewModel.getPv_legs());
        pv_head.textProperty().bind(caractViewModel.getPv_head());
        pv_chest.textProperty().bind(caractViewModel.getPv_chest());
        pv_belly.textProperty().bind(caractViewModel.getPv_belly());
        bonusDeg.textProperty().bind(caractViewModel.getBonusDeg_bonus());
    }

    private void registerComboboxValue() {
        powerCB.getItems().addAll(
                new CombolistValueLabel<>("Ridiculement faible", RandomCaractLauncher.RIDICULOUS),
                new CombolistValueLabel<>("Faible", RandomCaractLauncher.WEAK),
                new CombolistValueLabel<>("Aventurier", RandomCaractLauncher.MEDIUM),
                new CombolistValueLabel<>("Aventurier experimente", RandomCaractLauncher.MEDIUM_EXP),
                new CombolistValueLabel<>("Boss", RandomCaractLauncher.BOSS)
        );
        archetypeCB.getItems().addAll(
                new CombolistValueLabel<>("Voleur", CaractArchetype.ROGUE),
                new CombolistValueLabel<>("Magicien", CaractArchetype.WIZARD),
                new CombolistValueLabel<>("Politicien", CaractArchetype.POLITICIAN),
                new CombolistValueLabel<>("Guerrier", CaractArchetype.WARRIOR)
        );
        archetypeCB.setCellFactory(lv -> new ValueLabelListCell<>());
        archetypeCB.setButtonCell(new ValueLabelListCell<>());
        powerCB.setCellFactory(lv -> new ValueLabelListCell<>());
        powerCB.setButtonCell(new ValueLabelListCell<>());
    }
}
