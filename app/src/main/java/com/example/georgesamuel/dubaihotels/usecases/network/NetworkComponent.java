package com.example.georgesamuel.dubaihotels.usecases.network;

import com.example.georgesamuel.dubaihotels.usecases.hotelsrepository.HotelsRepository;

import dagger.Component;

@CustomScope
@Component(dependencies = ApplicationComponent.class , modules ={NetworkModule.class})
public interface NetworkComponent {
    void inject(HotelsRepository repository);
}


