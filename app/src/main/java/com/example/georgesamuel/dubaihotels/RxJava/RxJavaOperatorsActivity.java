package com.example.georgesamuel.dubaihotels.RxJava;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.georgesamuel.dubaihotels.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaOperatorsActivity extends AppCompatActivity {

    private static final String TAG = RxJavaOperatorsActivity.class.getSimpleName();
    private Disposable mapDisposal;
    private Disposable flatMapDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        //useMapOperator();
        //useFlatMapOperator();
    }

    private void useFlatMapOperator(){
        getUserObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<User, Observable<User>>() {
                    @Override
                    public Observable<User> apply(User user) throws Exception {
                        return getEmailObservable(user);
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");
                        flatMapDisposable = d;
                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext: " + user.getName() + " " + user.getEmail());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: FlatMap");
                    }
                });
    }

    private Observable<User> getEmailObservable(final User user){
        List<Email> list = new ArrayList<>();
        for(int i = 5; i >= 1; i--){
            list.add(new Email(i + "@george.com"));
        }
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                Email email = new Email();
                email.setEmail(list.get(new Random().nextInt(4)).getEmail());
                if(!emitter.isDisposed()){
                    user.setEmail(email.getEmail());
                    emitter.onNext(user);
                    emitter.onComplete();
                }
            }
        });
    }

    private void useMapOperator(){
        getUserObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(user -> {
                    user.setEmail(String.format("%s@goerge.com", user.getName()));
                    return user;
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");
                        mapDisposal = d;
                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext: " + user.getEmail());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: MapOperator");
                    }
                });
    }

    private Observable<User> getUserObservable(){
        List<User> list = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            User user = new User();
            user.setName(String.valueOf(i));
            user.setGender("male");
            list.add(user);
        }
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                for(User user : list){
                    if(!emitter.isDisposed()){
                        emitter.onNext(user);
                    }
                }
                if(!emitter.isDisposed()){
                    emitter.onComplete();
                }
            }
        });
    }

    class User{
        private String name;
        private String email;
        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    class Email{
        private String email;

        public Email(String email){
            this.email = email;
        }

        public Email(){}

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapDisposal.dispose();
        flatMapDisposable.dispose();
    }
}
