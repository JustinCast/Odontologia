package odontologia.proyectoodontologia;

/**
 * Created by Justin Cast on 10/3/2017
 */



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface MainInterface {
    @GET("/estudiantes/estudiante/{carne}/{pin}")
    Call<estudiante> getStudent(@Path("carne") String carne, @Path("pin") int pin);
    @POST("/estudiantes/estudiante/{carne}/{pin}") void verifyStudent(Callback<ArrayList<estudiante>> usersCallBack);

    @GET("/estudiantes")
    void GetStudentInformation(Callback<ArrayList<estudiante>>usersCallback);
    @GET("/estudiantes")
    Call<estudiante> getStudent();
}
