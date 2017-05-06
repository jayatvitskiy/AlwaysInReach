package com.example.jayat.edd_last;

/**
 * Created by yatvij on 4/28/2017.
 */
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jayat.edd_last.R;


public class Tab1 extends Fragment {

    private Button btnSend;
    private EditText txtPhoneNo;
    String message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        txtPhoneNo = (EditText) rootView.findViewById(R.id.txtPhoneNo);
        btnSend = (Button) rootView.findViewById(R.id.btnSend);
        sendSMS();
        return rootView;

    }


    public void sendSMS() {


        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String phoneNo = txtPhoneNo.getText().toString();
                message = "Your family member is in trouble!";
                if(phoneNo.length()>0){
                    sendMessage(phoneNo, message);
                } else
                {
                    Toast.makeText(getActivity().getBaseContext(), "SMS Sent.", Toast.LENGTH_LONG).show();

                }

            }

        });


    }

    private void sendMessage(String phoneNo,String message){

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null );
            Toast.makeText(getActivity().getApplicationContext(), "SMS Sent.", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getActivity().getApplicationContext(), "SMS fail. Please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }


}



