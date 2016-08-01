package com.example.user.imfreezing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String parseID="HEpMWo74qsUhonIWbcYYDMVrIw9fYZH7G7sem0OA";
        String parseKey="yqomyfxq5hVBg2GJNDvq4E7jteyVqQGUFFi4mzmj";
        Parse.enableLocalDatastore(getApplicationContext());
        Parse.initialize(this, parseID, parseKey);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
        setContentView(R.layout.activity_main);
        getUsersDataFromParse();
    }

    public void getUsersDataFromParse() {
        final ParseQuery<ParseObject> totalAmount = ParseQuery.getQuery("Users");
        totalAmount.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> names, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < names.size(); i++) {
                        Log.d("ZAQ", names.get(i).getString("firstName"));
                        Toast.makeText(getApplicationContext(), names.get(i).getString("firstName"), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }
}
