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
import static com.exampledev.test1.jasondata.tokenlgn;
import static com.exampledev.test1.main2.logintoken;
import static com.exampledev.test1.main2.txt1;

public class jasondata1 extends AsyncTask<Void,Void,Void> {
    String data1 ="";
    String dataParsed = "";
    String singleParsed ="";
    public  static String attdata= "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://srm-academia.herokuapp.com/AttAndMarks?token={{"+logintoken+"}}");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data1 = data1 + line;

            }
            JSONObject JO = new JSONObject(data1);
            tokenlgn = JO.getString("data");
            Log.i(TAG, "doInBackground: "+tokenlgn);

            JSONArray JA = new JSONArray(tokenlgn);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO1 = (JSONObject) JA.get(i);
                singleParsed =  "CourseTitle:" + JO1.get("CourseTitle") + "\n"+
                        "FacultyName:" + JO1.get("FacultyName") + "\n"+
                        "Slot:" + JO1.get("Slot") + "\n"+
                        "Attendance:" + JO1.get("Attendance") + "\n";

                dataParsed = dataParsed + singleParsed +"\n" ;


            }




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

        main3.txt4.setText(this.dataParsed);

    }
}