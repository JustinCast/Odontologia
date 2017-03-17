package odontologia.proyectoodontologia;

/**
 * Created by Justin Cast on 10/3/2017
 */

import java.util.ArrayList;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface MainInterface {
    @GET("/estudiantes/estudiante/{carne}/{pin}") void getAllStudents(Callback<ArrayList<Student>> usersCallBack);
}
