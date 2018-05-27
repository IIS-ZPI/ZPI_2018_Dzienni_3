package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class DataDownloader {

    ArrayList<StateData> data = new ArrayList<>();
    StateData tmp;

    public boolean DownloadData (){
        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        content = content.split("<table class=\"wikitable sortable\" style=\"margin-left:10px; text-align:center\">")[1];
        content = content.split("</table>")[0];
        content = "<table>" + content + "</table>";

        Document doc = Jsoup.parse(content);
        Elements tableElements = doc.select("table");

        Elements tableRowElements = tableElements.select(":not(thead) tr");

        for (int i = 0; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");

            //działa nie ruszać
            if(rowItems.size()>0) {
                tmp = new StateData(rowItems.get(0).text());
                tmp.setBaseTax(rowItems.get(1).text());
                tmp.setLocalSurTax(rowItems.get(2).text());
            }
            data.add(tmp);
        }

        data.remove(0);
        System.out.println(data);
        System.out.println(data.size());

        return true;

    }
}
