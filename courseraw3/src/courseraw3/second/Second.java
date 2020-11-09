package courseraw3.second;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

class Part1{
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(coldestHourInFile(parser));
        parser = fr.getCSVParser();
        System.out.println(lowestHumidityInFile(parser));
        parser = fr.getCSVParser();
        averageTemperatureInFile(parser);
        parser = fr.getCSVParser();
        averageTemperatureWithHighHumidityInFile(parser,80);
    }
    public String coldestHourInFile(CSVParser parser){
        CSVRecord lowest = null;
        for(CSVRecord record:parser){
            if(lowest==null && !record.get("TemperatureF").equals("-9999")) {
                lowest = record;
            }
            else if ((Double.parseDouble(lowest.get("TemperatureF")) > Double.parseDouble(record.get("TemperatureF")))&& !record.get("TemperatureF").equals("-9999")) {
                        lowest=record;
            }
        }
        return "Lowest Temperature is "+lowest.get("TemperatureF")+" at time "+lowest.get("DateUTC");
    }
    public void fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        String name=null;
        CSVRecord lowest=null;
        for(File f:dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            for(CSVRecord record:parser){
                if(lowest==null && !record.get("TemperatureF").equals("-9999")) {
                    lowest = record;
                    name = f.getName();
                }
                else if ((Double.parseDouble(lowest.get("TemperatureF")) > Double.parseDouble(record.get("TemperatureF")))&& !record.get("TemperatureF").equals("-9999")) {
                    lowest=record;
                    name = f.getName();
                }
            }
        }
        System.out.println("Name of the file is :"+name);
    }
    public void testFileWithColdestTemperature(){
        fileWithColdestTemperature();
    }
    public String lowestHumidityInFile(CSVParser parser){
        CSVRecord lowest = null;
        for(CSVRecord record:parser){
            if(lowest==null && !record.get("Humidity").equals("N/A")) {
                lowest = record;
            }
            else if ((Integer.parseInt(lowest.get("Humidity")) > Integer.parseInt(record.get("Humidity")))&& !record.get("Humidity").equals("N/A")) {
                lowest=record;
            }
        }
        return "Lowest Humidity is "+lowest.get("Humidity")+" at time "+lowest.get("DateUTC");
    }
    public void lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        //String name=null;
        CSVRecord lowest=null;
        for(File f:dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            for(CSVRecord record:parser){
                if(lowest==null && !record.get("Humidity").equals("N/A")) {
                    lowest = record;
                    //name = f.getName();
                }
                else if ((Integer.parseInt(lowest.get("Humidity")) > Integer.parseInt(record.get("Humidity")))&& !record.get("Humidity").equals("N/A")) {
                    lowest=record;
                    //name = f.getName();
                }
            }
        }
        System.out.println("Lowest Humidity in Multiple Files was "+lowest.get("Humidity")+" at "+lowest.get("DateUTC"));
    }
    public void testLowestHumidityInManyFiles(){
        lowestHumidityInManyFiles();
    }
    public void averageTemperatureInFile(CSVParser parser){
        int count=0;
        double avg=0;
        for(CSVRecord record:parser){
            if(!record.get("TemperatureF").equals("-9999"))
                avg+=Double.parseDouble(record.get("TemperatureF"));
            count++;
        }
        System.out.println("Average Temp is : "+avg/count);
    }
    public void averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
        int count=0;
        double avg=0;
        for(CSVRecord record:parser){
            if(Integer.parseInt(record.get("Humidity"))>=value) {
                avg += Double.parseDouble(record.get("TemperatureF"));
                count++;
            }
        }
        if(avg==0)
            System.out.println("No temperatures with that humidity");
        else
          System.out.println("Average Temp with Humidity is : "+avg/count);
    }

}

public class Second {
    public static void main(String args[]) {
        Part1 p = new Part1();
       p.testColdestHourInFile();
        //p.testFileWithColdestTemperature();
    }

}
