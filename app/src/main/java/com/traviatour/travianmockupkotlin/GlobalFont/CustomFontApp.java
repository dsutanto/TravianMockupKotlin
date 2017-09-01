package com.traviatour.travianmockupkotlin.GlobalFont;

import android.app.Application;

public class CustomFontApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/poppins_reg.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/poppins_reg.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/poppins_reg.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/poppins_reg.ttf");
    }
}
