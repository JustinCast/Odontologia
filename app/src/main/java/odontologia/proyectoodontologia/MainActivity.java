package odontologia.proyectoodontologia;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //https://android.jlelse.eu/creating-an-intro-screen-for-your-app-using-viewpager-pagetransformer-9950517ea04f#.911dhxhbh
    boolean listViewState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Manejo Citas");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loadSpinnerData();

        //Click Listener el boton reservar
        Button reserveBtn = (Button) findViewById(R.id.reserve_btn);
        // Se crea el Toast de éxito
        final Toast successToast = Toast.makeText(this, R.string.succes_appointment,Toast.LENGTH_SHORT);
        final Toast errorToast = Toast.makeText(this, R.string.error_appointment, Toast.LENGTH_SHORT);
        chargeListView();

        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(((ListView)findViewById(R.id.listView)).getSelectedItem());
                if(listViewState)
                    successToast.show();
                else
                    errorToast.show();
            }
        });

    }

    /**
     * Metodo encargado de llenar los spinner con sus respectivos datos
     * */
    private void loadSpinnerData(){

        //Spinner para el día
        Spinner appointmentDaySpinner = (Spinner) findViewById(R.id.appointment_day_spinner);
        appointmentDaySpinner.setPrompt("Dia");

        //es_ES
        Locale.setDefault(new Locale("es_ES"));


        //De la siguiente forma se añaden las fechas al spinner
        ArrayList<String> spinnerArrayDay = new ArrayList<>();
        Calendar calendar = Calendar.getInstance(new Locale("es_ES"));
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date;
        for(int i = 1;i < 30; i++)
        {
            date = sdf.format(calendar.getTime());
            spinnerArrayDay.add(date);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        ArrayAdapter<String> spinnerArrayAdapterDay =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArrayDay);
        appointmentDaySpinner.setAdapter(spinnerArrayAdapterDay);
        appointmentDaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_appointments) {
            Intent appointmentIntent = new Intent(this, MainActivity.class);
            startActivity(appointmentIntent);

        }else if (id == R.id.nav_odontological_sheet) {
            Intent odontologicalSheet = new Intent(this, FichaOdontologica.class);
            startActivity(odontologicalSheet);
        }else if (id == R.id.nav_developers) {
            Intent developersActivity = new Intent(this, DevelopersActivity.class);
            startActivity(developersActivity);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /**
     * Método encargado de llenar el ListView del activity principal
     * */
    private void chargeListView(){
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice);

        Calendar calendar = Calendar.getInstance(new Locale("es_ES"));
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSSZ");
        String date;
        for(int i = 1;i < 30; i++)
        {
            date = sdf.format(calendar.getTime());
            listViewAdapter.add(date);
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listViewState = true;
            }
        });

    }
}
