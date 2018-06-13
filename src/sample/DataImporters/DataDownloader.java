package sample.DataImporters;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sample.ConvertedData.StateData;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class DataDownloader {

    ArrayList<StateData> data = new ArrayList<>();
    StateData tmp;

    public ArrayList<StateData> DownloadData() {

        String content = null;
        URLConnection connection = null;
        try {
            connection = new URL("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        } catch (Exception ex) {
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
            if(rowItems.size() > 0) {
                if(rowItems.get(0).text().contains("]"))
                    tmp = new StateData(rowItems.get(0).text().substring(0,rowItems.get(0).text().indexOf("[")));
                else
                    tmp = new StateData(rowItems.get(0).text());
                tmp.setBaseTax(rowItems.get(1).text());
                tmp.setLocalSurTax(rowItems.get(2).text());

              //  extractTax(rowItems.get(3).attributes().toString());

                tmp.addTaxForProductType("Groceries",extractTax(rowItems.get(3).attributes().toString()));
                tmp.addTaxForProductType("PrepFood",rowItems.get(4).attributes().toString());
                tmp.addTaxForProductType("PrescrDrug",rowItems.get(5).attributes().toString());
                tmp.addTaxForProductType("NonPrescrDrug",rowItems.get(6).attributes().toString());
                tmp.addTaxForProductType("Clothing",rowItems.get(7).attributes().toString());
                if(rowItems.size()==9)
                    tmp.addTaxForProductType("Intangibles",rowItems.get(8).attributes().toString());
                else
                    tmp.addTaxForProductType("Intangibles","0%");
            }
            data.add(tmp);
        }

        data.remove(0);

        return data;

    }

    protected String extractTax(String attribute) {
    //    System.out.println(attribute);
        if(attribute.substring(attribute.indexOf("#"),attribute.lastIndexOf(";")).equals("#4ee04e;"))
            return "0%";
        else if (attribute.substring(attribute.indexOf("#"),attribute.lastIndexOf(";")).equals("#7788ff;"))
            return tmp.getBaseTax();
        else
            return "0%";

        }
    }


