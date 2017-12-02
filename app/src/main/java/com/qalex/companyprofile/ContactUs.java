package com.qalex.companyprofile;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {

    TextView phone, mail, google, face, twitter, linkedIn;
    Intent i;

    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_us, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Contact Quantum");

        phone = (TextView) view.findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:+201069512534"));
                startActivity(i);
            }
        });

        mail = (TextView) view.findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "info@quantum-tech.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, " ");
                intent.putExtra(Intent.EXTRA_TEXT, " ");
                startActivity(Intent.createChooser(intent, ""));
            }

        });

        google = (TextView) view.findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setClassName("com.google.android.apps.plus",
                            "com.google.android.apps.plus.phone.UrlGatewayActivity");
                    intent.putExtra("customAppUri", "105321907092318486356");
                    startActivity(intent);
                } catch(ActivityNotFoundException e) {
                    // fallback if G+ app is not installed
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/105321907092318486356")));
                }

            }
        });

        face = (TextView) view.findViewById(R.id.face);
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                PackageInfo info = null;
                try {
                    info = getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    if(info.applicationInfo.enabled)
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1909591612692579")));


                } catch (PackageManager.NameNotFoundException e) {
                    // TODO Auto-generated catch block
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Quantum-Tech-1909591612692579/")));
                }
            }

        });

        twitter = (TextView) view.findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageInfo info = null;
                try {
                    info = getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    if(info.applicationInfo.enabled)
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=936329271127179265")));
//					Uri.parse("twitter://user?screen_name=[user_name]"));


                } catch (PackageManager.NameNotFoundException e) {
                    // TODO Auto-generated catch block
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/QuantumTech2")));
                }
            }
        });

        linkedIn = (TextView) view.findViewById(R.id.linkedIn);
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageInfo info = null;
               try{
                   info = getContext().getPackageManager().getPackageInfo("com.linkedin.android", 0);

                   if(info.applicationInfo.enabled)
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/quantum-tech-b99167154")));
//					Uri.parse("twitter://user?screen_name=[user_name]"));


            } catch(PackageManager.NameNotFoundException e) {
                // TODO Auto-generated catch block
                   startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/quantum-tech-b99167154/")));
            }
        }
        });

    }
}
