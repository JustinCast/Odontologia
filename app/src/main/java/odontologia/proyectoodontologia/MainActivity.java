package odontologia.proyectoodontologia;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
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
                        ((ListView) findViewById(R.id.listView)).getSelectedItem() != null )
                    succesToast.show();
                else
                    errorToast.show();
            }
        });
        chargeListView();

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

    private void chargeListView(){
        final ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice);
        for(int i = 0; i < 5; i++)
            listViewAdapter.add(String.valueOf(i));
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
