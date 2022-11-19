package be.mvannuff.compta.poseidon.app.fx.lib;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CombolistValueLabel<T> implements Labelized {

    private final String label;
    private final T value;

}
