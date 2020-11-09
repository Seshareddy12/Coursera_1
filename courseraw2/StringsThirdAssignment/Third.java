package StringsThirdAssignment;
import edu.duke.StorageResource;
class Part1{
    public int findStopCodon(String dna,int index,String stopCodon){
        int pos = dna.indexOf(stopCodon,index+1);
        if((index-pos)%3==0)
            return pos;
        return dna.length();

    }
    public String findGene(String dna,int where)
    {
        int start = dna.indexOf("ATG",where);
        if(start==-1)
            return "";
        int end1 = findStopCodon(dna,start,"TAA");
        int end2 = findStopCodon(dna,start,"TAG");
        int end3 = findStopCodon(dna,start,"TGA");
        int min = Math.min(end3,Math.min(end1,end2));
        if(min==dna.length())
            return "";
        return dna.substring(start,min+3);

    }
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int start = 0;
        int count=0;
        while(true){

            String current = findGene(dna,start);
            if(current.isEmpty())
                break;
            geneList.add(current);
            start = dna.indexOf(current,start)+current.length();

        }
        return geneList;
    }
}

class Part2{
    public double cgratio(String dna){
        float v = (float) (count(dna, 'C') + count(dna, 'G')) / dna.length();
        return v;
    }
    public int count(String s, char c)
    {
        int res = 0;

        for (int i=0; i<s.length(); i++)
        {
            // checking character in string 
            if (s.charAt(i) == c)
                res++;
        }
        return res;
    }
    public int countCTG(String dna){
        int count=0,start=0;
        while(true)
        {
            start = dna.indexOf("CTG",start);
            if(start==-1)
                break;
            start=start+3;
            count++;

        }
        return count;
    }

}

class Part3{
    Part2 p2 = new Part2();
    public void processGenes(StorageResource sr){
        int count=0;
        for(String s:sr.data())
        {
            if(s.length()>9) {
                System.out.println(s);
                count++;
            }
        }
        System.out.println("Count of genes with length more than 9 : "+count);
        count=0;
        for(String s:sr.data())
        {
            if(p2.cgratio(s)>0.35) {
                System.out.println(s);
                count++;
            }
        }
        System.out.println("Count of genes with cgratio more than 0.35 : "+count);
        count=0;
        int l=0;
        for(String s:sr.data())
        {
            l=s.length();
            if(count<l) {

                count=s.length();
            }
        }
        System.out.println("The largest gene length : "+count);
    }
}
public class Third {
    public static void main(String args[]){
        Part1 p1 = new Part1();
        Part2 p2 = new Part2();
        Part3 p3 = new Part3();
        StorageResource r=p1.getAllGenes("ATGTAAATGCGTCGTTAGATGCATGCATAGCGTAATGTGA");
        p3.processGenes(r);


    }
}
