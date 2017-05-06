package odontologia.proyectoodontologia;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bryan on 5/5/2017.
 */

public class ConectionManager
{
    private String baseurl ="http://172.24.43.50";
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private MainInterface mainInterface = retrofit.create(MainInterface.class);


}
