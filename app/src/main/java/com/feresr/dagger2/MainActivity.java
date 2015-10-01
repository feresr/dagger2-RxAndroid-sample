package com.feresr.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.view.ViewClickEvent;

import java.util.List;
import java.util.Random;

import javax.inject.Singleton;

import dagger.Component;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    @Singleton
    @Component(modules = {DripCoffeModule.class})
    public interface Coffee {
        CoffeeMaker maker();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Observable<String> urlStream = RxView.clickEvents(findViewById(R.id.mybtn)).map(new Func1<ViewClickEvent, String>() {
            @Override
            public String call(ViewClickEvent viewClickEvent) {
                String s = "https://api.github.com/users?since=" + new Random().nextInt(500);
                return s;
            }
        });

        urlStream.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("urlStream", "completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("urlStream", "completed");
            }

            @Override
            public void onNext(String s) {
                Log.e("urlStream", "onNext");

                Observable<List<User>> userStream = GitHubApi.getService().getUsers();

                userStream.subscribe(new Observer<List<User>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("github", "completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("github", e.toString());
                    }

                    @Override
                    public void onNext(List<User> users) {
                        Log.e("github", users.get(0).getLogin());
                    }
                });
            }
        });

        findViewById(R.id.mybtn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "https://api.github.com/users?since=" + new Random().nextInt(500);
                Log.e("rx", s);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Coffee coffee = DaggerMainActivity_Coffee.builder().build();
        coffee.maker().brew();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
