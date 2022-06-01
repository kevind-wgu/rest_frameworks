package edu.wgu.ai.test_scopes;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private static int index = 0;

    @Provides
    @ApplicationScope
    Warrior provideWarrior() {
        index++;
        return new Warrior("HI - ", index);
//        return new Warrior();
    }
}
