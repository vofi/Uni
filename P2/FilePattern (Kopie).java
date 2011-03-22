package com.example;
import java.lang.String;
import java.io.File;
import java.io.FileFilter;

/** Filters file names using command-line wildcards.
 * <P>
 * <tt>*</tt> matches any number of characters.
 * <tt>?</tt> matches exactly one characters.
 * <P>
 * <b>Example:</b>
 * <tt>*.txt</tt> matches all text files; 
 * <tt>stoya??.jpg</tt> matches all images that start
 * with <i>stoya</i> and got two more characters.
 *
 * authors: Lukas Keller, Jonas von Felten *
 */
public class FilePattern implements FileFilter {

    private String input;
    private String filename;
    private String tmp;
    private String tmp2;
    private String filenametemp;
   
    public FilePattern(String string)
    {
        input = string;
    }
   
    public boolean accept(File pathname)
    {
        filename = pathname.toString();
        if (filename==input)
            return true;
        if (input=="*")
            return true;
        if (input.startsWith("*"))
            return starDotTxt();
        if (input.endsWith("*"))
            return fnameStar();
        if (input.contains("*"))
            return fDotTxt();
        if (input.charAt(0)=='?')
            return questionmark();
        if (input.contains("?"))
            return questionmarkAlternative();
        return false;
    }
   
   
    private boolean fnameStar()
    {
        filenametemp = filename+"aaaaaa";	//Vermeidung von zu kurzen Strings
        tmp = input.substring(0,input.length()-1);
        return filename.startsWith(tmp);
    }
    
    private boolean starDotTxt()
    {
        filenametemp= "aaaaaaaa"+filename;	//Vermeidung von zu kurzen Strings
        tmp = input.substring(input.length()-4,input.length());
        tmp2= filenametemp.substring(filenametemp.length()-4,filenametemp.length());
        if (tmp.equals(tmp2))
            return true;
        else
            return false;  
    }
   
    private boolean fnameStar2()
    {
        filenametemp = filename+"aaaaaa";
        tmp = input.substring(0,input.length()-5);
        return filename.startsWith(tmp);
    }
    
    private boolean fDotTxt()
    {
        boolean a=starDotTxt();
        boolean b=fnameStar2();
        if ((a==true)&&(b==true))
            return true;
        else
            return false;
       
    }
    
    /*Bearbeitung im Falle eines ? und weiterleitung bei mehreren*/
    private boolean questionmark()
    {
        int i;
        int x =0;
        for (i=0; i<input.length();i++)
        {
            if (input.charAt(i)=='?')
            {
                x++;
            }
            else
                if (starDotTxt()&& (input.length()==filename.length()))
                    return true;
                else
                    return false;
        }
       
        if (x==filename.length())
            return true;
        else
            return false; 
    }
    
    private boolean questionmarkAlternative()
    {
        if (input.length()!=filename.length())
            return false;
        else
        {
            int x =0;
            for(int i=0;i<input.length();i++)
            {
                if (input.charAt(i)==filename.charAt(i))
                    x++;
                if( input.charAt(i)=='?')
                    x++;
            }
               
        if (x==input.length())   
            return true;
        else
            return false;     
        }
       
    }

}
