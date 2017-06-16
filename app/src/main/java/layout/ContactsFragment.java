package layout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import odontologia.proyectoodontologia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {

    private View rootView;
    private FloatingActionButton buttonCall, buttonFacebook;

    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Contactos");
        rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        buttonCall = (FloatingActionButton) rootView.findViewById(R.id.btnCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialContactPhone("24013101");
            }
        });
        buttonFacebook = (FloatingActionButton) rootView.findViewById(R.id.btnFacebook);
        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlFacebook = "https://www.facebook.com/enfermeria.sancarlos?hc_ref=SEARCH&fref=facebook";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urlFacebook));
                startActivity(i);
            }
        });

        return rootView;
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

}
