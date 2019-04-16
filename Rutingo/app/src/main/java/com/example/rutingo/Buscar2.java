package com.example.rutingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Buscar2 extends AppCompatActivity {
    private ListView lv_ruta_list;
    private ArrayAdapter adapter;
    private String getAllRutaURL = "http://130.100.20.194:8080/api_rutas?user_hash=12345&action=get&id_ruta=2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar2);

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
        String punto_inicio;
        String punto_final ;
        String hora_inicio_labor;
        String hora_final_labor;
        String costo;
        String url_ruta;
        String transcurso;
        try{
            jsonArray = new JSONArray(jsonResult);
        }catch (JSONException e){
            Log.e("error 100", e.getMessage());
        }
        for(int i=0;i<jsonArray.length();i++){
            try{
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nombre = jsonObject.getString("nombre");
                punto_inicio = jsonObject.getString("punto_inicio");
                punto_final = jsonObject.getString("punto_final");
                hora_inicio_labor = jsonObject.getString("hora_inicio_labor");
                hora_final_labor = jsonObject.getString("hora_final_labor");
                transcurso = jsonObject.getString("transcurso");
                costo = jsonObject.getString("costo");
                url_ruta = jsonObject.getString("url_ruta");



                adapter.add(nombre );
                adapter.add(punto_inicio );
                adapter.add(punto_final);
                adapter.add(hora_inicio_labor);
                adapter.add(hora_final_labor);
                adapter.add(transcurso);
                adapter.add(costo);
                adapter.add(url_ruta);




            }catch (JSONException e){
                Log.e("error 101", e.getMessage());


            }
        }
    }
}
