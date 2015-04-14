package tn.sta.eximus.sta;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.rengwuxian.materialedittext.MaterialEditText;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SplashScreen extends Activity {
    JSONArray jsonarray;
    ImageView logo;
    Animation anim1;
    Animation anim2;
    Animation anim3;

    public   JSONArray a;

    ScaleAnimation makeBigger;
    // ImageView start;

    MaterialEditText login,pass;
    RelativeLayout relativeLayout;
    ProgressWheel wheel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }




        setContentView(R.layout.splash_layout);
        login =(MaterialEditText)findViewById(R.id.login);
        pass =(MaterialEditText)findViewById(R.id.pass);
        wheel = (ProgressWheel)findViewById(R.id.progress_wheel1);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);

        relativeLayout.setClipChildren(false);
        logo = (ImageView) findViewById(R.id.imgLogo);



        anim1 = AnimationUtils.loadAnimation(this, R.anim.anim1);
        anim1.reset();
        anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        anim2.reset();
        anim3 = AnimationUtils.loadAnimation(this, R.anim.anim3);
        anim3.reset();
        logo.clearAnimation();
        logo.startAnimation(anim2);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                makeBigger = new ScaleAnimation((float) 1.0, (float) 1.5,
                        (float) 1.0, (float) 1.5, Animation.RELATIVE_TO_SELF,
                        (float) 0.5, Animation.RELATIVE_TO_SELF, (float) 3.2);

                makeBigger.setFillAfter(true);

                makeBigger.setDuration(750);

                logo.startAnimation(makeBigger);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                RelativeLayout r1 = (RelativeLayout)findViewById(R.id.layout_login);
                            r1.setVisibility(View.VISIBLE);
                            final ButtonFlat login =(ButtonFlat)findViewById(R.id.button);
                            login.setOnClickListener(new OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(
                                            Context.INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow( login.getWindowToken(), 0);

                                    if(((MaterialEditText) findViewById(R.id.login)).getText().toString().equals("")||((MaterialEditText) findViewById(R.id.pass)).getText().toString().equals("")){
                                        if(((MaterialEditText) findViewById(R.id.login)).getText().toString().equals("")){
                                            ((MaterialEditText) findViewById(R.id.login)).setError("Email requiered");
                                        }
                                        if( ((MaterialEditText) findViewById(R.id.pass)).getText().toString().equals("")){
                                            ((MaterialEditText) findViewById(R.id.pass)).setError("Password requiered");
                                        }


                                    }
                                    if(!((MaterialEditText) findViewById(R.id.login)).getText().toString().equals("")&&!((MaterialEditText) findViewById(R.id.pass)).getText().toString().equals("")){


                                        wheel.setVisibility(View.VISIBLE);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {


                                                wheel.setVisibility(View.INVISIBLE);
                                                if(((MaterialEditText) findViewById(R.id.login)).getText().toString().equals("analyst@nasa.org")) {
                                                    {
                                                        new BigCalcul().execute();
                                                    }
                                                    if (!((MaterialEditText) findViewById(R.id.login)).getText().toString().equals("analyst@nasa.org")) {
                                                        ((MaterialEditText) findViewById(R.id.pass)).setError("Please verify your informations");
                                                    }
                                                }


                                            }
                                        }, 1600);

                                    }
                                }    });



                        }

                    }, 1600);


            }
        }, 1500);

    }


    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }



    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    public class BigCalcul extends AsyncTask<String, String, String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }



        @Override
        protected String doInBackground(String... arg0) {

            try {

               JsonParser jParser= new JsonParser();

                JSONObject json1 = jParser.getJSONFromUrl("http://api.open-notify.org/astros.json");
                // jsonarray =    new JSONArray(json.getJSONArray("people"));
                Toast.makeText(getApplicationContext(),"booyaaa",Toast.LENGTH_LONG).show();



            }catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            Intent intent = new Intent(SplashScreen.this,
                    Container.class);
            try {
            //    Toast.makeText(getApplicationContext(), jsonarray.getJSONObject(0).getString("name"),Toast.LENGTH_LONG).show();
                // intent.putExtra("json", jsonarray.getJSONObject(0).getString("name"));
            }
            catch (Exception e){
               // Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
          //  startActivity(intent);


           // finish();

        }
    }
}
