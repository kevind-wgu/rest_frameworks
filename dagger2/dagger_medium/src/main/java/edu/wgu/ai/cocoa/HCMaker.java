package edu.wgu.ai.cocoa;

import dagger.Lazy;

import javax.inject.Inject;

public class HCMaker {
    private final HCLogger logger;
    private final Lazy<Heater> heater;
    private final Pump pump;

    @Inject
    public HCMaker(HCLogger logger, Lazy<Heater> heater, Pump pump) {
        this.logger = logger;
        this.heater = heater;
        this.pump = pump;
    }

    public void make() {
        logger.log("MAKING - " + this.hashCode());
        heater.get().on();
        pump.pump();
        heater.get().off();
        pump.pump();
        logger.log("DONE MAKING - " + this.hashCode());
    }
}
