package it.jaschke.alexandria;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Phil on 9/20/2015.
 */
public class Utilities {

    //Check to see if network is available, if not handle gracefully
    static public boolean isNetworkAvailable(Context c) {
        ConnectivityManager cm = (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    //Close keyboard if open and not need
    static public void checkKeyboardFocus(Activity a) {
        // Check if no view has focus:
        View view = a.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)a.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
