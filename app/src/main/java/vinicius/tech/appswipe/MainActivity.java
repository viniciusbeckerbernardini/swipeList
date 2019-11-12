package vinicius.tech.appswipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela;
    private TextView tvSwipe;
    private TextView tvRespostaSuperior;
    private TextView tvRespostaInferior;
    private int contador;
    private String[] questions = new String[5];
    private String[][] awnsers = new String[5][2];
    private int[] selectedAwnsers = new int[5];
    private int[] rightAwsers = new int [5];
    private int points = 5;
    private int awnsersCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        questions[0] = "Quem veio primeiro, o ovo ou a galinha?";
        questions[1] = "Quem tem mais libertadores?";
        questions[2] = "Quem mais venceu copas do brasil?";
        questions[3] = "Qual é o detentor do maior número de defesas no Ultimate?";
        questions[4] = "Qual atualmente é o carro mais rápido do mundo?";

        rightAwsers[0] = 0;
        rightAwsers[1] = 0;
        rightAwsers[2] = 0;
        rightAwsers[3] = 0;
        rightAwsers[4] = 1;

        awnsers[0][0] = "Deslizar pra cima: O ovo";
        awnsers[0][1] = "Deslizar pra baixo: A galinha";

        awnsers[1][0] = "Deslizar pra cima: Grêmio";
        awnsers[1][1] = "Deslizar pra baixo: Inter";

        awnsers[2][0] = "Deslizar pra cima: Cruzeiro";
        awnsers[2][1] = "Deslizar pra baixo: Santos";

        awnsers[3][0] = "Deslizar pra cima: Demetrious Johnson";
        awnsers[3][1] = "Deslizar pra baixo: Anderson Silva";


        awnsers[4][0] = "Deslizar pra cima: Buggati Veyron";
        awnsers[4][1] = "Deslizar pra baixo: Monzão rebaixado";

        setContentView(R.layout.activity_main);

        contador = 0;

        tvSwipe = findViewById(R.id.tvSwipe);
        tvRespostaSuperior = findViewById(R.id.tvSwipeRespostaPraCima);
        tvRespostaInferior = findViewById(R.id.tvSwipeRespostaPraBaixo);
        tela = findViewById(R.id.tela);

        tvSwipe.setText(questions[contador]);
        tvRespostaSuperior.setText(awnsers[contador][0]);
        tvRespostaInferior.setText(awnsers[contador][1]);

        tela.setOnTouchListener(new OnSwipeTouchListener(this){


            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                selectedAwnsers[contador] = 1;
                awnsersCount++;
                onSwipeLeft();
            }


            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                selectedAwnsers[contador] = 0;
                awnsersCount++;
                onSwipeLeft();

            }


            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();

                if(questions.length == awnsersCount) {
                    for (int i = 0; i < selectedAwnsers.length; i++) {
                        if (selectedAwnsers[i] != rightAwsers[i]) {
                          points--;
                        }
                    }

                    tvRespostaSuperior.setText("");
                    tvRespostaInferior.setText("");
                    tvSwipe.setText("Você acertou " + points);
                }

                if(contador < questions.length) {
                    contador++;

                    tvSwipe.setText(questions[contador]);
                    tvRespostaSuperior.setText(awnsers[contador][0]);
                    tvRespostaInferior.setText(awnsers[contador][1]);

                }else{
                        Context context = getApplicationContext();
                        String text = "Não há perguntas posteriores";
                        Toast toast = Toast.makeText(context, text,Toast.LENGTH_LONG);
                        toast.show();
                }
            }


            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if(contador > 0){
                    contador--;
                    tvSwipe.setText(questions[contador]);
                    tvRespostaSuperior.setText(awnsers[contador][0]);
                    tvRespostaInferior.setText(awnsers[contador][1]);
                }else{
                    Context context = getApplicationContext();
                    String text = "Não há perguntas anteriores";
                    Toast toast = Toast.makeText(context, text,Toast.LENGTH_LONG);
                    toast.show();
                }

            }


        });


    }
}
