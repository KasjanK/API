package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowData extends AppCompatActivity {


    String url ="https://meme-api.herokuapp.com/gimme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Intent intent = getIntent();
        String strName = intent.getStringExtra(DataForm.EXTRA_NAME);
        float fLength = intent.getFloatExtra(DataForm.EXTRA_LENGTH, 0);
        int iAge = intent.getIntExtra(DataForm.EXTRA_AGE, 0);
        double dWage = intent.getDoubleExtra(DataForm.EXTRA_WAGE, 0);
        String strLetter = intent.getStringExtra(DataForm.EXTRA_LETTER);

        TextView name = (TextView) findViewById(R.id.name1);
        TextView length = (TextView) findViewById(R.id.length1);
        TextView age = (TextView) findViewById(R.id.age1);
        TextView wage = (TextView) findViewById(R.id.wage1);
        TextView letter = (TextView) findViewById(R.id.letter1);

        Button memeBtn = (Button) findViewById(R.id.memeBtn);

        memeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadMeme();
            }
        });

        name.setText("Your name: " + strName);
        length.setText("Your length in meters: " + fLength);
        age.setText("Your age: " + iAge);
        wage.setText("Your wage: " + dWage + "k kr");
        letter.setText("Your favorite letter: " + strLetter);
    }
    
    private void loadMeme() {
        final TextView textView = (TextView) findViewById(R.id.text);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {
                    try {
                        url = response.getString("url");
                        ImageView memeImageView = (ImageView) findViewById(R.id.memeImageView);
                        Glide.with(this).load(url).into(memeImageView);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();

                });
// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);

    }
}