package vinicius.tech.appswipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela;
    private TextView tvSwipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Question q = new Question();

        q.setQuestion("Quem tem mais libertadores no rio grande do sul?");


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvSwipe = findViewById(R.id.tvSwipe);
        tela = findViewById(R.id.tela);

        tela.setOnTouchListener(new OnSwipeTouchListener(this){


            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                tvSwipe.setText("Pra baixo");
            }


            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                tvSwipe.setText("Pra cima");
            }


            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                tvSwipe.setText("Pra esquerda");
            }


            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                tvSwipe.setText("Pra direita");
            }


        });


    }
}
