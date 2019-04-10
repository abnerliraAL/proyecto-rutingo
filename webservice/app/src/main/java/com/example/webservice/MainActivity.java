package com.example.webservice;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private ListView lv_ruta_list;
    private ArrayAdapter adapter;
    private String getAllRutaURL = "http://192.168.1.114:8080/api_clientes?user_hash=12345&action=get";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        lv_ruta_list = (ListView)findViewById(R.id.lv_ruta_list);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        lv_ruta_list.setAdapter(adapter);
        webServiceRest(getAllRutaURL);

    }


    private void webServiceRest(String requestURL){
        try{
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            String webServiceResult="";
            while ((line = bufferedReader.readLine()) != null){
                webServiceResult += line;
            }
            Log.e("webservice_aj",webServiceResult.toString());
            bufferedReader.close();
            parseInformation(webServiceResult);
        }catch(Exception e){
            Log.e("error 99", e.getMessage());
        }
    }
    private void parseInformation(String jsonResult){
        JSONArray jsonArray = null;
        String nombre;
        String telefono;
        String email;
        String apellido_pa ;
        String apellido_ma;
        String utl;

        try{
            jsonArray = new JSONArray(jsonResult);
        }catch (JSONException e){
            Log.e("error 100", e.getMessage());
        }
        for(int i=0;i<jsonArray.length();i++){
            try{
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nombre = jsonObject.getString("nombre");
                telefono = jsonObject.getString("telefono");
                email = jsonObject.getString("email");
                apellido_pa = jsonObject.getString("apellido_pa");
                apellido_ma = jsonObject.getString("apellido_ma");
                utl = jsonObject.getString("utl");
                adapter.add(utl);
            }catch (JSONException e){
                Log.e("error 101", e.getMessage());


            }
        }
    }
}



