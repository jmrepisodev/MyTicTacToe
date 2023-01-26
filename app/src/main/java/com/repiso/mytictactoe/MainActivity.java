package com.repiso.mytictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int ganadas=0;
    int perdidas=0;
    int empates=0;
    int puntos=0;
    //Posiciones en el tablero
    TextView tv_playerX, tv_playerO, tv_empates, tv1, tv2,tv3, tv4, tv5, tv6, tv7, tv8,tv9;
    TextView score;

    //Array de botones
    TextView[] botones;
    //Array de estados (cruz/circulo) de cada posición en el tablero: 0 vacío, 1 cruz, 2 círculo.
    int tablero[]=new int[9];

    //variable que determina el estado de la partida: 0=sin ganador, 1=gana jugador, 2=gana máquina, 3=empate
    int estadoJuego;
    //contador número tiradas
    int tiradas;

    //indica el turno: 1=jugador, 2=máquina
    int turno;
    private String level;
    private int idUser, idGame;
    private Boolean isSoundON,isVibrationON;
    private long backPressedTime;
    private TextView tv_score;
    private Button btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Realizazamos las distintas asociaciones de variables con los elementos gráficos
        tv_playerO=(TextView)findViewById(R.id.player_O);
        tv_playerX=(TextView)findViewById(R.id.player_X);
        tv_empates=(TextView)findViewById(R.id.draws);
        tv_score=(TextView)findViewById(R.id.tv_score_tictactoe);

        tv1 =(TextView) findViewById(R.id.one);
        tv2 =(TextView) findViewById(R.id.two);
        tv3=(TextView) findViewById(R.id.three);
        tv4 =(TextView) findViewById(R.id.four);
        tv5 =(TextView) findViewById(R.id.five);
        tv6 =(TextView) findViewById(R.id.six);
        tv7 =(TextView) findViewById(R.id.seven);
        tv8 =(TextView) findViewById(R.id.eight);
        tv9=(TextView) findViewById(R.id.nine);

        //Le asignamos un escuchador de eventos a cada TextView
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);

        btn_finish=(Button)findViewById(R.id.btn_exit_ttt);


        //Recuperamos los extras de la actividad anterior
        if(getIntent().getExtras()!=null){

        }

        //Llenamos el array con los botones del tablero
        botones= new TextView[]{
                tv1, tv2,tv3, tv4, tv5, tv6, tv7, tv8,tv9
        };


        reiniciarPartida();

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    /**
     * Ejecuta las acciones de los botones
     * @param view
     */
    @Override
    public void onClick(View view) {

        if(estadoJuego ==0){

            switch (view.getId()){
                case R.id.one:
                    //si la casilla está libre (estado=0)
                    if(tablero[0]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casilla como ocupado (cruz) en el tablero
                        tablero[0]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.two:
                    if(tablero[1]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casila (cruz) en el tablero
                        tablero[1]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.three:
                    if(tablero[2]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casila (cruz) en el tablero
                        tablero[2]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.four:
                    if(tablero[3]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casila (cruz) en el tablero
                        tablero[3]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.five:
                    if(tablero[4]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casila (cruz) en el tablero
                        tablero[4]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.six:
                    if(tablero[5]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casila (cruz) en el tablero
                        tablero[5]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.seven:
                    if(tablero[6]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casila (cruz) en el tablero
                        tablero[6]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.eight:
                    if(tablero[7]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casila (cruz) en el tablero
                        tablero[7]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
                case R.id.nine:
                    if(tablero[8]==0){
                        //Coloca una cruz
                        view.setBackgroundResource(R.drawable.cruz);
                        //Marca el estado de la casilla (cruz) en el tablero
                        tablero[8]=1;

                        tiradas++;
                        estadoJuego = comprobarJuego();
                        finalizarPartida();

                    }
                    break;
            }


            //Si el juego sigue activo
            if(estadoJuego ==0){
                //Turno de la máquina
                jugarPC();
                tiradas++;
                estadoJuego = comprobarJuego();
                finalizarPartida();
            }
        }



    }

    /**
     * Tirada de la máquina
     */
    public void jugarPC(){
        //Genera un número aleatorio entre 0 y 8 (9-1)
        Random random=new Random();
        int posicion=random.nextInt(tablero.length);
        //Si la casilla del tablero está ocupada (no es 0) vuelve a generar otro número aleatorio
        while (tablero[posicion]!=0){
            posicion=random.nextInt(tablero.length);
        }
        //Coloca una cruz
        botones[posicion].setBackgroundResource(R.drawable.circulo);
        //Marca el estado de la casila como ocupada (circulo) en el tablero
        tablero[posicion]=2;

    }


    /**
     * Comprueba el estado del juego
     * @return estado del juego
     */
    public int comprobarJuego(){
        int estado=0;

        //Condiciones en las que gana jugador (estado=1)
        if(tablero[0]==1 && tablero[1]==1 && tablero[2]==1){
            estado=1;
        }
        else if(tablero[3]==1 && tablero[4]==1 && tablero[5]==1){
            estado=1;
        }
        else if(tablero[6]==1 && tablero[7]==1 && tablero[8]==1){
            estado=1;
        }
        else if(tablero[0]==1 && tablero[3]==1 && tablero[6]==1){
            estado=1;
        }
        else if(tablero[1]==1 && tablero[4]==1 && tablero[7]==1){
            estado=1;
        }
        else if(tablero[2]==1 && tablero[5]==1 && tablero[8]==1){
            estado=1;
        }
        else if(tablero[0]==1 && tablero[4]==1 && tablero[8]==1){
            estado=1;
        }
        else if(tablero[2]==1 && tablero[4]==1 && tablero[6]==1){
            estado=1;
        }

        //Condiciones en las que gana PC (estado=2)
        else if(tablero[0]==2 && tablero[1]==2 && tablero[2]==2){
            estado=2;
        }
        else if(tablero[3]==2 && tablero[4]==2 && tablero[5]==2){
            estado=2;
        }
        else if(tablero[6]==2 && tablero[7]==2 && tablero[8]==2){
            estado=2;
        }
        else if(tablero[0]==2 && tablero[3]==2 && tablero[6]==2){
            estado=2;
        }
        else if(tablero[1]==2 && tablero[4]==2 && tablero[7]==2){
            estado=2;
        }
        else if(tablero[2]==2 && tablero[5]==2 && tablero[8]==2){
            estado=2;
        }
        else if(tablero[0]==2 && tablero[4]==2 && tablero[8]==2){
            estado=2;
        }
        else if(tablero[2]==2 && tablero[4]==2 && tablero[6]==2){
            estado=2;
        }

        //Si llega al final de casillas sin ganador establece el empate (estado=3)
        else if(tiradas==tablero.length){
            estado=3;
        }

        return estado;
    }

    /**
     * Si cambia el estado (distinto de 0) lanza mensaje y finaliza la partida
     */
    public void finalizarPartida(){
        if(estadoJuego==1 || estadoJuego==2){
            if(estadoJuego==1){
                ganadas++;
                puntos+=10;

                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("FELICIDADES");
                builder.setMessage("¡Has ganado!");
                builder.setCancelable(false);
                builder.setPositiveButton("Jugar otra vez", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reiniciarPartida();
                    }
                });
                builder.setNeutralButton("Resultados", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishTicTacToe();
                    }
                });
                builder.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }

            if(estadoJuego==2){
                perdidas++;

                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("GAME OVER");
                builder.setMessage("¡Has perdido!");
                builder.setCancelable(false);
                builder.setPositiveButton("Jugar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reiniciarPartida();
                    }
                });

                builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
            }
        } else if(estadoJuego==3){
            empates++;

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("EMPATE");
            builder.setMessage("¡El juego está empatado!");
            builder.setCancelable(false);
            builder.setPositiveButton("Jugar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reiniciarPartida();
                }
            });
            builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        }
    }

    public void reiniciarPartida(){
        //Reinicia todos los estados
        estadoJuego=0;
        tiradas=0;

        //Reinicia las vistas
        tv_empates.setText("Empates: "+empates);
        tv_playerX.setText("Jugador X: "+ganadas);
        tv_playerO.setText("Jugador O: "+perdidas);
        tv_score.setText("SCORE: "+puntos);

        for(TextView view: botones){
            view.setBackgroundResource(0);;
        }

        //Reinicia los estados de las casillas del tablero
        for (int i=0;i<tablero.length;i++){
            tablero[i]=0;
        }

        //Establece el primer turno al azar: 0=jugador, 1=PC
        Random random=new Random();
        turno=random.nextInt(2);
        if(turno==1){
            jugarPC();
        }

    }



    /**
     * Finaliza y se dirige hacia la pantalla de resultado
     */
    protected void finishTicTacToe() {
        //Guardar partida
    }

    /**
     * Método que permite salir de la aplicación si presionames el botón volver dos veces,
     * con cierto intervalo de tiempo (2 seguntos)
     */
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finish();
        } else {
            Toast.makeText(this, "Pulsa dos veces para finalizar", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }



}