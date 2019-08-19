package com.example.georgesamuel.dubaihotels.Hotels.components;

import com.example.georgesamuel.dubaihotels.Hotels.remote.ClientAPI;
import com.example.georgesamuel.dubaihotels.Hotels.modules.RetrofitClientModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitClientModule.class})
public interface RetrofitClientComponent {

    ClientAPI getClientApi();


    class Intializer {
        static RetrofitClientComponent retrofitComponent;

       public static RetrofitClientComponent buildComponent() {
            if (retrofitComponent == null) {
                retrofitComponent = DaggerRetrofitClientComponent.builder()
                        .retrofitClientModule(new RetrofitClientModule()).build();
            }
            return retrofitComponent;
        }

    }
}
