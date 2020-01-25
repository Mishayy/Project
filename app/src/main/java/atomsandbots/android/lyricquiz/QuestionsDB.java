package atomsandbots.android.lyricquiz;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsDB extends AppCompatActivity {




    private String mQuestions[] = {
            "Q1: What does USB stand for?",
            "Q2: What is the capital city of Canada?",
            "Q3: Who was the 16th president of the United States?",
            "Q4: Which political party freed the slaves in the United States?",
            "Q5: Which african countries were not colonized?",
            "Q6: What was coca-cola first marketed as?",
            "Q7: What type of creature is a Red Mullet?",
            "Q8: Who is Thor's father?",
            "Q9: In which year was Apple founded?",
            "Q10: What does 'Phillia' refer to?",
            "Q11: How old was Jimi Hendrix when he lost his virginity?",
            "Q12: Where is tea from?",
    };

    private String mChoices[][] = {
            {"Universal Saving Biometric", "Universal Serial Bus", "Universal Saving Bio-Port"},
            {"Quebec", "Ottawa", "Ontario"},
            {"Dwight Eisenhower", "Abraham Lincoln", "Franklin D. Roosevelt"},
            {"The Green Party", "The Democratic party", "Grand Old Party (GOP)"},
            {"Libya and Eritrea", "Ethiopia and Liberia", "Ethiopia and Libya"},
            {"Floor Cleaner", "Metal Cleaner", "Medicine"},
            {"Fish", "Bird", "Dog"},
            {"Odin", "Loki", "Thanos"},
            {"1980", "1992", "1976"},
            {"Love", "Hate", "Fear"},
            {"9 years old", "12 years old", "26 years old"},
            {"Chad", "China", "England"},
    };

    private String mCorrectAnswers[] = {"Universal Serial Bus", "Ottawa", "Abraham Lincoln", "Grand Old Party (GOP)"
            , "Ethiopia and Liberia", "Medicine", "Fish", "Odin", "1976", "Love", "12 years old", "China"};


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
