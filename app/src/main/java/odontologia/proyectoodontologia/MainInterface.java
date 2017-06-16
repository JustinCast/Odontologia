package odontologia.proyectoodontologia;

/**
 * Created by Justin Cast on 10/3/2017
 */



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MainInterface {
    @GET("/server-odonto/estudiantes/estudiante/{carne}/{pin}")
    Call<estudiante> getStudent(@Path("carne") String carne, @Path("pin") int pin);

    /*@POST("/server-odonto/Enfermedades/Estudiante/{carne}")
    Call<List<Enfermedad>> getStudentMedicalInformation(@Body List<Enfermedad> listaEnfermedades, @Path("carne") String carne);
*/
    @POST("/server-odonto/ConfigCita/InsertarCita/{carn}")
    Call<Boolean> setUserSelectedDate(@Body Cita cita, @Path("carn") String carn);

    @GET("/server-odonto/Enfermedades")
    Call<List<Enfermedad>> getAllDiseases();

    @POST("/server-odonto/Enfermedades/Estudiante/{carne}")
    Call<List<Enfermedad>> getuserDiseases(@Path("carne") String carne);

    @POST("/server-odonto/Enfermedades/Estudiante/{carne}/fecha")
    Call<Enfermedad> setuserDisease(@Body Enfermedad enfermedad, @Path("carne") String carne, @Path("fecha") String fecha);

    @GET("/server-odonto/Horas/{fecha}")
    Call<List<Horas>> getAvailableDateHours(@Path("fecha") String fecha);

    @GET("/server-odonto/ConfigCita/validarPreCitaUsuario/{carn}")
    Call<String> getUserSelectedDate(@Path("carn") String carn);
}
//http://172.24.44.66/server-odonto/Enfermedades/Estudiante/201500777