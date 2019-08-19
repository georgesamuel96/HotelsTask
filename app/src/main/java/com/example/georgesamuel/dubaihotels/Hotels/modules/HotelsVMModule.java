package com.example.georgesamuel.dubaihotels.Hotels.modules;

import com.example.georgesamuel.dubaihotels.Hotels.scopes.HotelsVMCustomScope;
import com.example.georgesamuel.dubaihotels.Hotels.viewModel.HotelViewModel;

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
