package com.sample.goodwords;

import android.app.Application;

import com.sample.goodwords.ui.gallery.Gallery;

import java.util.ArrayList;

public class ApplicationClass extends Application {
  public static ArrayList<Integer> positionList = new ArrayList<>();


  @Override
  public void onCreate() {
    super.onCreate();

  }
}
