package com.example.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    //создаем переменные
    private ImageView obraz;
    private Button prev;
    private Button next;
    private Switch changeBackground;
    private EditText idPhoto;
    int[] zbiorObrazów = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3,};
    int startImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Находим наши объекты с которыми будем работать
        obraz = findViewById(R.id.obraz);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        changeBackground = findViewById(R.id.changeBackground);
        idPhoto = findViewById(R.id.idPhoto);

    }

    public void nextPhoto(View view) {
        if (startImage > zbiorObrazów.length - 1) {
            startImage = 0;
        } else {
            obraz.setImageResource(zbiorObrazów[startImage]);
            startImage++;
        }
    }

    public void prevtPhoto(View view) {
        if (startImage < 0) {
            startImage = 2;
        } else {
            obraz.setImageResource(zbiorObrazów[startImage]);
            startImage--;
        }
    }

    public void showImage(View view) {
        int numberImage = Integer.valueOf(idPhoto.getText().toString());
        if (numberImage <= zbiorObrazów.length - 1 && numberImage >= 0) {
            obraz.setImageResource(zbiorObrazów[numberImage-1]);
        }else{
            System.out.println("Error");
        }
    }
}