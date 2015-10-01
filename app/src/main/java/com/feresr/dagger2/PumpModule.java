package com.feresr.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando.raviola on 01/10/2015.
 */
@Module
public class PumpModule {
    @Provides Pump providesPump(Thermosiphon pump) {
        return pump;
    }
}
