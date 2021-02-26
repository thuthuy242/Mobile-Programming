package fit.mpr.mytube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    private int position;
    private RatingBar ratingBar;
    private TextView txtRating;
    private EditText edtComment;
    private Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        ratingBar = findViewById(R.id.ratingBar);
        txtRating = findViewById(R.id.txtRating);
        edtComment = findViewById(R.id.edtComment);
        btnSubmit = findViewById(R.id.btnSubmit);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtRating.setText((String.valueOf(rating)));
                switch ((int) ratingBar.getRating()){
                    case 1:
                        txtRating.setText("Very bad");
                        break;
                    case 2:
                        txtRating.setText("Normal");
                        break;
                    case 3:
                        txtRating.setText("Good");
                        break;
                    case 4:
                        txtRating.setText("Great");
                        break;
                    case 5:
                        txtRating.setText("Awesome. I love it ♥");
                        break;
                    default:
                        txtRating.setText("");
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtComment.getText().toString().isEmpty()){
                    Toast.makeText(PlayerActivity.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                }else{
                    txtRating.setText("");
                    edtComment.getText().clear();
                    ratingBar.setRating(0);
                    Toast.makeText(PlayerActivity.this, "Thank you for your feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Intent intent = getIntent();
        String link = intent.getStringExtra("LINK");

        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath(link);

        videoView.setMediaController(new MediaController(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        position = videoView.getCurrentPosition();
    }

    @Override
    protected void onStop() {
        super.onStop();

        videoView.stopPlayback();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("PLAYBACK", this.position);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        videoView.seekTo(savedInstanceState.getInt("PLAYBACK"));
    }










}