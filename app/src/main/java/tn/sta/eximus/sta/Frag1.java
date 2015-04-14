package tn.sta.eximus.sta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Timer;
import java.util.TimerTask;

import tn.sta.eximus.sta.R;

// In this case, the fragment displays simple text based on the page
public class Frag1 extends Fragment {
    ImageView img1;
    ImageView presi;
    ImageView temp;
    ImageView bs;
    TextView temptxt;
    TextView tx1;
    TextView bptxt;
    TextView bstxt;
    boolean x = false;


    Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        img1 = (ImageView) view.findViewById(R.id.heartimg);
        presi= (ImageView) view.findViewById(R.id.presi);
        temp= (ImageView) view.findViewById(R.id.temp);
        bs= (ImageView) view.findViewById(R.id.bs);
        tx1=(TextView)view.findViewById(R.id.hearttxt);
        temptxt=(TextView)view.findViewById(R.id.temptxt);
        bptxt=(TextView)view.findViewById(R.id.bptxt);
        bstxt=(TextView)view.findViewById(R.id.bstxt);


        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (x==false) {
                    try {
                        Thread.sleep(500);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                img1.getLayoutParams().height = 210;
                                img1.getLayoutParams().width = 210;
                               bs.setImageResource(R.drawable.bl2);
                                temp.setImageResource(R.drawable.tp1);
                                tx1.setText("82");
                                bstxt.setText("70");

                                bptxt.setText("13");
                                temptxt.setText("36");
                                img1.requestLayout();
                                x = true;
                            }
                        });
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    while (x == true) {
                        try {
                            Thread.sleep(500);
                            mHandler.post(new Runnable() {

                                @Override
                                public void run() {
                                    img1.getLayoutParams().height = 190;
                                    img1.getLayoutParams().width = 190;
                                    bs.setImageResource(R.drawable.bl);
                                    temp.setImageResource(R.drawable.tp);
                                    tx1.setText("81");
                                    bstxt.setText("72");

                                    bptxt.setText("12");
                                    temptxt.setText("37");
                                    x = false;
                                    img1.requestLayout();

                                }
                            });
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }
                }

            }
        }).start();

    return  view;
    }

}