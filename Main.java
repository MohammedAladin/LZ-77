package com.company;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Tag> Copmression(String str) {
        ArrayList<Tag> Tags = new ArrayList<Tag>();
        String subI,subJ;
        int start;
        boolean isRepeated;

        for(int i=0 ; i<=str.length(); i++){
            start=i;

            for(int j=i+1; j<=str.length(); j++){
               subI=str.substring(i,j);
               isRepeated=false;

               for (int k=0; k<=i-subI.length(); k++){
                   subJ=str.substring(k,subI.length()+k);

                   if(subI.equals(subJ)){
                       isRepeated=true;
                       start=k;
                       break;
                   }
               }
               if (!isRepeated)
               {
                   Tags.add(new Tag(i-start,subI.length()-1 /*(-1) tends to the next char*/,str.charAt(i+subI.length()-1)));
                   i=i+subI.length()-1;
                   break;
               }

            }
        }
        return Tags;
    }

    public static String deCompression(ArrayList<Tag> Tags){
        String str="";
        for (int i=0; i<Tags.size(); i++){
            if(Tags.get(i).getPosition()==0){
                str+=Tags.get(i).getNextChar();
            }
            else{

                String sub=str.substring(str.length()-Tags.get(i).getPosition(),str.length()-Tags.get(i).getPosition()+Tags.get(i).getLength());
                str+=sub;

                if (Tags.get(i).getNextChar() !='0')
                {
                    str+=Tags.get(i).getNextChar();
                }

            }
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Tag> tags = new ArrayList<Tag>();

        int pos,len;
        char nChar;
        int choice=0;

        while (choice != 2)
        {
            System.out.println(" (1) Create tag \n (2) Compress");
            choice = sc.nextInt();
            if (choice == 1)
            {
                Tag newTag = new Tag();
                System.out.println("Please enter tag");
                newTag.setPosition(pos=sc.nextInt());
                newTag.setLength(len=sc.nextInt());
                newTag.setNextChar(nChar=sc.next().charAt(0));

                tags.add(newTag);
            }
        }

        System.out.println(deCompression(tags));

        String str=sc.next();
        System.out.println(Copmression(str));


        //String str="ABAABABAABBBBBBBBBBBBB"
        //System.out.println(deCompression(Copmression(str)));



    }
}

