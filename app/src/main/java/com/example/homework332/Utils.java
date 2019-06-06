package com.example.homework332;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_SMALL = 1;
    public final static int THEME_AVERAGE = 2;
    public final static int THEME_BIG = 3;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            case THEME_SMALL:
                activity.setTheme(R.style.MarginSmall);
                break;
            case THEME_AVERAGE:
                activity.setTheme(R.style.MarginAverage);
                break;
            case THEME_BIG:
                activity.setTheme(R.style.MarginBig);
                break;
        }
    }
}
