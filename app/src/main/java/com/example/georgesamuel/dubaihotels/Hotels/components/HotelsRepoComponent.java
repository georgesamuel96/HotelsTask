package com.example.georgesamuel.dubaihotels.Hotels.components;

import com.example.georgesamuel.dubaihotels.Hotels.scopes.HotelsCustomScope;
import com.example.georgesamuel.dubaihotels.Hotels.viewModel.HotelViewModel;
import com.example.georgesamuel.dubaihotels.Hotels.modules.HotelsRepoModule;

import dagger.Component;

@HotelsCustomScope
@Component(dependencies = {RetrofitClientComponent.class},modules = {HotelsRepoModule.class})
public interface HotelsRepoComponent {

    void inject(HotelViewModel hotelViewModel);

    class Intializer {
        static HotelsRepoComponent hotelsRepoComponent;

        public static HotelsRepoComponent buildComponent() {
            if (hotelsRepoComponent == null) {
                hotelsRepoComponent = DaggerHotelsRepoComponent.builder()
                        .retrofitClientComponent(RetrofitClientComponent.Intializer.buildComponent()).build();
            }
            return hotelsRepoComponent;
        }

    }
}
