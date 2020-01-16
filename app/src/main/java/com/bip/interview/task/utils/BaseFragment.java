package com.bip.interview.task.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.bip.interview.task.MainActivity;

import java.util.Locale;

public class BaseFragment extends Fragment {

    protected void setDefaultLocale() {
        String selectedLanguage = new SharedPref(getActivity()).getLanguage();
        changeLocale(selectedLanguage);
    }

    protected void changeLocale(String newLocale) {
        new SharedPref(getActivity()).setLanguage(getActivity(), newLocale);
        Locale locale = new Locale(newLocale);
        Locale.setDefault(locale);
        Configuration configuration = getActivity().getResources().getConfiguration();
        configuration.setLocale(locale);
        getActivity().createConfigurationContext(configuration);
        configuration.setLayoutDirection(locale);
        Window window = null;
        if (newLocale.equals(Constants.ARABIC_LANG)) {
            window.getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        } else {
            window.getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        restartApp();
    }

    protected int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    protected int getScreenHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    protected boolean isTablet() {
        return new SharedPref(getActivity()).isTablet();
    }

    protected void showShortToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    protected void showMessageAlert(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void restartApp() {
        Intent intent = new  Intent(getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    protected ProgressDialog getProgressDialog(Context context, String msg) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        return progressDialog;
    }
}
