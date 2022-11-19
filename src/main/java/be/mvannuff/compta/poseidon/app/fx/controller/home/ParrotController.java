package be.mvannuff.compta.poseidon.app.fx.controller.home;


import be.mvannuff.compta.poseidon.app.fx.controller.magika.MagikaController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class ParrotController {

    private final Resource parrot = new ClassPathResource("img/parrot.png");

    private final MagikaController magikaController;

    @FXML
    private AnchorPane view;

    @FXML
    public void initialize() {
        System.out.println("333333333333333333333333333333333333333333333333");
        load();
    }

    @SneakyThrows
    private void load() {
        Image image = new Image(parrot.getInputStream());
        //Setting the image view
        ImageView imageView = new ImageView(image);
        var x = new SimpleDoubleProperty(700);
        var y = new SimpleDoubleProperty(100);
        imageView.xProperty().bindBidirectional(x);
        imageView.yProperty().bindBidirectional(y);
        var hp = new SimpleDoubleProperty(455);
        var wp = new SimpleDoubleProperty(500);
        imageView.fitHeightProperty().bindBidirectional(hp);
        imageView.fitWidthProperty().bindBidirectional(wp);
        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        //Creating a Group object
        Group root = new Group(imageView);
        view.getChildren().add(root);
    }

}
