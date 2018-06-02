package com.example.pf_05.xmlparser;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.example.pf_05.xmlparser.Adapter.FoodListAdapter;
import java.util.List;

import dmax.dialog.SpotsDialog;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    List<Food> foodList;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.food_list);
        mLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        loadBreakFastMenu();
    }



    public void loadBreakFastMenu() {
        final android.app.AlertDialog dialog = new SpotsDialog(this);
        dialog.show();
        ApiInterface requestInterface = ApiClient.getClient();
        CompositeDisposable mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(requestInterface.getBreakfastType()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<BreakfastMenu>() {
                    @Override
                    public void onNext(BreakfastMenu breakfastMenu) {
                        dialog.dismiss();
                        foodList = breakfastMenu.getFoodList();
                        Log.d("FOODLSIT","FFOLDSD"+foodList.toString() + "DA "+foodList.get(0).getName());
                        setReqListAdapter(foodList);



                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Message " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {
                        dialog.dismiss();

                    }
                }));
    }

    private void setReqListAdapter(List<Food> foodList) {
        mRecyclerView.removeAllViews();
        mAdapter = new FoodListAdapter(MainActivity.this, foodList);
        mRecyclerView.setAdapter(mAdapter);

    }
}
