package be.mvannuff.compta.poseidon.app.fx.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.util.Pair;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Getter
@RequiredArgsConstructor
public abstract class AbstractController implements Initializable {

    private FXMLLoader fxmlLoader;


    @Autowired
    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        try {
            fxmlLoader.setLocation(getFxmlFile().getURL());
            this.fxmlLoader = fxmlLoader;
        } catch (IOException e) {
            throw new RuntimeException("View not found", e);
        }
    }

    @SneakyThrows
    public Parent load() {
        return fxmlLoader.load();
    }

    public abstract Resource getFxmlFile();

}