package layout;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import odontologia.proyectoodontologia.Cita;
import odontologia.proyectoodontologia.ConnectionManager;
import odontologia.proyectoodontologia.Horas;
import odontologia.proyectoodontologia.R;
import odontologia.proyectoodontologia.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatesFragment extends Fragment {
    private int dia, mes, año;
    private TextView txtdate, txtHour, textView;
    private Button btnDates, reserveBtn;
    private DatePickerDialog datePickerDialog;
    private static final String TAG = "OCVSample::Activity";
    private ConnectionManager connectionManager = new ConnectionManager();
    private View rootView;
    private boolean listViewState, permisoCita;
    private String hora;
    ListView listView;
    private static Student student = Student.getInstance();
    public DatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Manejo Citas");
        rootView = inflater.inflate(R.layout.fragment_dates, container, false);
        txtdate = (TextView) rootView.findViewById(R.id.txtdate);
        textView = (TextView) rootView.findViewById(R.id.textView);
        txtHour = (TextView) rootView.findViewById(R.id.textView2);
        txtHour.setVisibility(View.GONE);

        getUserSelectedDate();
        listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setVisibility(View.GONE);
        btnDates = (Button) rootView.findViewById(R.id.btnDate);
        reserveBtn = (Button) rootView.findViewById(R.id.reserve_btn);
        reserveBtn.setVisibility(View.GONE);


        btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permisoCita == true) {
                    calendarShow();
                }
                else {
                    Snackbar.make(getActivity().getCurrentFocus(), R.string.DateSelected, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        //Click Listener el boton reservar

        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cita cita = new Cita(student.getCarne(),txtdate.getText().toString(), hora);
                Call<Boolean> call = connectionManager.getMainInterface().setUserSelectedDate(cita, student.getCarne());
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Snackbar.make(getActivity().getCurrentFocus(), R.string.succes, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        reserveBtn.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Snackbar.make(getActivity().getCurrentFocus(), R.string.connectingError, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        });
        return rootView;
    }

    private void getUserSelectedDate() {
        Call<String> call = connectionManager.getMainInterface().getUserSelectedDate(student.getCarne());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                validateUserDateInfo(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Snackbar.make(getActivity().getCurrentFocus(), R.string.connectingError, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void validateUserDateInfo(String carne) {

        if (carne.equals("1")) {
            textView.setText(R.string.DateSelected + "12/12/2017");
            permisoCita = false;
        }
        else {
            textView.setText(R.string.noDateSelected);
            permisoCita = true;
        }
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
                Snackbar.make(getActivity().getCurrentFocus(), R.string.connectingError, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void calendarShow() {
        Calendar c = Calendar.getInstance();
        año = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtdate.setText((month+1)+"-"+dayOfMonth+"-"+year);
                if (txtdate.getText().toString() != "") {
                    textView.setVisibility(View.GONE);
                }
                getAvailableDates();

            }
        },año,mes,dia);
        datePickerDialog.show();
    }

    private void chargeListView(final List<Horas> horas){

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_singlechoice);
        for(int i = 0;i < horas.size(); i++)
        {
            listViewAdapter.add(horas.get(i).getHora());
        }
        listView.setAdapter(listViewAdapter);
        if (horas.size() > 0) {
            txtHour.setVisibility(View.VISIBLE);
            listView.setVisibility(View.VISIBLE);
        }
        else {
            textView.setText(R.string.availableHours);
            textView.setVisibility(View.VISIBLE);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                reserveBtn.setVisibility(View.VISIBLE);
                hora = horas.get(position).getHora();
            }
        });
    }
}
