package courseraw3.First;


import edu.duke.FileResource;
import org.apache.commons.csv.*;

class First{
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser,"Nauru"));
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"gold"));
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
    public String countryInfo(CSVParser parser,String country){
        CSVRecord c = null;
        for(CSVRecord record:parser){
            if(record.get("Country").equals(country))
            {
                return country+": "+record.get("Exports")+": "+record.get("Value (dollars)");
            }
        }
        return "Country Not Found";
    }

    
    public void listExportersTwoProducts(CSVParser parser , String exportItem1,String exportItem2){
        for(CSVRecord record:parser)
        {
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    public int numberOfExporters(CSVParser parser , String exportItem){
        int count = 0;
        for(CSVRecord record:parser)
        {
            if(record.get("Exports").contains(exportItem)){
                count++;
            }
        }
        return count;
    }

    public void bigExporters(CSVParser parser,String amount){
        int l = amount.length();
        for(CSVRecord record:parser)
        {
            String ramount = record.get("Value (dollars)");
            int rl = ramount.length();

            if(rl>l){

                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }
            else if(rl==l){
                Boolean isGreater = false;
                for(int i=0;i<rl;i++)
                {
                    //System.out.println();
                    if(ramount.charAt(i)>amount.charAt(i))
                    {
                        isGreater=true;
                        break;
                    }
                    else if(ramount.charAt(i)<amount.charAt(i))
                    {
                        isGreater=false;
                        break;
                    }
                    else
                    {
                        continue;
                    }

                }
                if(isGreater)
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        First f = new First();
        f.tester();
    }
}
