package edu.wgu.ai.test_scopes;

import dagger.Module;
import dagger.Provides;

@Module
public class WarriorScreenModule {
    private static int index = 100;

    @Provides
    @WarriorScreenScope
    WarriorPresenter provideWarriorPresenter(Warrior warrior) {
        index++;
        return new WarriorPresenter(warrior, index);
    }
}
