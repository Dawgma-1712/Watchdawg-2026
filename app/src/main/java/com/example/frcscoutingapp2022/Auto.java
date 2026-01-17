package com.example.frcscoutingapp2022;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Auto extends Fragment implements View.OnClickListener {


    //initialize variables

    //Initialize upper node text views
    private TextView AutoHubText;


    //counter variables
    private int AutoHubCounter = 0;

    //Auto Varibles
    public static int AutoHub = 0;

    public static int Climb = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto, container, false);
        System.out.println(AutoHub);


        //Define TextViews
        AutoHubText = (TextView) view.findViewById(R.id.AutoHubCounter);



        //Upper Row Buttons

        view.findViewById(R.id.AutoHubIncrease).setOnClickListener(this);
        view.findViewById(R.id.AutoHubIncrease5).setOnClickListener(this);
        view.findViewById(R.id.AutoHubIncrease10).setOnClickListener(this);
        view.findViewById(R.id.AutoHubDecrease).setOnClickListener(this);
        view.findViewById(R.id.AutoHubDecrease5).setOnClickListener(this);
        view.findViewById(R.id.AutoHubDecrease10).setOnClickListener(this);

        Climb =0;
        //Auto

        return view;
    }
    //stuff that happens when you hit buttons
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            //+1 to upper cone
            case R.id.AutoHubIncrease:
                AutoHubCounter++;
                AutoHubText.setText(Integer.toString(AutoHubCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                Auto.AutoHub++;

                break;

            case R.id.AutoHubDecrease:
                if(AutoHubCounter > 0) {
                    AutoHubCounter--;
                    AutoHubText.setText(Integer.toString(AutoHubCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                    Auto.AutoHub--;
                } break;
            case R.id.AutoHubIncrease5:
                AutoHubCounter+=5;
                AutoHubText.setText(Integer.toString(AutoHubCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                Auto.AutoHub+=5;

                break;
            case R.id.AutoHubDecrease5:
                if(AutoHubCounter > 0) {
                   if(AutoHubCounter<5){ AutoHubCounter=0;
                       Auto.AutoHub=0;}
                   else {
                       AutoHubCounter -= 5;
                       Auto.AutoHub-=5;
                   }
                    AutoHubText.setText(Integer.toString(AutoHubCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                } break;
            case R.id.AutoHubIncrease10:
                AutoHubCounter+=10;
                AutoHubText.setText(Integer.toString(AutoHubCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                Auto.AutoHub+=10;

                break;
            case R.id.AutoHubDecrease10:
                if(AutoHubCounter > 0) {
                    if(AutoHubCounter<10){ AutoHubCounter=0;
                        Auto.AutoHub=0;}
                    else {
                        AutoHubCounter -= 10;
                        Auto.AutoHub-=10;
                    }
                    AutoHubText.setText(Integer.toString(AutoHubCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                } break;



        }
    }

    public void onResume() {
        super.onResume();
        AutoHubText.setText(Integer.toString(AutoHubCounter));



    }
}
//he he ha ha