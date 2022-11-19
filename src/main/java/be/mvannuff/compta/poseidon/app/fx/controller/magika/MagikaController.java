package be.mvannuff.compta.poseidon.app.fx.controller.magika;

import be.mvannuff.compta.poseidon.app.fx.controller.AbstractController;
import be.mvannuff.compta.poseidon.app.fx.router.Routable;
import be.mvannuff.compta.poseidon.app.fx.router.Route;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class MagikaController extends AbstractController implements Routable {


    private final Resource parrot = new ClassPathResource("img/parrot.png");
    private final Resource res = new ClassPathResource("view/parrot.fxml");

    @Override
    public void initialize() {

    }

    @Override
    @SneakyThrows
    public Resource getFxmlFile() {
        return res;
    }

    @Override
    public Route identify() {
        return Route.MAGIKA;
    }


}
