package layout;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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

import odontologia.proyectoodontologia.ConnectionManager;
import odontologia.proyectoodontologia.Horas;
import odontologia.proyectoodontologia.MainActivity;
import odontologia.proyectoodontologia.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatesFragment extends Fragment {
    private int dia, mes, año;
    private TextView txtdate, textView;
    private Button btnDates, reserveBtn;
    private DatePickerDialog datePickerDialog;
    private ConnectionManager connectionManager = new ConnectionManager();
    private View rootView;
    boolean listViewState;
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

        btnDates = (Button) rootView.findViewById(R.id.btnDate);

        btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarShow();
            }
        });

        //Click Listener el boton reservar
        reserveBtn = (Button) rootView.findViewById(R.id.reserve_btn);
        reserveBtn.setVisibility(View.GONE);
        // Se crea el Toast de éxito
        final Toast successToast = Toast.makeText(getActivity(), R.string.succes_appointment,Toast.LENGTH_SHORT);
        final Toast errorToast = Toast.makeText(getActivity(), R.string.error_appointment, Toast.LENGTH_SHORT);
        //chargeListView();

        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(((ListView) rootView.findViewById(R.id.listView)).getSelectedItem());
                if(listViewState)
                    successToast.show();
                else
                    errorToast.show();
            }
        });
        return rootView;
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
                Toast.makeText(getActivity(), "falla", Toast.LENGTH_SHORT).show();
                Snackbar.make(getActivity().getCurrentFocus(), "Error de conexión, intentelo nuevamente.", Snackbar.LENGTH_LONG)
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

    private void chargeListView(List<Horas> horas){
        Toast.makeText(getActivity(), horas.toString(), Toast.LENGTH_SHORT).show();
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_singlechoice);
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
