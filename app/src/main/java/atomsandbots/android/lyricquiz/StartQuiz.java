package atomsandbots.android.lyricquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartQuiz extends AppCompatActivity {

    @BindView(R.id.start_btn)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        ButterKnife.bind(this);
        //start quiz via intent
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartQuiz.this, QuestionActivity.class);
                startActivity(intent);

            }
        });

    }
}
