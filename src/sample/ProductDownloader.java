package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductDownloader {

    private String url;
    private ArrayList<ImportedProductData> importedProductData = new ArrayList<>();
    private HashMap<String, String> productWithCategory = new HashMap<>();

    public ProductDownloader(String url) {
        this.url = url;
    }

    public void downloadProductList(){
        try {
            URL oracle = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                String[] split = inputLine.split(",");
                importedProductData.add(new ImportedProductData(split[0], split[1], split[2]));
                productWithCategory.put(split[0], split[1]);
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

    public ArrayList<ImportedProductData> getImportedProductData()
    {
        return importedProductData;
    }

    public HashMap<String, String> getProductWithCategory() {
        return productWithCategory;
    }
}
