package com.feresr.dagger2;

import android.util.Log;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by fernando.raviola on 01/10/2015.
 */
public class CoffeeMaker {
    private final Lazy<Heater> heater;
    private final Pump pump;

    @Inject
    CoffeeMaker(Lazy<Heater> heater, Pump pump){
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.get().on();
        pump.pump();
        Log.e(CoffeeMaker.class.getSimpleName(), "COOOOFEEEE!");
        heater.get().off();
    }
}
