package edu.wgu.ai.test_scopes;

public class WarriorPresenter {
    private int index;
    private Warrior warrior;

    public WarriorPresenter(Warrior warrior, int index) {
        this.index = index;
        this.warrior = warrior;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    @Override
    public String toString() {
        return "WarriorPresenter{" +
                "warrior=" + warrior +
                " index=" + index +
                '}';
    }
}
