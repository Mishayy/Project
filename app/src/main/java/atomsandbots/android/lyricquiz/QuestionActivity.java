package atomsandbots.android.lyricquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionActivity extends AppCompatActivity {

    @BindView(R.id.option_1)
    Button mOption1;
    @BindView(R.id.option_2)
    Button mOption2;
    @BindView(R.id.option_3)
    Button mOption3;
    @BindView(R.id.question_one)
    TextView mQuestionView;
    @BindView(R.id.Score)
    TextView mScoreView;
    @BindView(R.id.timer_text_view)
    TextView mTimer;
    @BindView(R.id.next_button)
    TextView mNext;
    @BindView(R.id.back_to_Start_text_view)
    TextView mBackToStart;
    @BindView(R.id.score_label)
    TextView mScoreLabel;
    @BindView(R.id.timer_label)
    TextView mTimerLabel;
    @BindView(R.id.final_score_view)
    TextView mFinalScore;

    @BindView(R.id.atoms_and_bots_iv)
    ImageView mABIv;

    private static final long COUNTDOWN_IN_MILLIS = 12000;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private String mAnswer;
    private int mScore;
    private int mQuestionNumber = 0;
    private long backPressedTime;


    // instance of "DB"
    private QuestionsDB questionsDB = new QuestionsDB();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        ButterKnife.bind(this);

        //Back to start and ABIv always invisible until the end.
        mBackToStart.setVisibility(View.GONE);
        mABIv.setVisibility(View.GONE);

        updateQuestion();

        Picasso.get()
                .load(R.drawable.atomsandbots)
                .fit()
                .centerInside()
                .placeholder(R.drawable.ic_launcher_background)
                .into(mABIv);


        //onclickListener for the first choice
        mOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((mOption1.getText() == mAnswer)) {
                    mScore = mScore + 1;
                    updateScore();
                    nextUpdate();
                    countDownTimer.cancel();
                    mNext.setVisibility(View.VISIBLE);

                } else {
                    nextUpdate();
                    countDownTimer.cancel();
                    mNext.setVisibility(View.VISIBLE);
                }

            }
        });//end of 1st listener

        //onclickListener for the second choice
        mOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((mOption2.getText() == mAnswer)) {
                    //if answer is correct increment score by one
                    mScore = mScore + 1;
                    updateScore();
                    nextUpdate();
                    countDownTimer.cancel();
                    mNext.setVisibility(View.VISIBLE);

                } else {
                    nextUpdate();
                    countDownTimer.cancel();
                    mNext.setVisibility(View.VISIBLE);
                }

            }
        });//end of 2nd onclick listener

        //onclickListener for the third choice
        mOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((mOption3.getText() == mAnswer)) {
                    mScore = mScore + 1;
                    updateScore();
                    nextUpdate();
                    countDownTimer.cancel();
                    mNext.setVisibility(View.VISIBLE);

                } else {
                    nextUpdate();
                    countDownTimer.cancel();
                    mNext.setVisibility(View.VISIBLE);
                }

            }
        });//end of third onclick listener

        //onclickListener for Next button
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();


            }
        });//end of 'Next' onclick listener


        // OnclickListener for returning to the start menu
        mBackToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(QuestionActivity.this, StartQuiz.class);
                startActivity(intent);

            }
        });//END OF ONCLICK LISTENER
    }

    //logic for resetting the questions and choices
    private void updateQuestion() {

        //The code below resets the option
        mOption1.setVisibility(View.VISIBLE);
        mOption2.setVisibility(View.VISIBLE);
        mOption3.setVisibility(View.VISIBLE);
        mNext.setVisibility(View.INVISIBLE);

        int questionSize = 12;

        if (mQuestionNumber < questionSize) {

            mQuestionView.setText((questionsDB.getQuestion(mQuestionNumber)));
            mOption1.setText(questionsDB.getChoice1(mQuestionNumber));
            mOption2.setText(questionsDB.getChoice2(mQuestionNumber));
            mOption3.setText(questionsDB.getChoice3(mQuestionNumber));

            mAnswer = questionsDB.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();


        } else {
            displayScore();
        }

    }

    //30 second CountDownTimer
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {

                timeLeftInMillis = 0;
                //if the counter hits zero question options will disappear
                mOption1.setVisibility(View.GONE);
                mOption2.setVisibility(View.GONE);
                mOption3.setVisibility(View.GONE);
                mNext.setVisibility(View.VISIBLE);
                mNext.setText(R.string.next_tv_java);
                //Toast.makeText(QuestionActivity.this, "TIMED OUT", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    //Below is the code for updating the Text for the CountdownTimer and Format
    private void updateCountdownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTimer.setText(timeFormatted);
    }

    //update logic
    private void nextUpdate() {
        // This is the logic to remove the choices after a view has been consumed
        if (mOption1.isPressed() || mOption2.isPressed() || mOption3.isPressed()) {
            mOption1.setVisibility(View.GONE);
            mOption2.setVisibility(View.GONE);
            mOption3.setVisibility(View.GONE);
            mNext.setVisibility(View.VISIBLE);
            mNext.setTextColor(Color.WHITE);
            mNext.setText(R.string.next_text_view_java);
        }
    }


// Updating the score
    private void updateScore() {
        mScoreView.setText(mScore + " of 12");
    }

    // Logic to display the final score after all questions have been answered
    @SuppressLint("SetTextI18n")
    private void displayScore() {


        mFinalScore.setText("Final score: " + mScore);
        mQuestionView.setVisibility(View.GONE);
        mOption1.setVisibility(View.GONE);
        mOption2.setVisibility(View.GONE);
        mOption3.setVisibility(View.GONE);
        mNext.setVisibility(View.GONE);
        mTimer.setVisibility(View.GONE);
        mScoreView.setVisibility(View.GONE);
        mScoreLabel.setVisibility(View.GONE);
        mTimerLabel.setVisibility(View.GONE);
        mBackToStart.setVisibility(View.VISIBLE);
        mABIv.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    //If back pressed twice the quiz will finish
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finish();
        } else {
            Toast.makeText(QuestionActivity.this, "Press Back Again Close Quiz", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}
