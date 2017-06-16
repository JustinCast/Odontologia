package odontologia.proyectoodontologia;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FichaOdontologica extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private static final String TAG = "OCVSample::Activity";
    private static Student student = Student.getInstance();
    private static List<Enfermedad> listaEnfermedades;
    private static ConnectionManager connectionManager = new ConnectionManager();

    private String timeStamp;

    //ArrayList<ProductListData> arrayListProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_odontologica);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
        //System.out.println(timeStamp);
        //Toast.makeText(getBaseContext(), timeStamp,Toast.LENGTH_SHORT).show();
        //scholarship = (TextView) findViewById(R.id.scholarship_tv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ficha_odontologica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        /**
         * metodo que llena los campos en el view con la informacion que tiene el objeto estudiante.
         * los siguientes parametros son los atributos necesarios para el mostrar la informacion en la vista,
         * los mismo son textviews
         * @param scholarship
         * @param name
         * @param surname
         * @param second_surname
         * @param student_id
         * @param major
         * @param civil_status
         * @param CCSS_id
         * @param birth_date
         * @param person_id
         * @param phone
         */
        private void loadPersonalInformation(TextView scholarship,TextView name,TextView surname,
                                             TextView second_surname,TextView student_id,TextView major
                                            ,TextView civil_status,TextView CCSS_id,TextView birth_date
                                            ,TextView person_id,TextView phone)
        {
            scholarship.setText(student.getBeca());
            name.setText(student.getNombre());
            surname.setText(student.getApellido1());
            second_surname.setText(student.getApellido2());
            student_id.setText(student.getCarne());
            major.setText(student.getCarrera());
            civil_status.setText(student.getEstadoCivil());
            CCSS_id.setText(student.getCarneCCSS());
            birth_date.setText(student.getFechaNacimiento());
            person_id.setText(student.getCedula());
            phone.setText(student.getTelefono());

        }

        /**
         * obtiene o enlaza los textviews del layout con la logica de java
         * @param rootView  es el layout en el que se encuentran los ids
         */
        private void getAllIdsPersonalInformation(View rootView) {
            final TextView scholarship = (TextView) rootView.findViewById(R.id.scholarship_tv);
            final TextView name = (TextView) rootView.findViewById(R.id.name_tv);
            final TextView surname = (TextView) rootView.findViewById(R.id.surname_tv);
            final TextView second_surname = (TextView) rootView.findViewById(R.id.second_surname_tv);
            final TextView student_id = (TextView) rootView.findViewById(R.id.student_id_tv);
            final TextView major = (TextView) rootView.findViewById(R.id.major_tv);
            final TextView civil_status = (TextView) rootView.findViewById(R.id.civil_status_tv);
            final TextView CCSS_id = (TextView) rootView.findViewById(R.id.CCSS_id_tv);
            final TextView birth_date = (TextView) rootView.findViewById(R.id.birth_date_tv);
            final TextView person_id = (TextView) rootView.findViewById(R.id.person_id_tv);
            final TextView phone = (TextView) rootView.findViewById(R.id.phone_tv);
            loadPersonalInformation(scholarship, name, surname, second_surname, student_id, major
                    ,civil_status, CCSS_id, birth_date, person_id, phone);
        }

        public class EnfermedadAdapter extends ArrayAdapter<Enfermedad> {
            private final Activity context;
            private List<Enfermedad> enfermedadesGlobal;
            private CheckBox checkBox;

            public EnfermedadAdapter(Activity context, List<Enfermedad> enfermedadesGlobal) {
                super(context, R.layout.row_simple, enfermedadesGlobal);
                this.context = context;
                this.enfermedadesGlobal = enfermedadesGlobal;
            }

            public View getView(int position, View view, ViewGroup parent) {
                LayoutInflater inflater = context.getLayoutInflater();
                View rowView = inflater.inflate(R.layout.row_simple, null, true);
                checkBox = (CheckBox) rowView.findViewById(R.id.boxSimple);
                checkBox.setText(enfermedadesGlobal.get(position).getEnfermedad());
                final Enfermedad enfermedad = enfermedadesGlobal.get(position);
                for (int j=0; j < listaEnfermedades.size(); j++) {
                    if (enfermedadesGlobal.get(position).getEnfermedad().equals(listaEnfermedades.get(j).getEnfermedad())) {
                        checkBox.setChecked(true);
                        break;
                    }
                }
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        /*Call<Enfermedad> call = connectionManager.getMainInterface().setuserDisease(enfermedad,student.getCarne(),timeStamp);
                        call.enqueue(new Callback<Enfermedad>() {
                            @Override
                            public void onResponse(Call<Enfermedad> call, Response<Enfermedad> response) {

                            }

                            @Override
                            public void onFailure(Call<Enfermedad> call, Throwable t) {

                            }
                        });*/

                    }
                });
                return rowView;
            }
        }

        private void cargarLista(View rootView, List<Enfermedad> model) {
            ListView lvDatos = (ListView) rootView.findViewById(R.id.lvEnfermedades);
            EnfermedadAdapter adapter= new EnfermedadAdapter(getActivity(),model);
            lvDatos.setAdapter(adapter);
        }
        private void userDiseases(List<Enfermedad> enfermedades) {
            listaEnfermedades = enfermedades;
            Log.e(TAG, enfermedades.toString());
        }
        private void getAllMedicalInformation(final View rootView) {
            Call<List<Enfermedad>> call = connectionManager.getMainInterface().getuserDiseases(student.getCarne());
            call.enqueue(new Callback<List<Enfermedad>>() {
                @Override
                public void onResponse(Call<List<Enfermedad>> call, Response<List<Enfermedad>> response) {
                    userDiseases(response.body());
                }

                @Override
                public void onFailure(Call<List<Enfermedad>> call, Throwable t) {
                    Snackbar.make(getActivity().getCurrentFocus(), R.string.connectingError, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            call = connectionManager.getMainInterface().getAllDiseases();
            call.enqueue(new Callback<List<Enfermedad>>() {
                @Override
                public void onResponse(Call<List<Enfermedad>> call, Response<List<Enfermedad>> response) {
                    cargarLista(rootView, response.body());
                }

                @Override
                public void onFailure(Call<List<Enfermedad>> call, Throwable t) {
                    Snackbar.make(getActivity().getCurrentFocus(), R.string.connectingError, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            View rootView;
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {

                rootView = inflater.inflate(R.layout.fragment_ficha_odontologica_informacion_personal, container, false);
                getAllIdsPersonalInformation(rootView);
            }
            else {
                rootView = inflater.inflate(R.layout.fragment_ficha_odontologica_informacion_medica, container, false);
                getAllMedicalInformation(rootView);
                FloatingActionButton btnAgregarMedicamento = (FloatingActionButton) rootView.findViewById(R.id.btnSave);
                btnAgregarMedicamento.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "INF. PERSONAL";
                case 1:
                    return "INF. MÉDICA";
            }
            return null;
        }
    }
}
