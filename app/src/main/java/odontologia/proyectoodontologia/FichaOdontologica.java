package odontologia.proyectoodontologia;

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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import layout.FichaOdontologicaInformacionMedica;
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
    private static Student student = Student.getInstance();
    private static List<Enfermedad> listaEnfermedades;

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
            //family_address.setText(student."Jardines de Rohrmoser, Pavas, Condiminio Navarra # 25");
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

        /**
         *
         * @param recent_physical_test
         * @param asthma
         * @param heart_diseases
         * @param hepatitis
         * @param low_blood_pressure
         * @param nephrosis
         * @param high_blood_pressure
         * @param rheumatic_fever
         * @param circulatory_diseases
         * @param epilepsy
         * @param pain_in_anditive_region
         * @param venereal_diseases
         * @param excessive_bleeding
         * @param thyroid_gland_disorders
         * @param any_allergy
         * @param allergy_antibiotics
         * @param bleeding_gums
         */
        private void loadMedicalInformation(CheckBox recent_physical_test,CheckBox asthma,CheckBox heart_diseases, CheckBox hepatitis,
                                            CheckBox low_blood_pressure,CheckBox nephrosis,CheckBox high_blood_pressure,
                                            CheckBox rheumatic_fever,CheckBox circulatory_diseases,CheckBox epilepsy,
                                            CheckBox pain_in_anditive_region, CheckBox venereal_diseases, CheckBox excessive_bleeding,
                                            CheckBox thyroid_gland_disorders, CheckBox any_allergy, CheckBox allergy_antibiotics,
                                            CheckBox bleeding_gums, String enfermedad)
        {
            if (enfermedad.equals("recent_physical_test")) {
                recent_physical_test.setChecked(true);
            }
            else if (enfermedad.equals("asthma")) {
                asthma.setChecked(true);
            }
            else if (enfermedad.equals("heart_diseases")) {
                heart_diseases.setChecked(true);
            }
            else if (enfermedad.equals("hepatitis")) {
                hepatitis.setChecked(true);
            }
            else if (enfermedad.equals("low_blood_pressure")) {
                low_blood_pressure.setChecked(true);
            }
            else if (enfermedad.equals("nephrosis")) {
                nephrosis.setChecked(true);
            }
            else if (enfermedad.equals("high_blood_pressure")) {
                high_blood_pressure.setChecked(true);
            }
            else if (enfermedad.equals("rheumatic_fever")) {
                rheumatic_fever.setChecked(true);
            }
            else if (enfermedad.equals("circulatory_diseases")) {
                circulatory_diseases.setChecked(true);
            }
            else if (enfermedad.equals("epilepsy")) {
                epilepsy.setChecked(true);
            }
            else if (enfermedad.equals("pain_in_anditive_region")) {
                pain_in_anditive_region.setChecked(true);
            }
            else if (enfermedad.equals("venereal_diseases")) {
                venereal_diseases.setChecked(true);
            }
            else if (enfermedad.equals("excessive_bleeding")) {
                excessive_bleeding.setChecked(true);
            }
            else if (enfermedad.equals("thyroid_gland_disorders")) {
                thyroid_gland_disorders.setChecked(true);
            }
            else if (enfermedad.equals("any_allergy")) {
                any_allergy.setChecked(true);
            }
            else if (enfermedad.equals("allergy_antibiotics")) {
                allergy_antibiotics.setChecked(true);
            }
            else if (enfermedad.equals("bleeding_gums")) {
                bleeding_gums.setChecked(true);
            }
        }

        private void getAllIdsMedical(View rootView, String enfermedad) {
            final CheckBox recent_physical_test = (CheckBox) rootView.findViewById(R.id.recent_physical_test_cb);
            final CheckBox asthma = (CheckBox) rootView.findViewById(R.id.asthma_cb);
            final CheckBox heart_diseases = (CheckBox) rootView.findViewById(R.id.heart_diseases_cb);
            final CheckBox hepatitis = (CheckBox) rootView.findViewById(R.id.hepatitis_cb);
            final CheckBox low_blood_pressure = (CheckBox) rootView.findViewById(R.id.low_blood_pressure_cb);
            final CheckBox nephrosis = (CheckBox) rootView.findViewById(R.id.nephrosis_cb);
            final CheckBox high_blood_pressure = (CheckBox) rootView.findViewById(R.id.high_blood_pressure_cb);
            final CheckBox rheumatic_fever = (CheckBox) rootView.findViewById(R.id.rheumatic_fever_cb);
            final CheckBox circulatory_diseases = (CheckBox) rootView.findViewById(R.id.circulatory_diseases_cb);
            final CheckBox epilepsy = (CheckBox) rootView.findViewById(R.id.epilepsy_cb);
            final CheckBox pain_in_anditive_region = (CheckBox) rootView.findViewById(R.id.pain_in_anditive_region_cb);
            final CheckBox venereal_diseases = (CheckBox) rootView.findViewById(R.id.venereal_diseases_cb);
            final CheckBox excessive_bleeding = (CheckBox) rootView.findViewById(R.id.excessive_bleeding_cb);
            final CheckBox thyroid_gland_disorders = (CheckBox) rootView.findViewById(R.id.thyroid_gland_disorders_cb);
            final CheckBox any_allergy = (CheckBox) rootView.findViewById(R.id.any_allergy_cb);
            final CheckBox allergy_antibiotics = (CheckBox) rootView.findViewById(R.id.allergy_antibiotics_cb);
            final CheckBox bleeding_gums = (CheckBox) rootView.findViewById(R.id.bleeding_gums_cb);

            loadMedicalInformation(recent_physical_test, asthma, heart_diseases,  hepatitis, low_blood_pressure, nephrosis,
                    high_blood_pressure, rheumatic_fever, circulatory_diseases, epilepsy, pain_in_anditive_region,
                    venereal_diseases,  excessive_bleeding, thyroid_gland_disorders,  any_allergy, allergy_antibiotics, bleeding_gums, enfermedad);
        }

        private void getAllMedicalInformation(final View rootView) {
            String baseurl ="http://172.24.44.66";

            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            MainInterface mainInterface = retrofit.create(MainInterface.class);
            Call<List<Enfermedad>> call = mainInterface.getStudentMedicalInformation(student.getCarne());
            call.enqueue(new Callback<List<Enfermedad>>() {
                @Override
                public void onResponse(Call<List<Enfermedad>> call, Response<List<Enfermedad>> response) {
                    listaEnfermedades = response.body();
                    for (int i = 0; i < response.body().size(); i++)
                    {
                        String a = response.body().get(i).getEnfermedad();
                        getAllIdsMedical(rootView, a);
                    }
                }

                @Override
                public void onFailure(Call<List<Enfermedad>> call, Throwable t) {
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
                final Button btnSave = (Button) rootView.findViewById(R.id.save);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

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
