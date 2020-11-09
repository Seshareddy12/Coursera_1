package StringsFirstAssignment;
import edu.duke.URLResource;


class Part1{
    public String findSimpleGene(String dna){
        String result="";
        int start = dna.indexOf("ATG");
        if(start==-1)
            return result;
        int end = dna.indexOf("TAA",start+3);
        if(end==-1)
            return result;
        if((end-start)%3==0)
           result = dna.substring(start,end+3);
        return result;
    }
    public void testSimpleGene(){
        String dna = "GATCATCGGCTATAA";
        System.out.println("StringsFirstAssignment.Gene is : "+findSimpleGene(dna));
        dna = "GATCATCGGCTATG";
        System.out.println("StringsFirstAssignment.Gene is : "+findSimpleGene(dna));
        dna = "GATCATGTAGCCGTACATGCATAA";
        System.out.println("StringsFirstAssignment.Gene is : "+findSimpleGene(dna));
        dna = "GATGGTAGTAGTAGTACTAGCGTAA";
        System.out.println("StringsFirstAssignment.Gene is : "+findSimpleGene(dna));
        dna="GATCGATCCATCCATAGAGAGAG";
        System.out.println("StringsFirstAssignment.Gene is : "+findSimpleGene(dna));

    }
}

class Part2{
    public String findSimpleGene(String dna,String startCodon,String endCodon){
    String result="";
    int start = dna.indexOf(startCodon);
        if(start==-1)
            return result;
    int end = dna.indexOf(endCodon,start+3);
        if(end==-1)
            return result;
        if((end-start)%3==0)
    result = dna.substring(start,end+3);
        return result;
}
public String caseCheck(String dna,String startCodon,String endCodon)
{
    if(dna.toLowerCase().equals(dna))
    {
        return findSimpleGene(dna.toUpperCase(),startCodon,endCodon).toLowerCase();
    }
    else
    {
        return findSimpleGene(dna.toUpperCase(),startCodon,endCodon);
    }
}

    public void testSimpleGene(){
        String dna = "GATCATCGGCTATAA";
        System.out.println("StringsFirstAssignment.Gene is : "+caseCheck(dna,"ATG","TAA"));
        dna = "GATCATCGGCTATG";
        System.out.println("StringsFirstAssignment.Gene is : "+caseCheck(dna,"ATG","TAA"));
        dna = "GATCATGTAGCCGTACATGCATAA";
        System.out.println("StringsFirstAssignment.Gene is : "+caseCheck(dna,"ATG","TAA"));
        dna = "GATGGTAGTAGTAGTACTAGCGTAA";
        System.out.println("StringsFirstAssignment.Gene is : "+caseCheck(dna,"ATG","TAA"));
        dna="GATCGATCCATCCATAGAGAGAG";
        System.out.println("StringsFirstAssignment.Gene is : "+caseCheck(dna,"ATG","TAA"));
        dna="gatggtagtagtagtactagcgtaa";
        System.out.println("StringsFirstAssignment.Gene is : "+caseCheck(dna,"ATG","TAA"));

    }
}

class Part3{
    public boolean twoOccurences(String a,String b){
        int index1 = b.indexOf(a);
        if(index1==-1)
            return false;
        int index2 = b.indexOf(a,index1+a.length());
        if(index2!=-1)
            return true;
        return false;
    }
    public String lastPart(String a,String b)
    {
        int index=b.indexOf(a);
        if(index==-1)
            return b;
        return b.substring(index+a.length());
    }
    public void testing(){
        System.out.println(twoOccurences("by","by the way bye"));
        System.out.println(twoOccurences("hello","hellohell"));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
}

class Part4{
    public void getYoutubeLinks(){
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for(String s:ur.words())
        {
            int index = s.toLowerCase().indexOf("youtube");
            if(index!=-1) {
                int start = s.indexOf("\"");
                int end = s.indexOf("\"",index+10);
                System.out.println(s.substring(start+1, end));
            }
        }
    }
}

public class Gene{
    public static void main(String args[]){
        Part1 p1 = new Part1();
        p1.testSimpleGene();
        Part2 p2 = new Part2();
        p2.testSimpleGene();
        Part3 p3= new Part3();
        p3.testing();
        Part4 p4 = new Part4();
        p4.getYoutubeLinks();
    }
}
