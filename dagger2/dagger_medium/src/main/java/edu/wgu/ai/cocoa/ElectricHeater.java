package edu.wgu.ai.cocoa;

import javax.inject.Inject;

public class ElectricHeater implements Heater {
    private final HCLogger logger;
    private boolean heating;

    @Inject
    public ElectricHeater(HCLogger logger) {
        this.logger = logger;
    }

    @Override
    public void on() {
        this.heating = true;
        logger.log("~ ~ ~ heating ~ ~ ~ eh:" + this.hashCode());
    }

    @Override
    public void off() {
        this.heating = false;
        logger.log("~ ~ ~ heating off ~ ~ ~ eh:" + this.hashCode());
    }

    @Override
    public boolean isHot() {
        logger.log("isHot - eh:" + this.hashCode());
        return heating;
    }
}
