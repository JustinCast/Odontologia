package odontologia.proyectoodontologia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
        final Toast succesToast = Toast.makeText(this, R.string.succes_appointment,Toast.LENGTH_SHORT);
        final Toast errorToast = Toast.makeText(this, R.string.error_appointment, Toast.LENGTH_SHORT);
        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((Spinner) findViewById(R.id.appointment_day_spinner)).getSelectedItem() != null &&
                        ((Spinner) findViewById(R.id.appointment_hour_spinner)).getSelectedItem() != null )
                    succesToast.show();
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

        ArrayList<String> spinnerArrayDay = new ArrayList<>();
        spinnerArrayDay.add("Uno");
        spinnerArrayDay.add("Dos");
        spinnerArrayDay.add("Tres");
        spinnerArrayDay.add("Cuatro");
        spinnerArrayDay.add("Cinco");
        ArrayAdapter<String> spinnerArrayAdapterDay =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArrayDay);
        appointmentDaySpinner.setAdapter(spinnerArrayAdapterDay);

        //Spinner para la hora
        Spinner appointmentHourSpinner = (Spinner) findViewById(R.id.appointment_hour_spinner);
        appointmentHourSpinner.setPrompt("Hora");
        ArrayList<String> spinnerArrayHour = new ArrayList<>();
        spinnerArrayHour.add("1:00 pm");
        spinnerArrayHour.add("2:00 pm");
        spinnerArrayHour.add("3:00 pm");
        spinnerArrayHour.add("4:00 pm");
        spinnerArrayHour.add("4:40 pm");
        spinnerArrayHour.add("5:00 pm");
        ArrayAdapter<String> spinnerArrayAdapterHour =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArrayHour);
        appointmentHourSpinner.setAdapter(spinnerArrayAdapterHour);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_appointments) {
            Intent appointmentIntent = new Intent(this, MainActivity.class);
            startActivity(appointmentIntent);

        } else if (id == R.id.nav_appointment_registry) {

        } else if (id == R.id.nav_odontological_sheet) {
            Intent odontologicalSheet = new Intent(this, FichaOdontologica.class);
            startActivity(odontologicalSheet);
        }else if (id == R.id.nav_contacts) {

        } else if (id == R.id.nav_developers) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
