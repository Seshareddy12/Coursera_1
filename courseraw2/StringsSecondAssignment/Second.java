package StringsSecondAssignment;

class Part1{
    public int findStopCodon(String dna,int index,String stopCodon){
        int pos = dna.indexOf(stopCodon,index+1);
        if((index-pos)%3==0)
            return pos;
        return dna.length();

    }
    public void testFindStopCodon(){
        System.out.println(findStopCodon("ATGGTATAA",0,"TAA"));
        System.out.println(findStopCodon("ATGGTATACTACATAA",0,"TAA"));

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

    public void testFindGene(){
        System.out.println(findGene("TACGCGTAGCGCGCGGCGCGCGC",0));
        System.out.println(findGene("ATGGTATGA",0));
        System.out.println(findGene("ATGGTAAGTTGATAG",0));
        System.out.println(findGene("ATGATGATGATG",0));

    }
    public void findAllGenes(String dna){
        int start = 0;
        while(true){

            String current = findGene(dna,start);
            if(current.isEmpty())
                break;
            System.out.println(current);
            start = dna.indexOf(current,start)+current.length();

        }
    }

}

class Part2{
    public int howMany(String a,String b)
    {
        int count=0,start=0;
        while(true)
        {
            start = b.indexOf(a,start);
            if(start==-1)
                break;
            start=start+a.length();
            count++;

        }
        return count;

    }
    public void testHowMany(){
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howMany("AA","ATAAAA"));
    }
}

class Part3{
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
    public void countAllGenes(String dna){
        int start = 0;
        int count=0;
        while(true){

            String current = findGene(dna,start);
            if(current.isEmpty())
                break;
            count++;
            start = dna.indexOf(current,start)+current.length();

        }
        System.out.println(count);
    }
}

public class Second {
    public static void main(String[] args) {
        Part1 p = new Part1();
        p.testFindStopCodon();
        p.testFindGene();
        System.out.println("\nFinding all Genes \n");
        p.findAllGenes("AATGCTAACTAGCTGACTAAT");;
        System.out.println("\nTest How Many");
        Part2 p2 = new Part2();
        p2.testHowMany();
        Part3 p3 = new Part3();
        System.out.println("\nGenes Count : ");
        p3.countAllGenes("AATGCTAACTAGCTGACTAAT");
    }

}





