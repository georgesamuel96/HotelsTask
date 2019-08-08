package com.example.georgesamuel.dubaihotels.dagger2.modules;

import com.example.georgesamuel.dubaihotels.dagger2.ClientAPI;
import com.example.georgesamuel.dubaihotels.dagger2.scopes.HotelsCustomScope;
import com.example.georgesamuel.dubaihotels.dagger2.HotelsRepository;

import dagger.Module;
import dagger.Provides;


@Module
public class HotelsRepoModule {

    @HotelsCustomScope
    @Provides
    public HotelsRepository provideHotelsRepo(ClientAPI clientAPI) {
        return new HotelsRepository(clientAPI);
    }
}
