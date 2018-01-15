package com.example.mohit.aadharverification;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText aadharNumber , aadharName ,password;
    Button aadharSubmit ;

    char [] a = {'p','a','s','s','w','o','r','d'};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aadharName = (EditText)findViewById(R.id.Name);
        aadharNumber = (EditText)findViewById(R.id.aadharNumber);
        aadharSubmit = (Button)findViewById(R.id.aadharSubmit);
        password = (EditText)findViewById(R.id.password);

        aadharSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == aadharSubmit)
        {

            boolean a ;
            //aadharVerfication();
            try {
                authenticateRequest(constructAuthRequest());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void aadharVerfication()
    {
        String name = aadharName.getText().toString().trim();
        String number = aadharNumber.getText().toString().trim();



    }

    private AuthenticationRequestData constructAuthRequest() {
        AuthenticationRequestData request = new AuthenticationRequestData();

        String name = aadharName.getText().toString().trim();
        String number = aadharNumber.getText().toString().trim();
        request.setUid(number);
        request.setName(name);

        try {
            boolean a = authenticateRequest(request);

            if(a==true)
            {
                Toast.makeText(getApplicationContext(),"YES MATCHED",Toast.LENGTH_LONG).show();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return request;

    }

    private boolean authenticateRequest(AuthenticationRequestData authData) throws MalformedURLException {

        boolean authSuccessful = false;


        Meta metaData = createMetaData();
        AUADataCreator auaDataCreator = new AUADataCreator(new Encrypter("uidai_auth_stage.cer"));
        // GIVE FILE LOCATION OF PUBLIC KEY
        AUAData auaData = auaDataCreator.prepareAUAData(authData.getUid(), "public", AuthRequestHelper.createPid(metaData, authData));


        AuthenticationFactors authfactors = new AuthenticationFactors();
        AuthRequestCreator authRequestCreator = new AuthRequestCreator();
        Auth auth = authRequestCreator.createAuthRequest(
                "public",
                "public",
                "MKg8njN6O+QRUmYF+TrbBUCqlrCnbN/Ns6hYbnnaOk99e5UGNhhE/xQ=",
                AuthRequestHelper.createUses(authfactors),
                auaData);

        AuthClient client = null;
        try {
            client = new AuthClient(new URL("http://auth.uidai.gov.in/1.5/").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        client.setDigitalSignator(new DigitalSigner(new File(Environment.getExternalStorageDirectory(), "public.p12").getPath(),a, "Signature Alias"));

        AuthRes authResult = client.authenticate(auth);

        if (authResult != null) {
            if (authResult.getRet().equals(AuthResult.Y)) {

                authSuccessful = true;
            }
        }

        //fillAuthResponseValidationText(auth, authResult, auaData.getHashedDemoXML());

        return authSuccessful;
    }

    private Meta createMetaData() {
        Meta m = new Meta();

            m.setApc("apc");


            m.setFdc("fdc");


            m.setIdc("idc");


        return m;
    }
}
