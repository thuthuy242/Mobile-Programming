package fit.mpr.mytube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    private ImageButton btnPlay;
    private TextView txtWelcome, txtHint;
    private EditText edtLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnPlay = findViewById(R.id.btnPlay);
        edtLink = findViewById(R.id.edtLink);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = edtLink.getText().toString();

//                Toast.makeText(HomeScreen.this, link, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeScreen.this, PlayerActivity.class);
                intent.putExtra("LINK", link);
                startActivity(intent);

            }
        });

    }


}