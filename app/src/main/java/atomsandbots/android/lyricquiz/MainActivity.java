package atomsandbots.android.lyricquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.logobg);
        Picasso.get()
                .load(R.drawable.logobg)
                .fit()
                .centerInside()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);

        //Splash screen set for 4 seconds
        int SPLASH_TIME_OUT = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, StartQuiz.class);
                startActivity(intent);
                finish();
            }

        }, SPLASH_TIME_OUT);

    }
}
