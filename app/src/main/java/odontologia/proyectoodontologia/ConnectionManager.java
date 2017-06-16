package odontologia.proyectoodontologia;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bryan on 5/5/2017.
 */

public class ConnectionManager
{
    private String baseurl;
    private final Retrofit retrofit;
    private MainInterface mainInterface;


    public ConnectionManager() {
        this.baseurl = "http://172.24.44.205";
        this.retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        this.mainInterface = retrofit.create(MainInterface.class);
    }

    public MainInterface getMainInterface() {
        return this.mainInterface;
    }

}
