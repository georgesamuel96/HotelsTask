package com.example.georgesamuel.dubaihotels.dagger2.modules;

import com.example.georgesamuel.dubaihotels.dagger2.scopes.HotelsVMCustomScope;

import dagger.Module;
import dagger.Provides;

@Module
public class HotelsVMModule {

    @HotelsVMCustomScope
    @Provides
    public HotelViewModel provideHotelViewModel(HotelViewModel hotelViewModel){
        return new HotelViewModel();
    }
}
