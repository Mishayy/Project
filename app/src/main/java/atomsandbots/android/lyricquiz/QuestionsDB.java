package atomsandbots.android.lyricquiz;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsDB extends AppCompatActivity {


    private String[] mQuestions = {
            "\"It was all a dream, I used to read Word Up! magazine\"",
            "\"Now, I ain't sayin' you a gold digger, you got needs\"",
            "\"Real Gs move in silence like lasagna\"",
            "\"So I ball so hard muh'fcukas wanna fine me\"",
            "\"These expensive, these is red bottoms\"",
            "\"Wait, if I'm in Dicky's body, Breezy is who\"",
            "\"They was never friendly, yeah, Now I'm jumping out the Bentley, yeah\"",
            "\"Don't save her, she don't wanna be saved\"",
            "\"Yeah, you're lookin' at the truth, the money never lie no\"",
            "\"Pullin' out the coupe at the lot, Told 'em Fuck 12, fcuk SWAT\"",
            "\"This very moment I slay Goliath with a sling\"",
            "\"I look damn good I ain't lost it, And I ain't missed a beat\"",
    };

    private String[][] mChoices = {
            {"Nas", "Funkmaster Flex", "The Notorious B.I.G"},
            {"Gold Digger", "Jamie Foxx", "Kanye West"},
            {"Lil Wayne", "Lil Dicky", "Lil Jon"},
            {"Jay-Z", "J. Cole", "Snoop Dogg"},
            {"Bodak Yellow", "Cardi B", "Nicki Minaj"},
            {"Lil Dicky", "Chris Brown", "Omarion"},
            {"Justin Bieber", "Post Malone", "Congratulations"},
            {"J. Cole", "Kendrick Lamar", "DJ Khaled"},
            {"DJ Khaled", "Justin Bieber", "Quavo"},
            {"The Box", "Roddy Rich", "Drake"},
            {"Cardi B", "Beyonce", "Nicki Minaj"},
            {"Beyonce", "Nicki Minaj", "Ciara"},
    };

    private String[] mCorrectAnswers = {"The Notorious B.I.G", "Kanye West", "Lil Wayne", "Jay-Z"
            , "Cardi B", "Lil Dicky", "Post Malone", "J. Cole", "Justin Bieber", "Roddy Rich", "Nicki Minaj", "Beyonce"};


    public String getQuestion(int a) {
        return mQuestions[a];
    }


    public String getChoice1(int a) {
        return mChoices[a][0];
    }


    public String getChoice2(int a) {
        return mChoices[a][1];
    }

    public String getChoice3(int a) {
        return mChoices[a][2];
    }


    public String getCorrectAnswer(int a) {
        return mCorrectAnswers[a];
    }

}
