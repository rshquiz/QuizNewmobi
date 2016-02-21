package br.newmobi.quiznewmobi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/* Created by gilsonfigueiredo on 01/09/15. */
public class QuestionsListAdapter extends BaseAdapter {

    Context context;
    ArrayList<QuestionsListItens> getQuestions;
    public static CardView CVO;


    public QuestionsListAdapter(Context context, ArrayList<QuestionsListItens> list1) {

        this.context = context;
        getQuestions = list1;

    }

    @Override
    public int getCount() {
        return getQuestions.size();
    }

    @Override
    public Object getItem(int position) {
        if (getQuestions.size() == 0) {
            return null;
        }
        return getQuestions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"InflateParams", "NewApi"})
    @Override
    public View getView(int position, View convertView, ViewGroup arg1) {
        QuestionsListItens getListQuestions = getQuestions.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.answer_options_list, null);
        }
        CVO = (CardView) convertView.findViewById(R.id.cardviewOptions);

        TextView questionsChoice = (TextView) convertView.findViewById(R.id.choices);
        TextView questionsChoiceID = (TextView) convertView.findViewById(R.id.choicesID);

        questionsChoice.setText(getListQuestions.getGetChoice());
        questionsChoiceID.setText(getListQuestions.getGetChoicePosition());


        //String choiceID = questionsChoiceID.getText().toString();

        /*
        if (choiceID.equals(QuizActivity.answearClickedID)){
            //CVO.setVisibility(View.VISIBLE);
            CVO.setCardBackgroundColor(Color.parseColor("#000000"));

        }
        */



        return convertView;


    }


    @Override
    public int getViewTypeCount() {

        if (getCount() != 0)
            return getCount();

        return 1;
    }


}
