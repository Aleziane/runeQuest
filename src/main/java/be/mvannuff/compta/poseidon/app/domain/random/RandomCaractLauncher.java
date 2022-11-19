package be.mvannuff.compta.poseidon.app.domain.random;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RandomCaractLauncher {
    RIDICULOUS(-3), WEAK(-1), MEDIUM(0), MEDIUM_EXP(3), BOSS(5);

    private final int averageModifier;

}
