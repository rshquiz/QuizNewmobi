package br.newmobi.quiznewmobi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import appDB.DatabaseAccess;


public class QuizActivity extends Activity {


    private static final String LOG = QuizActivity.class.getName();

    // LinearLayouts
    LinearLayout IMAGENS;
    LinearLayout PERGUNTAS;
    //LinearLayout TIMER_E_CANCELAR;

    // FrameLayout
    FrameLayout fullBackground;

    // TextView
    TextView questioView;

    // ListView Questions
    private ListView listViewQuestions;

    // Question Adapter
    public static QuestionsListAdapter questionsAdapter;
    private QuestionsListAdapter anotherQuestionsAdapter;

    // Array List Itens
    ArrayList<QuestionsListItens> listItensQuestions = new ArrayList<>();
    ArrayList<QuestionsListItens> listItensQuestionsOptions = new ArrayList<>();

    QuestionsListItens possibleAnswerListItems;
    public List<String> queryReturnsQuestions;

    public static String answearIDCorrect;
    public static String questionToResolv;
    public static String possibleAnswer = "10";
    //public static String answearClickedID = "0";
    public static String answearClickedID;
    public static String answearClickedText1;
    public static String answearClickedText2;
    public static String answearClickedText3;
    public static String answearClickedText4;


    public static ArrayList<String> clickedList = new ArrayList<>();
    public static ArrayList<String> fourOptions = new ArrayList<>();


    private Context context = this;
    private ProgressDialog progressDialog;
    private Handler handler = new Handler();
    private AsyncTaskRunner runner;

    private boolean running;
    final Animation anim = new AlphaAnimation(0.0f, 1.0f);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity: FullScreen, No Title and Landscape
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Content Xml View
        setContentView(R.layout.activity_quiz);


        // Set background Animation
        anim.setDuration(25); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(25);
        anim.computeDurationHint();

        // THREAD CONTROL
        running = true;
        new Thread(null, THrefreshQuestion, "Refresh question").start();


        //  INICIO ACTIVITY VIEW ------------------------------------------------------------------

        // Instanciando LinearLayouts
        IMAGENS = (LinearLayout) findViewById(R.id.IMAGES);
        PERGUNTAS = (LinearLayout) findViewById(R.id.QUESTIONS);
        //TIMER_E_CANCELAR = (LinearLayout) findViewById(R.id.TIMER_AND_CANCEL);

        // Frame Layouts
        fullBackground = (FrameLayout) findViewById(R.id.home_container);

        // TextView
        questioView = (TextView) findViewById(R.id.textViewQuestions);

        /*
        ImageLoader.ImageCache imageCache = new LruBitmapCache();
        ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(context), imageCache);
        NetworkImageView imgAvatar = (NetworkImageView) findViewById(R.id.imgAvatar);
        imgAvatar.setImageUrl(Const.IMG_URL, imageLoader);
        */


        // Set ListView
        this.listViewQuestions = (ListView) findViewById(R.id.listViewQuestion);

        // Get Question Randomicly
        getRandomQuestion();
        // Get options
        getOnlyOptions();
        questionToResolv = queryReturnsQuestions.get(4);
        questioView.setText(questionToResolv);

        answearIDCorrect = queryReturnsQuestions.get(9);

        System.out.println(queryReturnsQuestions.get(0));
        System.out.println(queryReturnsQuestions.get(1));
        System.out.println(queryReturnsQuestions.get(2));
        System.out.println(queryReturnsQuestions.get(3));
        System.out.println(queryReturnsQuestions.get(4));
        System.out.println(queryReturnsQuestions.get(5));
        System.out.println(queryReturnsQuestions.get(6));
        System.out.println(queryReturnsQuestions.get(7));
        System.out.println(queryReturnsQuestions.get(8));
        System.out.println(queryReturnsQuestions.get(9));


        // Set Adapter
        anotherQuestionsAdapter = new QuestionsListAdapter(this, listItensQuestions);
        questionsAdapter = new QuestionsListAdapter(this, listItensQuestionsOptions);
        listViewQuestions.setAdapter(questionsAdapter);


