package br.newmobi.quiznewmobi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class ModalAnswerCorrect extends Activity {

    Button btnNextQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FullScreen Activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_modal_answer_correct);

        // Botao CANCELAR
        btnNextQuestion = (Button) findViewById(R.id.buttonNEXT_QUESTION);
        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String retorno = "este é o retorno";
                Bundle bundle = new Bundle();
                bundle.putString("retorno", retorno);
                Intent it = new Intent();
                it.putExtras(bundle);
                setResult(1, it);

                finish();
            }
        });



    } // ---- FECHA ONCREATE


    // ------------------------------------------------------------------------------------ //
}
