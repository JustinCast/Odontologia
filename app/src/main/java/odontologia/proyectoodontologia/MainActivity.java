package odontologia.proyectoodontologia;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Clase encargada de manejar los distintos activities de la aplicacion
 *
 * */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //https://android.jlelse.eu/creating-an-intro-screen-for-your-app-using-viewpager-pagetransformer-9950517ea04f#.911dhxhbh
    boolean listViewState;
    private int dia, mes, año;
    private TextView txtdate;
    private Button btnDates, reserveBtn;
    private DatePickerDialog datePickerDialog;
    private ConnectionManager connectionManager = new ConnectionManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Manejo Citas");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtdate = (TextView) findViewById(R.id.txtdate);

        btnDates = (Button) findViewById(R.id.btnDate);

        btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarShow();

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loadSpinnerData();

        //Click Listener el boton reservar
        reserveBtn = (Button) findViewById(R.id.reserve_btn);
        reserveBtn.setVisibility(View.GONE);
        // Se crea el Toast de éxito
        final Toast successToast = Toast.makeText(this, R.string.succes_appointment,Toast.LENGTH_SHORT);
        final Toast errorToast = Toast.makeText(this, R.string.error_appointment, Toast.LENGTH_SHORT);
        //chargeListView();

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

    private void getAvailableDates() {
        Call<List<Horas>> call = connectionManager.getMainInterface().getAvailableDateHours(txtdate.getText().toString());
        call.enqueue(new Callback<List<Horas>>() {
            @Override
            public void onResponse(Call<List<Horas>> call, Response<List<Horas>> response) {
                chargeListView(response.body());
            }

            @Override
            public void onFailure(Call<List<Horas>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "falla", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void calendarShow() {
        Calendar c = Calendar.getInstance();
        año = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtdate.setText((month+1)+"-"+dayOfMonth+"-"+year);
                getAvailableDates();
            }
        },año,mes,dia);
        datePickerDialog.show();
    }

    /**
     * Metodo encargado de llenar los spinner con sus respectivos datos
     * */
    private void loadSpinnerData(){

        //Spinner para el día

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

        return super.onOptionsItemSelected(item);
    }


    /**
     * Aca se abren los activities deseados
     * */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //Activity 'Citas'
        if (id == R.id.nav_appointments) {
            Intent appointmentIntent = new Intent(this, MainActivity.class);
            startActivity(appointmentIntent);

        //Activity 'Ficha Odontologica'
        }else if (id == R.id.nav_odontological_sheet) {
            Intent odontologicalSheet = new Intent(this, FichaOdontologica.class);
            startActivity(odontologicalSheet);

        //Activity 'Desarrolladores'
        }else if (id == R.id.nav_developers) {
            Intent developersActivity = new Intent(this, DevelopersActivity.class);
            startActivity(developersActivity);

        //Dialog para salir de la aplicación
        }else if (id == R.id.log_out) {
            QuitDialog quitDialog = new QuitDialog();
            FragmentManager manager = getSupportFragmentManager();
            quitDialog.show(manager,"Salir");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /**
     * Método encargado de llenar el ListView del activity principal
     * Se carga con fechas
     * */
    private void chargeListView(List<Horas> horas){
        Toast.makeText(MainActivity.this, horas.toString(), Toast.LENGTH_SHORT).show();
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice);
        reserveBtn.setVisibility(View.VISIBLE);
        for(int i = 0;i < horas.size(); i++)
        {
            listViewAdapter.add(horas.get(i).getHora());
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