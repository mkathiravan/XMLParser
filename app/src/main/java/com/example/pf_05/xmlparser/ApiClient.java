package com.example.pf_05.xmlparser;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by pf-05 on 6/2/2018.
 */

public class ApiClient {

    private static ApiInterface requestInterface;



    public static ApiInterface getClient() {

        if(requestInterface==null) {

            requestInterface = new Retrofit.Builder()
                    .baseUrl("https://www.w3schools.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build().create(ApiInterface.class);
        }
        return requestInterface;
    }

}
