package com.example.livecv.ui.Mydoviz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.livecv.R;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DovizActivity extends AppCompatActivity {

    ListView listView;
    DovizActivity dovizActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.doviz_activity );
        listView = findViewById( R.id.currencyListView );
        dovizActivity = this;
    }
    public void getRates(View view){
        DownloadData downloadData = new DownloadData();
        try {
            String url = "http://data.fixer.io/api/latest?access_key=dd8624875805a107f850660bdfa91efe&format=1";
            downloadData.execute(url);
            Toast.makeText ( dovizActivity, "tıklama işlemi", Toast.LENGTH_SHORT ).show ();
            
        }catch (Exception e){
        }
    }

    private class DownloadData extends AsyncTask<String, Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;
            try {

                url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();

                while (data > 0) {
                    char character = (char) data;
                    result += character;

                    data = inputStreamReader.read();
                }

                return result;

            } catch (Exception e){
                return null;
            }


        }

        public void currencyLoader(String s){


            try
            {
                TlConverter tlConverter = new TlConverter();
                JSONObject jsonObject = new JSONObject(s);
                if(jsonObject != null) {
                    String rates = jsonObject.getString ( "rates" );
                    JSONObject jsonObject1 = new JSONObject ( rates );
                    if(jsonObject1!=null) {

                        String turkishLira = jsonObject1.getString ( "TRY" );
                        String usd = jsonObject1.getString ( "USD" );
                        String cad = jsonObject1.getString ( "CAD" );
                        String jpy = jsonObject1.getString ( "JPY" );
                        String chf = jsonObject1.getString ( "CHF" );
                        double trLira = Double.parseDouble ( turkishLira );
                        String tl = new DecimalFormat ( "##.###" ).format ( trLira );

                        if (turkishLira!=null || usd != null || cad != null || jpy != null || chf != null) {
                            String cadTl = tlConverter.tlc ( cad, turkishLira );
                            String jpyTl = tlConverter.tlc ( jpy, turkishLira );
                            String chfTl = tlConverter.tlc ( chf, turkishLira );
                            String usdTl = tlConverter.tlc ( usd, turkishLira );


                            Currency Euro = new Currency ( tl, icon1 );
                            Currency Cad = new Currency ( cadTl, icon2 );
                            Currency Chf = new Currency ( chfTl, icon3 );
                            Currency Usd = new Currency ( usdTl, icon4 );
                            Currency Jpy = new Currency ( jpyTl, icon5 );

                            if (Euro!=null || Cad != null || Chf != null || Usd != null || Jpy != null) {
                                ArrayList<Currency> currencyArrayList = new ArrayList<Currency> ();

                                currencyArrayList.add ( Euro );
                                currencyArrayList.add ( Cad );
                                currencyArrayList.add ( Chf );
                                currencyArrayList.add ( Usd );
                                currencyArrayList.add ( Jpy );

                                DovizCustomAdapter dovizCustomAdapter = new DovizCustomAdapter ( currencyArrayList, dovizActivity );
                                listView.setAdapter ( dovizCustomAdapter );
                            }
                        }
                    }
                }
            }
            catch (Exception e)
            {

                Toast.makeText ( dovizActivity, "tıklama işlemi"+e, Toast.LENGTH_SHORT ).show ();
            }
        }

        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),R.drawable.euro);
        Bitmap icon2 = BitmapFactory.decodeResource(getResources(),R.drawable.cad);
        Bitmap icon3 = BitmapFactory.decodeResource(getResources(),R.drawable.chf);
        Bitmap icon4 = BitmapFactory.decodeResource(getResources(),R.drawable.usd);
        Bitmap icon5 = BitmapFactory.decodeResource(getResources(),R.drawable.jpy);



        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            currencyLoader ( s );
        }

    }
}
