package com.exampledev.test1;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;
import static com.exampledev.test1.MainActivity.e;
import static com.exampledev.test1.MainActivity.p;

public class jasondata extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    public  static String tokenlgn= "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://srm-academia.herokuapp.com/token?email="+e+"&pass="+p);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
                Log.i(TAG, "doInBackground: "+data);
            }


                JSONObject JO = new JSONObject(data);
                singleParsed = "token" + JO.get("token")+"\n";
                tokenlgn = JO.getString("token");



                dataParsed = dataParsed + singleParsed +"\n" ;





            Log.i(TAG, "doInBackground: "+tokenlgn);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        main2.txt1.setText(this.tokenlgn);

    }
}