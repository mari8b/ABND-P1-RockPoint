package com.example.android.rockpoint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.rockpoint.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showWebPage(View view) {
        TextView webPage = (TextView) findViewById(R.id.web_page);
        openWebPage(webPage.getText().toString());
    }

    public void phoneCall(View view) {
        TextView phone = (TextView) findViewById(R.id.phone);
        dialPhoneNumber(phone.getText().toString());
    }

    public void showOnMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=RockPoint+Americka+2796/54+301+00+Plzen+Czech"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method sends phone number to the dialer.
     *
     * @param phoneNumber defines the phone number
     */
    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method opens web page in a browser.
     *
     * @param url defines the webpage URL (without http://)
     */
    private void openWebPage(String url) {
        Uri webpage = Uri.parse("http://" + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}