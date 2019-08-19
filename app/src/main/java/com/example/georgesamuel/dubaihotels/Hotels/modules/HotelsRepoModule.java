package com.example.georgesamuel.dubaihotels.Hotels.modules;

import com.example.georgesamuel.dubaihotels.Hotels.remote.ClientAPI;
import com.example.georgesamuel.dubaihotels.Hotels.scopes.HotelsCustomScope;
import com.example.georgesamuel.dubaihotels.Hotels.repository.HotelsRepository;

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
