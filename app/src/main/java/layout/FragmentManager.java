package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import odontologia.proyectoodontologia.R;

/**
 * Created by Justin Cast on 3/3/2017.
 */

public class FragmentManager extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment,viewGroup, false);
    }
}
