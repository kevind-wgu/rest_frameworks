package edu.wgu.ai.test_scopes;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {
    Warrior getWarrior();
}
