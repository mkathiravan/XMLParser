package com.example.pf_05.xmlparser;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by pf-05 on 6/2/2018.
 */

public interface ApiInterface {
    @GET("/xml/simple.xml")
    Observable<BreakfastMenu> getBreakfastType();





}
