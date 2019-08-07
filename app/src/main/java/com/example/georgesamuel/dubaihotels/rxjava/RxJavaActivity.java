package com.example.georgesamuel.dubaihotels.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.georgesamuel.dubaihotels.R;

import hu.akarnokd.rxjava2.math.MathObservable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;


public class RxJavaActivity extends AppCompatActivity {
    private static final String TAG = RxJavaActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        Integer[] numbers = {1, 1, 3, 4, 5, 6, 7, 9, 9, 10, 11, 12};
        Integer[] numbers2 = {4, 0, 7, 0, 1, 3, 2, 0, 6, 0, 0, 7};
      //  AsyncSubject<Integer> source = AsyncSubject.create();
        Observable<Integer> source =Observable.fromArray(numbers);
        Observable<Integer>source3 =Observable.fromArray(numbers);
        MathObservable.sumInt(source3).subscribe(getSecondObserver());
        Observable<Integer> source2 =Observable.fromArray(numbers2);
        Observable.zip(source,source2,new BiFunction<Integer, Integer, Integer>(){

            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                int x= integer+integer2;
                return x;
            }}).subscribe(getSecondObserver());

// It will get 4 and onComplete for second observer also.
      //  source.subscribe(getSecondObserver());

//        source.onNext(4);
//        source.onComplete();
    }

    private Observer<String> getFirstObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " First onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {

                Log.d(TAG, " First onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {

                Log.d(TAG, " First onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {

                Log.d(TAG, " First onComplete");
            }
        };
    }

    private Observer<Integer> getSecondObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " Second onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(Integer value) {

                Log.d(TAG, " Second onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {

                Log.d(TAG, " Second onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {

                Log.d(TAG, " Second onComplete");
            }
        };
    }

}
