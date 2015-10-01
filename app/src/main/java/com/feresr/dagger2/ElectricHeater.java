package com.feresr.dagger2;

import android.util.Log;

/**
 * Created by fernando.raviola on 01/10/2015.
 */
public class ElectricHeater implements Heater {

    boolean isHeating = false;

    @Override
    public void on() {
        isHeating = true;
        Log.e(ElectricHeater.class.getSimpleName(), "~~~~Boiling water~~~~");
    }

    @Override
    public void off() {
        this.isHeating = false;
    }

    @Override
    public boolean isHot() {
        return isHeating;
    }
}
