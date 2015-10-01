package com.feresr.dagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando.raviola on 01/10/2015.
 */
@Module(includes = PumpModule.class)
public class DripCoffeModule {
    @Provides @Singleton Heater provideHeater() {
        return new ElectricHeater();
    }
}
