package com.example.sgt_powell.practiceapp;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.parse.Parse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by SGT_POWELL on 11/14/2015.
 */
public class JSDJ extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        parseInit();
        getHASHKey();
    }

    public void getHASHKey(){
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.sgt_powell.practiceapp",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

    }
    public void parseInit(){
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.parseID1), getString(R.string.parseID2));
    }
}
