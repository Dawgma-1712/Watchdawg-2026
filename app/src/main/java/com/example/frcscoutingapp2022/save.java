package com.example.frcscoutingapp2022;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class save extends Fragment implements View.OnClickListener {

    private String data = "";
    public static Bitmap bitmap;
    private static boolean qrReady = false;

    public static final int CREATE_FILE = 1;
    public static Uri fileUri;

    private ImageView ivOutput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save, container, false);

        view.findViewById(R.id.generateQR).setOnClickListener(this);
        view.findViewById(R.id.newMatch2).setOnClickListener(this);
        view.findViewById(R.id.saveFile2).setOnClickListener(this);
        ivOutput = view.findViewById(R.id.iv_output);

        return view;
    }

    @Override
    public void onClick(View view) {
        // Workaround: Get the activity instance to use the public Getter methods
        MainActivity main = (MainActivity) getActivity();
        if (main == null) return;

        switch (view.getId()) {
            case R.id.generateQR:
                try {
                    // 1. Grab the text from the UI via the Activity
                    String tNum = main.getTournamentText();

                    // 2. STORE it in GlobalVariables so it's no longer null
                    GlobalVariables.setTournamentNum(tNum);
                    // Using public getters to bypass private access restrictions
                    MainActivity.teamNumber = main.getTeamNumberText();
                    MainActivity.matchNumber = main.getMatchNumberText();
                    MainActivity.scoutName = main.getScoutNameText();
                    MainActivity.TournamentName = main.getTournamentText();

                    if (endgame.additionalNotesText != null) {
                        endgame.additionalNotes = endgame.additionalNotesText.getText().toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Data string updated with Tournament Number for the 2026 season
                data = /* GlobalVariables.getTournamentNum() + "," + */ MainActivity.teamNumber + "," + MainActivity.matchNumber + ","
                        /* Auto */   + Auto.Climb + "," + Auto.AutoHub + ","
                        /* TeleOp */ + MainActivity.playedDefense + "," + MainActivity.defendedOn + "," + MainActivity.passedFuel + "," + Teleop.TeleopHub + ","
                        /* Endgame */ + endgame.L1 + "," + endgame.L2 + "," + endgame.L3 + ","
                        /* AddInfo*/ + endgame.penalty + "," + endgame.deadBot + "," + MainActivity.alliance + "," + endgame.additionalNotes + "," + MainActivity.scoutName;

                // QR Generation Logic
                MultiFormatWriter writer = new MultiFormatWriter();
                try {
                    BitMatrix matrix = writer.encode(data, BarcodeFormat.QR_CODE, 600, 600);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    bitmap = encoder.createBitmap(matrix);
                    qrReady = true;
                    ivOutput.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.newMatch2:
                // Reset static variables for next match
                resetMatchData();
                Intent intent = new Intent(getActivity(), HomeScreen.class);
                startActivity(intent);
                break;

            case R.id.saveFile2:
                try {
                    MainActivity.teamNumber = main.getTeamNumberText();
                    MainActivity.matchNumber = main.getMatchNumberText();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Re-build data string for CSV file
                data = GlobalVariables.getTournamentNum() + "," + MainActivity.teamNumber + "," + MainActivity.matchNumber + ","
                        + Auto.Climb + "," + Auto.AutoHub + ","
                        + MainActivity.playedDefense + "," + MainActivity.defendedOn + "," + MainActivity.passedFuel + "," + Teleop.TeleopHub + ","
                        + endgame.L1 + "," + endgame.L2 + "," + endgame.L3 + ","
                        + endgame.penalty + "," + endgame.deadBot + "," + MainActivity.alliance + "," + endgame.additionalNotes + "," + MainActivity.scoutName;

                // Intent to create a CSV document
                Intent newIntent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                newIntent.addCategory(Intent.CATEGORY_OPENABLE);
                newIntent.setType("text/csv");
                String fileName = "match" + MainActivity.matchNumber + "_team" + MainActivity.teamNumber + ".csv";
                newIntent.putExtra(Intent.EXTRA_TITLE, fileName);

                startActivityForResult(newIntent, CREATE_FILE);
                break;
        }
    }

    private void resetMatchData() {
        endgame.L1 = 0;
        endgame.L2 = 0;
        endgame.L3 = 0;
        endgame.penalty = 0;
        endgame.deadBot = 0;
        Teleop.TeleopHub = 0;
        Auto.Climb = 0;
        Auto.AutoHub = 0;
    }
}