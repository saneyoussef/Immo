package com.example.immo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

public class PhotoActivity extends AppCompatActivity {
    GridView grid ;
    Button boutonImage ;
    ArrayList<String> filepaths = new ArrayList< >();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        grid = (GridView) findViewById(R.id.gv);
        boutonImage = (Button) findViewById(R.id.mybutton);

        boutonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filepaths.clear();
                FilePickerBuilder.getInstance().setMaxCount(5)
                        .setSelectedFiles(filepaths)
                        .setActivityTheme(R.style.AppTheme)
                        .pickPhoto(PhotoActivity.this);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case FilePickerConst.REQUEST_CODE_PHOTO:
                if(requestCode == RESULT_OK && data!=null){
                    filepaths = data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA);
                    Spaceraft s;
                    ArrayList<Spaceraft>  spacerafts = new ArrayList<>();
                    try{
                        for(String path:filepaths){
                            s= new Spaceraft();
                            s.setUri(Uri.fromFile(new File(path)));
                            spacerafts.add(s);
                        }
                        grid.setAdapter(new CustomAdapter(this,spacerafts));
                        Toast.makeText(PhotoActivity.this,"tolal = "+
                                String.valueOf(spacerafts.size()),Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
        }
    }
}
