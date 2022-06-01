package edu.wgu.ai.test_scopes;

import dagger.Component;

@WarriorScreenScope
@Component(modules = {WarriorScreenModule.class},
        dependencies = {AppComponent.class})
interface WarriorScreenComponent {
    WarriorPresenter getPresenter();
}