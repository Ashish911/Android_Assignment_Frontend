package com.example.onlinefoodportal;

import android.util.Log;

import com.example.onlinefoodportal.url.Url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class DownloadUrl {

    public String readUrl(String myurl) throws IOException{

        String data = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(myurl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }

            data = stringBuffer.toString();
            bufferedReader.close();
        }
        catch (MalformedInputException e){
            Log.i("DownloadUrl", "readUrl: " + e.getMessage());
        }

        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            httpURLConnection.disconnect();
        }
        return data;
    }
}
