package com.qalex.companyprofile;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Clients extends Fragment {
    ImageView client1 , client2 , client3 , client4;


    public Clients() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clients, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Quantum Clients");

        client1 = (ImageView) view.findViewById(R.id.FirstLogo);
        client2 = (ImageView) view.findViewById(R.id.SecondLogo);
        client3 = (ImageView) view.findViewById(R.id.ThirdLogo);
        client4 = (ImageView) view.findViewById(R.id.ForthLogo);

        client1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.carrefour.com.eg/default.aspx?langauge=en&country=eg"));
                startActivity(i);
            }
        });

        client2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.ajaden.com/"));
                startActivity(i);
            }
        });

        client3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.panda.com.sa/egypt/"));
                startActivity(i);
            }
        });

        client4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.elarabygroup.com/"));
                startActivity(i);
            }
        });

    }
}