        // Check Answer
        listViewQuestions.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> myAdapter, View myView, int pos, long myLong) {

                possibleAnswerListItems = (QuestionsListItens) myAdapter.getItemAtPosition(pos);

                possibleAnswer = possibleAnswerListItems.getGetChoice();
                answearClickedID = possibleAnswerListItems.getGetChoicePosition();


                System.out.println(" CLICKED CHOICE: " + possibleAnswer + "  ID: " + answearClickedID);
                System.out.println(" CLICKED ID POS: " + pos);


                // CHECK IF IS A CORRECT ANSWER
                if (answearClickedID != null && answearClickedID.equals(queryReturnsQuestions.get(9))) {

                    System.out.println("RESPOSTA CORRETA! " + " ID: " + answearClickedID);

                    // Inicia a tread
                    runner = new AsyncTaskRunner(context);
                    runner.execute();
                    progressDialog.dismiss();
                    questionsAdapter.notifyDataSetChanged();
                    listViewQuestions.requestLayout();

                } else {

                    System.out.println("RESPOSTA ERRADA! " + " ID: " + answearClickedID);
                    questionsAdapter.notifyDataSetChanged();


                }


            }
        });


    } // close on create

    Runnable THrefreshQuestion = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(50);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            questioView.setText(questionToResolv);

                        }
                    });
                }
            } catch (Exception ignored) {
            }
        }
    }; // ------------------------------------------------------------------------------------

    Runnable THbackgroundAnim = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(50);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            fullBackground.setBackgroundColor(Color.parseColor("#000000"));
                            fullBackground.setAnimation(anim);

                        }
                    });
                }
            } catch (Exception ignored) {
            }
        }
    }; // ------------------------------------------------------------------------------------


    public class AsyncTaskRunner extends AsyncTask<String, String, String> {
        public AsyncTaskRunner(Context context) {

        }

        @Override
        protected void onPreExecute() {
            // inicia dialog
            progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("CARREGANDO...");
            progressDialog.setMessage("AGUARDANDO LISTA...");
            progressDialog.getProgress();
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {

            // Clear collection..
            listItensQuestionsOptions.clear();
            queryReturnsQuestions.clear();
            fourOptions.clear();
            //answearClickedID = "0";

            // Add data to collection..
            getRandomQuestion();
            getOnlyOptions();

            return "finish";
        }


        @Override
        protected void onPostExecute(String result) {

            questionToResolv = queryReturnsQuestions.get(4);
            answearClickedText1 = queryReturnsQuestions.get(5);
            answearClickedText2 = queryReturnsQuestions.get(6);
            answearClickedText3 = queryReturnsQuestions.get(7);
            answearClickedText4 = queryReturnsQuestions.get(8);

            System.out.println("Q1 ATUALIZEI: " + answearClickedText1);
            System.out.println("Q2 ATUALIZEI: " + answearClickedText2);
            System.out.println("Q3 ATUALIZEI: " + answearClickedText3);
            System.out.println("Q4 ATUALIZEI: " + answearClickedText4);

            questionsAdapter.notifyDataSetChanged();

        }
    }


    // Call Back mensagem da activity MODAL
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            // Atualiza lista quando e inserido uma entrada nova no DB
            runner = new AsyncTaskRunner(this);
            runner.execute();
            questionsAdapter.notifyDataSetChanged();
            progressDialog.dismiss();
        }
    }


    private void getRandomQuestion() {

        try {


            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();

            queryReturnsQuestions = databaseAccess.getRandomQuestions();
            possibleAnswerListItems = new QuestionsListItens();

            possibleAnswerListItems.setGetQuestionID(queryReturnsQuestions.get(0));
            possibleAnswerListItems.setGetQuestionType(queryReturnsQuestions.get(1));
            possibleAnswerListItems.setGetQuestionDifficult(queryReturnsQuestions.get(2));
            possibleAnswerListItems.setGetQuestionCategory(queryReturnsQuestions.get(3));
            possibleAnswerListItems.setGetQuestion(queryReturnsQuestions.get(4));
            possibleAnswerListItems.setGetOption1(queryReturnsQuestions.get(5));
            possibleAnswerListItems.setGetOption2(queryReturnsQuestions.get(6));
            possibleAnswerListItems.setGetOption3(queryReturnsQuestions.get(7));
            possibleAnswerListItems.setGetOption4(queryReturnsQuestions.get(8));
            possibleAnswerListItems.setGetAnswer(queryReturnsQuestions.get(9));

            databaseAccess.close();

            answearClickedText1 = queryReturnsQuestions.get(5);
            answearClickedText2 = queryReturnsQuestions.get(6);
            answearClickedText3 = queryReturnsQuestions.get(7);
            answearClickedText4 = queryReturnsQuestions.get(8);


        } catch (IndexOutOfBoundsException err) {
            System.out.println("ERROR: " + err);
        }
    } //

    public void getOnlyOptions() {

        try {

            fourOptions.add(queryReturnsQuestions.get(5));
            fourOptions.add(queryReturnsQuestions.get(6));
            fourOptions.add(queryReturnsQuestions.get(7));
            fourOptions.add(queryReturnsQuestions.get(8));

            // ListViiew With Choices
            for (int i = 0; i < fourOptions.toArray().length; i++) {

                QuestionsListItens QstOpts = new QuestionsListItens();

                QstOpts.setGetChoicePosition(String.valueOf(i + 1));
                QstOpts.setGetChoice(fourOptions.get(i));

                listItensQuestionsOptions.add(QstOpts);

            }

        } catch (IndexOutOfBoundsException err) {
            System.out.println("ERROR: " + err);
        }

    }
}