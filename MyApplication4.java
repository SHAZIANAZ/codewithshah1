package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyApplication4<roundcount> extends AppCompatActivity   implements View.OnClickListener {
    private Button[][]buttons=new  Button[3][3];
    private boolean player1turn =true;
    private int roundcount;
    private  int player1points;
    private  int player2points;
    private TextView textviewplayer1;
    private TextView textviewplayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState)    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_application4 );

        textviewplayer1=findViewById( R.id.text_view_p1 );

        textviewplayer2=findViewById( R.id.text_view_p2 );

        for (int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++ ){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener( (View.OnClickListener) this );



            }
        }
Button buttonReset = findViewById( R.id.button_reset );
        buttonReset.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetgame();

            }
        } );
    }

    @Override
    public void onClick(View v) {
if (!((Button) v).getText().toString().equals( "" )){
    return;
}
if (player1turn){
    ((Button) v) .setText( "X" );
} else{ ((Button) v) .setText( "O" );}
      roundcount++;

if (checkForWin()){
    if (player1turn){
        player1wins();
    }else{
      player2wins();
    }
}else if(roundcount == 9){
    draw();
}else {
    player1turn = ! player1turn;
}



}private boolean checkForWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();

            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals( field[i][1] )
                    && field[i][0].equals( field[i][2] )
                    && !field[i][0].equals( "" ))
            {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals( field[1][i] )
                    && field[0][i].equals( field[2][i] )
                    && !field[0][i].equals( "" ))
            {
                return true;
            }
        }

        if (field[0][0].equals( field[1][1] )
                && field[0][0].equals( field[2][2] )
                && !field[0][0].equals( "" ))
        {
        return true;


        }
        if (field[0][2].equals( field[1][1] )
                && field[0][2].equals( field[2][0] )
                && !field[0][2].equals( "" ))
        {
            return true;


        }
        return false;


    }
    private  void  player1wins(){
        player1points++;
        Toast.makeText( this,"player 1 win!" , Toast .LENGTH_SHORT).show();
updatepointsText();
resetBoard();
    }private  void   player2wins(){
        player2points++;
        Toast.makeText( this,"player 2 win!" , Toast .LENGTH_SHORT).show();
        updatepointsText();
        resetBoard();
    }
    private  void  draw(){
        Toast.makeText( this,"draw!" ,Toast.LENGTH_SHORT).show();
        resetBoard();
    }
 private void updatepointsText(){
     textviewplayer1.setText( "player 1 :" + player1points );
     textviewplayer2.setText( "player 2 : " + player2points );
 }


 private void resetBoard(){
        for (int i = 0; i < 3 ; i++){
            for( int j = 0 ; j < 3; j++){
                buttons[i][j].setText( "" );

            }
        }
        roundcount= 0;
        player1turn = true;
 }
 private void  resetgame(){
player1points =0;
player2points =0;
updatepointsText();
resetBoard();

 }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState( outState );
        outState.putInt( "roundcount" ,roundcount);
        outState.putInt( "player1points",player1points );
        outState.putInt( "player2points",player2points );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );
        roundcount = savedInstanceState.getInt( "roundcount" );
        player1points = savedInstanceState.getInt( "player1points" );
        player2points = savedInstanceState.getInt( "player2points" );
        player1turn = savedInstanceState.getBoolean( "player1turn" );
    }
}