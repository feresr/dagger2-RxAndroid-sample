package com.feresr.dagger2;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by fernando.raviola on 01/10/2015.
 */
public class Thermosiphon implements Pump {

    private final Heater heater;

    @Inject
    public Thermosiphon(Heater heater) {
        this.heater = heater;
    }


    @Override
    public void pump() {
        if (heater.isHot()) {
            Log.e(Thermosiphon.class.getSimpleName(), "=>=>Pumping=>=>");
        }
    }
}
