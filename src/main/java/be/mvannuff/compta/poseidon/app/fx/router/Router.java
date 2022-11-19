package be.mvannuff.compta.poseidon.app.fx.router;

import javafx.scene.Node;
import javafx.util.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Router {
    private final List<Routable> routes;

    private Route loaded = Route.DEFAULT;

    public Optional<Node> route(Route route) {

        if (loaded == route) {
            return Optional.empty();
        }

        var target = routes
                .stream()
                .filter(r -> r.identify() == route)
                .findFirst()
                .orElseThrow();
        log.info("route to {}", route);
        loaded = route;
        return Optional.of(target.load());
    }
}
