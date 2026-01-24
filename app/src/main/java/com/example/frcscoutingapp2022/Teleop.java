package com.example.frcscoutingapp2022;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Teleop extends Fragment implements View.OnClickListener{

    //initialize variables
    private TextView TeleopHubText;


    //counter variables
    private int TeleopHubCounter = 0;

    //Teleop Varibles
    public static int TeleopHub = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_teleop, container, false);


        //Define TextViews
        TeleopHubText = (TextView) view.findViewById(R.id.TeleopHubCounter);



        //Amp buttons Listener
        view.findViewById(R.id.TeleopHubIncrease).setOnClickListener(this);
        view.findViewById(R.id.TeleopHubDecrease).setOnClickListener(this);
        view.findViewById(R.id.TeleopHubIncrease5).setOnClickListener(this);
        view.findViewById(R.id.TeleopHubDecrease5).setOnClickListener(this);
        view.findViewById(R.id.TeleopHubIncrease10).setOnClickListener(this);
        view.findViewById(R.id.TeleopHubDecrease10).setOnClickListener(this);

        //Teleop

        return view;
    }



    @Override
    public void onClick(View view) {
        //runs the buttons
        switch(view.getId()){
            case R.id.TeleopHubIncrease:
                TeleopHubCounter++;
                TeleopHubText.setText(Integer.toString(TeleopHubCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                Teleop.TeleopHub++;

                break;
            case R.id.TeleopHubDecrease:
                if(TeleopHubCounter > 0) {
                        TeleopHubCounter --;
                        Teleop.TeleopHub--;
                    }
                    TeleopHubText.setText(Integer.toString(TeleopHubCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                 break;
            case R.id.TeleopHubIncrease5:
                TeleopHubCounter+=5;
                TeleopHubText.setText(Integer.toString(TeleopHubCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                Teleop.TeleopHub+=5;

                break;
            case R.id.TeleopHubDecrease5:
                if(TeleopHubCounter > 0) {
                    if(TeleopHubCounter<10){ TeleopHubCounter=0;
                        Teleop.TeleopHub=0;}
                    else {
                        TeleopHubCounter -= 5;
                        Teleop.TeleopHub-=5;
                    }
                    TeleopHubText.setText(Integer.toString(TeleopHubCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                } break;
            case R.id.TeleopHubIncrease10:
                TeleopHubCounter+=10;
                TeleopHubText.setText(Integer.toString(TeleopHubCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                Teleop.TeleopHub+=10;

                break;
            case R.id.TeleopHubDecrease10:
                if(TeleopHubCounter > 0) {
                    if(TeleopHubCounter<10){ TeleopHubCounter=0;
                        Teleop.TeleopHub=0;}
                    else {
                        TeleopHubCounter -=10;
                        Teleop.TeleopHub-=10;
                    }
                    TeleopHubText.setText(Integer.toString(TeleopHubCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                } break;



        }
    }

    public void onResume(){
        super.onResume();
        // IDK
        TeleopHubText.setText(Integer.toString(TeleopHubCounter));
    }







}
