package com.example.georgesamuel.dubaihotels.RxJava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.georgesamuel.dubaihotels.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {

    private static final String TAG = RxJavaActivity.class.getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Disposable singleDisposable;
    private Disposable maybeDisposable;
    private Disposable completableDisposable;
    private Disposable flowableDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        //useObjectAsParameter();
        //useChainingOperators();
        //userSingleObservable();
        //useMaybeObservable();
        //useCompletableObservable();
        //useFlowableObservable();
    }

    /*
        When you use flowableObservable, you have to be use a strategy called Backpressure
     */
    private void useFlowableObservable(){
        Flowable<Integer> flowableObservable = getFlowableObservable();
        SingleObserver<Integer> singleObserver = getFlowableObserver();
        flowableObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .reduce(0, (result, number) -> (result + number))
                .subscribe(singleObserver);
    }

    private SingleObserver<Integer> getFlowableObserver(){
        return new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                flowableDisposable = d;
            }

            @Override
            public void onSuccess(Integer integer) {
                Log.d(TAG, "onSuccess: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }
        };
    }

    private Flowable<Integer> getFlowableObservable(){
        return Flowable.range(1, 100);
    }

    private void useCompletableObservable(){
        Note note = new Note(1, "New George");
        Completable completableObservable = getCompletableObservable(note);
        CompletableObserver completableObserver = getCompletableObserver();
        completableObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(completableObserver);
    }
    
    private CompletableObserver getCompletableObserver(){
        return new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
                completableDisposable = d;
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Completable");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }
        };
    }

    private Completable getCompletableObservable(Note note){
        return Completable.create(emitter -> {
            if(!emitter.isDisposed()){
                // update note {use it when you want to update value in server}
                note.setNote("Updated George");
            }
            emitter.onComplete();
        });
    }

    private void useMaybeObservable(){
        Maybe<Note> maybeObservable = getMaybeObservable();
        MaybeObserver<Note> maybeObserver = getMaybeObserver();
        maybeObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(maybeObserver);
    }

    private MaybeObserver<Note> getMaybeObserver(){
        return new MaybeObserver<Note>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                maybeDisposable = d;
            }

            @Override
            public void onSuccess(Note note) {
                Log.d(TAG, "onSuccess: " + note.getNote());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Maybe Observable");
            }
        };
    }

    private Maybe<Note> getMaybeObservable(){
        return Maybe.create(emitter ->  {
                Note note = new Note(1, "Maybe George Note");
                if(!emitter.isDisposed())
                    emitter.onSuccess(note);
        });
    }

    private void userSingleObservable(){
        Single<Note> singleObservable = getSingleObservable();
        SingleObserver<Note> singleObserver = getSingleObserver();
        singleObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(singleObserver);
    }

    private SingleObserver<Note> getSingleObserver(){
        return new SingleObserver<Note>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                singleDisposable = d;
            }

            @Override
            public void onSuccess(Note note) {
                Log.d(TAG, "onSuccess: " + note.getNote());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }
        };
    }

    private Single<Note> getSingleObservable(){
        return Single.create(emitter ->  {
                Note note = new Note(1, "George Note");
                emitter.onSuccess(note);
            }
        );
    }

    private void useChainingOperators(){
        Observable.range(1,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(integer -> (integer % 2 == 0))
                .map(integer -> integer + " is Even Number")
                .subscribe(getIntegersObserver());
    }

    private DisposableObserver<String> getIntegersObserver(){
        return new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Even Integers");
            }
        };
    }

    private void useObjectAsParameter(){
        compositeDisposable.add(
                getNotesObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(note -> (note.getNote().length() > 13))
                        .map(note -> {
                            note.setNote(note.getNote().toUpperCase());
                            return (note);
                        })
                        .subscribeWith(getNotesObserver())
        );
    }

    private DisposableObserver<Note> getNotesObserver() {
        return new DisposableObserver<Note>() {
            @Override
            public void onNext(Note note) {
                Log.d(TAG, "onNext: " + note.getNote());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Notes");
            }
        };
    }

    private Observable<Note> getNotesObservable() {
        final List<Note> list = getNotes();
        return Observable.create(emitter -> {
            for(Note note : list){
                if(!emitter.isDisposed()){
                    emitter.onNext(note);
                }
            }
            if(!emitter.isDisposed()){
                emitter.onComplete();
            }
        });
    }

    private List<Note> getNotes(){
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1, "buy tooth paste!"));
        notes.add(new Note(2, "call brother!"));
        notes.add(new Note(3, "watch narcos tonight!"));
        notes.add(new Note(4, "pay power bill!"));
        return notes;
    }

    class Note{
        private int id;
        private String note;

        public Note(int id, String note){
            this.id = id;
            this.note = note;
        }

        public int getId() {
            return id;
        }

        public String getNote() {
            return note;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNote(String note) {
            this.note = note;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
        singleDisposable.dispose();
        maybeDisposable.dispose();
        completableDisposable.dispose();
        flowableDisposable.dispose();
    }
}
