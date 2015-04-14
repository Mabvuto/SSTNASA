package tn.sta.eximus.sta;

import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;

import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.model.interfaces.OnCheckedChangeListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Container extends ActionBarActivity {

    private static final int PROFILE_SETTING = 1;
String namezz;

    //save our header or result
    private AccountHeader.Result headerResult = null;
    private Drawer.Result result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

    namezz=   getIntent().getExtras().getString("json");
        // Handle Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create a few sample profile
        // NOTE you have to define the loader logic too. See the CustomApplication for more details
        Drawable myDrawable = getResources().getDrawable(R.drawable.zzz);
        final IProfile profile = new ProfileDrawerItem().withName("Mr Analyst").withEmail("Analyst@nasa.org").withIcon(myDrawable);


        // Create the AccountHeader
        headerResult = new AccountHeader()
                .withActivity(this)

                .withHeaderBackground(R.drawable.sp1)
                .addProfiles(
                        profile

                        //don't ask but google uses 14dp for the add account icon in gmail but 20dp for the normal icons (like manage account)

                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        //sample usage of the onProfileChanged listener
                        //if the clicked item has the identifier 1 add a new profile ;)
                        if (profile instanceof IDrawerItem && ((IDrawerItem) profile).getIdentifier() == PROFILE_SETTING) {
                            IProfile newProfile = new ProfileDrawerItem().withNameShown(true).withName("Analyst").withEmail("Analyst@nasa.org").withIcon(getResources().getDrawable(R.drawable.user_drawer));
                            if (headerResult.getProfiles() != null) {
                                //we know that there are 2 setting elements. set the new profile above them ;)
                                headerResult.addProfile(newProfile, headerResult.getProfiles().size() - 2);
                            } else {
                                headerResult.addProfiles(newProfile);
                            }
                        }

                        //false if you have not consumed the event and it should close the drawer
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
        //Create the drawer
 // add the items we want to use with our Drawer

            result = new Drawer()
                    .withActivity(this)
                    .withToolbar(toolbar)

                    .withActionBarDrawerToggleAnimated(true)
                    .withActionBarDrawerToggle(true)
                    .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                    .addDrawerItems(

                            new SectionDrawerItem().withName("Astronauts With Smart Suits"),
                            new SecondaryDrawerItem().withName(namezz).withIcon(R.drawable.astronauticon).withIdentifier(1).withCheckable(false)


                    ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                                            //check if the drawerItem is set.
                                            //there are different reasons for the drawerItem to be null
                                            //--> click on the header
                                            //--> click on the footer
                                            //those items don't contain a drawerItem

                                            if (drawerItem != null) {

                                                if (drawerItem.getIdentifier() == 1) {
                                                    FragmentManager fm = getSupportFragmentManager();

                                                    FragmentTransaction ft = fm.beginTransaction();


                                                    Fragment llf = new Main();

                                                    ft.replace(R.id.lol, llf);

                                                    ft.commit();
                                                    getSupportActionBar().setTitle("Anton Schkaplerov");
                                                    result.setSelectionByIdentifier(1, false);
                                                }
                                                if (drawerItem.getIdentifier() == 2) {
                                                    FragmentManager fm = getSupportFragmentManager();

                                                    FragmentTransaction ft = fm.beginTransaction();


                                                    Fragment llf = new Main();

                                                    ft.replace(R.id.lol, llf);

                                                    ft.commit();
                                                    getSupportActionBar().setTitle("Samantha Cristoforetti");
                                                    result.setSelectionByIdentifier(2, false);
                                                }
                                                if (drawerItem.getIdentifier() == 3) {
                                                    FragmentManager fm = getSupportFragmentManager();

                                                    FragmentTransaction ft = fm.beginTransaction();


                                                    Fragment llf = new Main();

                                                    ft.replace(R.id.lol, llf);

                                                    ft.commit();
                                                    getSupportActionBar().setTitle("Terry Virts");
                                                    result.setSelectionByIdentifier(3, false);
                                                }

                                                if (drawerItem.getIdentifier() == 4) {
                                                    FragmentManager fm = getSupportFragmentManager();

                                                    FragmentTransaction ft = fm.beginTransaction();


                                                    Fragment llf = new Main();

                                                    ft.replace(R.id.lol, llf);

                                                    ft.commit();
                                                    getSupportActionBar().setTitle("Gennady Padalka");
                                                    result.setSelectionByIdentifier(4, false);

                                                }

                                                if (drawerItem.getIdentifier() == 5) {
                                                    FragmentManager fm = getSupportFragmentManager();

                                                    FragmentTransaction ft = fm.beginTransaction();


                                                    Fragment llf = new Main();

                                                    ft.replace(R.id.lol, llf);

                                                    ft.commit();
                                                    getSupportActionBar().setTitle("Mikhail Kornienko");
                                                    result.setSelectionByIdentifier(5, false);

                                                }
                                                if (drawerItem.getIdentifier() == 6) {
                                                    FragmentManager fm = getSupportFragmentManager();

                                                    FragmentTransaction ft = fm.beginTransaction();


                                                    Fragment llf = new Main();

                                                    ft.replace(R.id.lol, llf);

                                                    ft.commit();
                                                    getSupportActionBar().setTitle("Scott Kellys");
                                                    result.setSelectionByIdentifier(6, false);
                                                }



                                            }
                                            //  Container.this.startActivity(i);

                                        }

                                    })

                                    .build();


        //only set the active selection or active profile if we do not recreate the activity
        if (savedInstanceState == null) {
            // set the selection to the item with the identifier 10
            result.setSelectionByIdentifier(1, true);

            //set the active profile
            headerResult.setActiveProfile(profile);
        }
    }

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable) {
                Log.i("material-drawer", "DrawerItem: " + ((Nameable) drawerItem).getName() + " - toggleChecked: " + isChecked);
            } else {
                Log.i("material-drawer", "toggleChecked: " + isChecked);
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

}


