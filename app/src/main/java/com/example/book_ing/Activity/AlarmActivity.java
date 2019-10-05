package com.example.book_ing.Activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import com.example.book_ing.R;

import java.io.File;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

//import android.support.v4.content.FileProvider;
//import android.support.v7.app.AppCompatActivity;

public class AlarmActivity extends AppCompatActivity {
    static final int REQUEST_TAKE_PHOTO = 1;
    private String photoPath = null;
    private String object;
    MediaPlayer mediaPlayer;
    TextView info;

    private class ClarifaiTask extends AsyncTask<File, Integer, Boolean> {


        protected Boolean doInBackground(File... images) {
            info.setText("Processing...");

            Intent i = new Intent(AlarmActivity.this,TimerActivity.class);
            startActivity(i);

//            ClarifaiClient client = new ClarifaiBuilder("YOUR_API_TOKEN").buildSync();
//            List<ClarifaiOutput<Concept>> predictionResults;
//
//            for (File image : images) {
//                predictionResults = client.getDefaultModels().generalModel().predict()
//                        .withInputs(ClarifaiInput.forImage(image))
//                        .executeSync()
//                        .get();
//
//                for (ClarifaiOutput<Concept> result : predictionResults) {
//                    for (Concept datum : result.data()) {
//
//                        if (datum.name().contains(object.toLowerCase()))
//                            return true;
//                    }
//                }
//            }

            return false;
        }

        protected void onPostExecute(Boolean result) {
            // Delete photo
            (new File(photoPath)).delete();
            photoPath = null;

            // If image contained object, close the AlarmActivity
            if (result) {
                info.setText("Success!");
                finish();
            } else info.setText("Try again...");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        object = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        info = findViewById(R.id.infoText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Uri myUri = RingtoneManager.getActualDefaultRingtoneUri(this, RingtoneManager.TYPE_RINGTONE);
        mediaPlayer = new MediaPlayer();

        class Listener implements MediaPlayer.OnPreparedListener {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        }
        mediaPlayer.setOnPreparedListener(new Listener());

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.prepareAsync();


    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile;
            try {
                File storageDir = getFilesDir();
                photoFile = File.createTempFile(
                        "SNAPSHOT",
                        ".jpg",
                        storageDir
                );

                photoPath = photoFile.getAbsolutePath();
            } catch (IOException ex) {
                return;
            }

            Uri photoURI = FileProvider.getUriForFile(this,
                    "com.mkhrenov.clarifaialarm.fileprovider",
                    photoFile);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (photoPath != null) {
            new ClarifaiTask().execute(new File(photoPath));
        }
    }

}
