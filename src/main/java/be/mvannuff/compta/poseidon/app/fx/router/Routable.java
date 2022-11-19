package be.mvannuff.compta.poseidon.app.fx.router;

import javafx.scene.Node;
import javafx.util.Pair;

public interface Routable {

    Route identify();

    Node load();
}
