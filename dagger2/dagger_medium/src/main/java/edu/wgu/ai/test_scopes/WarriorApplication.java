package edu.wgu.ai.test_scopes;

public class WarriorApplication {
    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        System.out.println(appComponent.getWarrior().toString());
        System.out.println(appComponent.getWarrior().toString());

        WarriorScreenComponent warriorScreenComponent = DaggerWarriorScreenComponent.builder().appComponent(appComponent).build();
        System.out.println(warriorScreenComponent.getPresenter());
        System.out.println(warriorScreenComponent.getPresenter());


        System.out.println("NEXT");
        warriorScreenComponent = DaggerWarriorScreenComponent.builder().appComponent(appComponent).build();
        System.out.println(warriorScreenComponent.getPresenter());
        System.out.println(warriorScreenComponent.getPresenter());
//        WarrwarriorScreenComponent = DaggerWarriorScreenComponent.builder()
//                .appComponent(appComponent)
//                .build()
//        warriorScreenComponent.inject(this)
    }
}
