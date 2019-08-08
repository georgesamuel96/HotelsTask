package com.example.georgesamuel.dubaihotels.dagger2.components;

import com.example.georgesamuel.dubaihotels.dagger2.Dagger2Activity;
import com.example.georgesamuel.dubaihotels.dagger2.scopes.HotelsVMCustomScope;
import com.example.georgesamuel.dubaihotels.dagger2.modules.HotelsVMModule;

import dagger.Component;

@HotelsVMCustomScope
@Component(dependencies = HotelsRepoComponent.class, modules = HotelsVMModule.class)
public interface HotelVMComponent {
    void inject(Dagger2Activity activity);

    class Initializer{
        static HotelVMComponent hotelVMComponent;

        public static HotelVMComponent buildComponent(){
            if(hotelVMComponent == null){
               hotelVMComponent = DaggerHotelVMComponent.builder()
                       .hotelsRepoComponent(HotelsRepoComponent.Intializer.buildComponent()).build();
            }
            return hotelVMComponent;
        }
    }
}
