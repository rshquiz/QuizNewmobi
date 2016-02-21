package br.newmobi.quiznewmobi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class QuizActivity extends Activity {

    Context context = this;

    LinearLayout IMAGENS;
    LinearLayout PERGUNTAS;
    LinearLayout TIMER_E_CANCELAR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FullScreen Activity and set no title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Content xml
        setContentView(R.layout.activity_quiz);

        //  INICIO ACTIVITY ---------------------------------------------------------------------

        // Instanciando LinearLayouts
        IMAGENS = (LinearLayout) findViewById(R.id.IMAGES);
        PERGUNTAS = (LinearLayout) findViewById(R.id.QUESTIONS);
        TIMER_E_CANCELAR = (LinearLayout) findViewById(R.id.TIMER_AND_CANCEL);


        IMAGENS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IMAGENS.setBackgroundColor(Color.parseColor("#ffffff"));

            }
        });

        PERGUNTAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PERGUNTAS.setBackgroundColor(Color.parseColor("#ffffff"));

            }
        });

        TIMER_E_CANCELAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TIMER_E_CANCELAR.setBackgroundColor(Color.parseColor("#ffffff"));

            }
        });











    } // close on create


}
