package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDownloader {

    private String url;
    private ArrayList<ImportedProduct> importedProducts = new ArrayList<>();

    public ProductDownloader(String url) {
        this.url = url;
    }

    public void downloadProcutList(){
        try {
            URL oracle = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                String[] splited = inputLine.split(",");
                importedProducts.add(new ImportedProduct(splited[0], splited[1], splited[2]));
            }
            in.close();

            String content = null;
            URLConnection connection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
