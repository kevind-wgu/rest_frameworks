package edu.wgu.ai.cocoa;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PumpModule {
    @Binds
    abstract Pump pump(Thermosiphon ts);
}
