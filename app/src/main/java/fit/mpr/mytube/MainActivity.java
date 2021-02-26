package fit.mpr.mytube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;

    private Animation animTop, animBottom;
    private ImageView image;
    private TextView name, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animTop = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        animBottom = AnimationUtils.loadAnimation(this, R.anim.anim_bottom);

        image = findViewById(R.id.imgViewLogo);
        name= findViewById(R.id.txtName);
        slogan = findViewById(R.id.txtSlogan);

        image.setAnimation(animTop);
        name.setAnimation(animBottom);
        slogan.setAnimation(animBottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}