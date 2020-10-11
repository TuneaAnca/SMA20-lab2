package com.example.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    EditText eName;
    Button bClick;
    TextView tName;

    Button closeButton;
    AlertDialog.Builder builder;

    PopupWindow popUp;
    boolean click = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            eName = (EditText) findViewById(R.id.editText);
            bClick = (Button) findViewById(R.id.button2);
            tName = (TextView) findViewById(R.id.textView2);


        } catch (NullPointerException e) {
            throw new IllegalStateException("This is not possible", e);
        }

        bClick.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                tName.setText("Hello " + eName.getText());

            }

        });


        closeButton = (Button) findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        closeButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to close this application ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                makeText(getApplicationContext(), "you choose yes action for alertbox",
                                        LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                makeText(getApplicationContext(), "you choose no action for alertbox",
                                        LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });
        LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View custom = layoutInflater.inflate(R.layout.popupxml,null);
        LinearLayout layout = new LinearLayout(this);
        ((TextView) custom.findViewById(R.id.textView3)).setText("Name:" + eName.getText());

        PopupWindow popupWindow = new PopupWindow(custom, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //popupWindow.showAtLocation(layout,Gravity.CENTER,0,0);


    }
}