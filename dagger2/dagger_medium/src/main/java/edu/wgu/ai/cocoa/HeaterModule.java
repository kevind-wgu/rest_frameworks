package edu.wgu.ai.cocoa;

import dagger.Binds;
import dagger.Module;

import javax.inject.Singleton;

@Module
public interface HeaterModule {
    @Singleton
    @Binds
    Heater heater(ElectricHeater impl);
}
