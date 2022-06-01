package edu.wgu.ai.test_scopes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Warrior {
    private String info;
    private int index;

    public Warrior(String info, int index) {
        this.info = info;
        this.index = index;
    }

    public String getInfo() {
        return info;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "info='" + info + '\'' +
                ", index=" + index +
                '}';
    }
}
