package edu.wgu.ai.cocoa;

import javax.inject.Inject;

public class Thermosiphon implements Pump {
    private final HCLogger logger;
    private final Heater heater;

    @Inject
    public Thermosiphon(HCLogger logger, Heater heater) {
        this.logger = logger;
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            logger.log("=> => pumping => => ts:" + this.hashCode());
        }
        else {
            logger.log("WATER NOT HOT ts:" + this.hashCode());
        }
    }
}
