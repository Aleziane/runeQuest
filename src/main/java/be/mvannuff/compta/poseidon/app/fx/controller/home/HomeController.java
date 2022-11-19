package be.mvannuff.compta.poseidon.app.fx.controller.home;

import be.mvannuff.compta.poseidon.app.fx.controller.AbstractController;
import be.mvannuff.compta.poseidon.app.fx.router.Route;
import be.mvannuff.compta.poseidon.app.fx.router.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Getter
@RequiredArgsConstructor
public class HomeController extends AbstractController {

    private final Stage stage;
    private final Resource fxmlFile = new ClassPathResource("view/main.fxml");
    private final Resource parrot = new ClassPathResource("img/parrot.png");

    private final Router router;

    @FXML
    private VBox centerView;

    @FXML
    private ImageView title;

    @FXML
    private VBox centerContainer;


    @FXML
    private void routeTo(ActionEvent event) {
        Node node = (Node) event.getSource();

        String data = (String) node.getUserData();
        router.route(Route.valueOf(data)).ifPresent(n -> {
            centerView.getChildren().clear();
            Group root = new Group(n);
            centerView.getChildren().add(root);
            centerView.setAlignment(Pos.CENTER);
        });

    }

    @FXML
    @SneakyThrows
    public void initialize() {
        Image image = new Image(parrot.getInputStream());
        //Setting the image view
        ImageView imageView = new ImageView(image);
        imageView.fitHeightProperty().bind(centerView.heightProperty());
        imageView.fitWidthProperty().bind(centerView.widthProperty());
        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        //Creating a Group object
        Group root = new Group(imageView);
        centerView.getChildren().clear();
        centerView.getChildren().add(root);

        title.fitWidthProperty().bind(centerContainer.widthProperty());
        title.setPreserveRatio(true);
    }

    public void autoLoad() throws IOException {
        var parent = super.load();
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
