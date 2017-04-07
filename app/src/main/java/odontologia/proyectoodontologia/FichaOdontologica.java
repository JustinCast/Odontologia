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

        private void loadPersonalInformation(TextView scholarship,TextView name,TextView surname,
                                             TextView second_surname,TextView student_id,TextView major
                                            ,TextView civil_status,TextView CCSS_id,TextView birth_date
                                            ,TextView person_id,TextView family_address,TextView phone)
        {

            scholarship.setText("Beca prestamo");
            name.setText("Bryan");
            surname.setText("Ruiz");
            second_surname.setText("Bran");
            student_id.setText("2014080589");
            major.setText("Ingenieria en computación");
            civil_status.setText("Soltero");
            CCSS_id.setText("N / A");
            birth_date.setText("14/08/1995");
            person_id.setText("1-1615-0482");
            family_address.setText("Jardines de Rohrmoser, Pavas, Condiminio Navarra # 25");
            phone.setText("87928971");
        }

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
            final TextView family_address = (TextView) rootView.findViewById(R.id.family_address_tv);
            final TextView phone = (TextView) rootView.findViewById(R.id.phone_tv);
            loadPersonalInformation(scholarship, name, surname, second_surname, student_id, major
                    ,civil_status, CCSS_id, birth_date, person_id, family_address, phone);
        }

        private void loadMedicalInformation(CheckBox recent_physical_test,CheckBox asthma,CheckBox heart_diseases, CheckBox hepatitis,
                                            CheckBox low_blood_pressure,CheckBox nephrosis,CheckBox high_blood_pressure,
                                            CheckBox rheumatic_fever,CheckBox circulatory_diseases,CheckBox epilepsy,
                                            CheckBox pain_in_anditive_region, CheckBox venereal_diseases, CheckBox excessive_bleeding,
                                            CheckBox thyroid_gland_disorders, CheckBox any_allergy, CheckBox allergy_antibiotics,
                                            CheckBox bleeding_gums, EditText others)
        {
            recent_physical_test.setChecked(true);
            asthma.setChecked(true);
            heart_diseases.setChecked(true);
            hepatitis.setChecked(true);
            low_blood_pressure.setChecked(true);
            nephrosis.setChecked(true);
            high_blood_pressure.setChecked(true);
            rheumatic_fever.setChecked(true);
            circulatory_diseases.setChecked(true);
            epilepsy.setChecked(true);
            pain_in_anditive_region.setChecked(true);
            venereal_diseases.setChecked(true);
            excessive_bleeding.setChecked(true);
            thyroid_gland_disorders.setChecked(true);
            any_allergy.setChecked(true);
            allergy_antibiotics.setChecked(true);
            bleeding_gums.setChecked(false);
            others.setText("ya casi te termino");
            String baseurl ="http://172.24.47.142";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Toast.makeText(getContext(),"VA",Toast.LENGTH_SHORT).show();
            final MainInterface mainInterface = retrofit.create(MainInterface.class);//se crea una interface para acceder a los datos del endpoint
            final Call<enfermedad> call = mainInterface.GetStudentInformation();
            call.enqueue(new Callback<enfermedad>() {
                @Override
                public void onResponse(Call<enfermedad> call, Response<enfermedad> response) {
                    Toast.makeText(getContext(),"VIENE",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<enfermedad> call, Throwable t) {
                    Toast.makeText(getContext(),"MAMA",Toast.LENGTH_SHORT).show();
                }
            });
            //bleeding_gums.setChecked(true);
        }

        private void getAllIdsMedicalInformation(View rootView) {
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
            final EditText others = (EditText) rootView.findViewById(R.id.others_et);

            loadMedicalInformation(recent_physical_test, asthma, heart_diseases,  hepatitis, low_blood_pressure, nephrosis,
                    high_blood_pressure, rheumatic_fever, circulatory_diseases, epilepsy, pain_in_anditive_region,
                    venereal_diseases,  excessive_bleeding, thyroid_gland_disorders,  any_allergy, allergy_antibiotics, bleeding_gums, others);
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
                getAllIdsMedicalInformation(rootView);
                final Button btnSave = (Button) rootView.findViewById(R.id.save);

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
