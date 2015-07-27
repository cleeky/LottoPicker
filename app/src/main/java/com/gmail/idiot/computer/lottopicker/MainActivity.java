package com.gmail.idiot.computer.lottopicker;

import java.util.Arrays;
import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        btn=new Button(this);
        btn.setOnClickListener(this);
        btn.setText("Touch the Screen for Loto Numbers");
        setContentView(btn);
    }
    public void onClick(View view) {
        updateBalls();
    }
    private void updateBalls() {
        btn.setText(LottoBalls());
    }

    public static int getball(int shakenum){
        Random generator = new Random();
        int repeat, ball;
        ball = 0;
        for (repeat=0; repeat <=shakenum; repeat++){
            ball = generator.nextInt(49) + 1;
        }
        return ball;
    }

    public static String LottoBalls() {

        boolean[] usednumbers = new boolean[50];

        int count;
        int count2;
        int shake;
        int ball;
        String strball= "";;
        int [] Selectedball = new int[6];

        shake = 25;
        ball = 0;

        //init the used number array to true
        //for (count=0; count <= 49; count++){
        //	usednumbers[count]= true;
        //}
        java.util.Arrays.fill( usednumbers, true);

        //pick 6 balls
        for (count=0; count <=5; count++){
            ball = getball(shake);
            //System.out.println(count +" x  : "+usednumbers[ball]);
            if (usednumbers[ball]){
                Selectedball[count] = ball;
                usednumbers[ball]= false;
                //System.out.println("Ball :" + Selectedball[count] + " is ready used : "+usednumbers[ball]);
            }else {
                //System.out.println(count+" x Duplicate Bymbers");
                count = count -1;
            }
        }
        Arrays.sort(Selectedball);
        System.out.println("Your Lotto numbers are :-");
        for (count=0; count <=5; count++){
            count2 =count + 1;
            strball += "Nr. "+count2+" :\t"+Selectedball[count]+"\n";

        }



        return strball;
    }
}
