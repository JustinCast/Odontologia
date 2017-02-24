package odontologia.proyectoodontologia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DateRegister extends AppCompatActivity {

    ListView listView;
    ArrayList arrayCustomerListDateRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_register);
        listView = (ListView) findViewById(R.id.lvDatesRegister);
    }

    public void createList(){
        //listView.setAdapter(new viewAdapter(this));
    }

    public void loadListView(){
        //RestAdapter.Builder builder = new RestAdapter.Builder().setEndpoint(url).setClient(new OkClient(new OkHttpClient()));
        arrayCustomerListDateRegister = new ArrayList<>();
        /*interfaceInstance = builder.build().create(InterfaceClass.class);
        //interfaceInstance.GetAllCustomers(new Callback<ArrayList<CustomerListData>>() {

            @Override
            public void success(ArrayList<CustomerListData> customerListDatas, Response response) {
                arrayCustomerListData = customerListDatas;
                createList();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(Customers.this,"Connection error",Toast.LENGTH_LONG).show();
            }
        });*/
    }

    //public class viewAdapter extends Base

}
