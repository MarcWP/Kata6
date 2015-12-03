/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class MailListReader {
        public static ArrayList<Person> read (String nameFile) throws IOException{
        ArrayList <Person> mailList=new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
        String mail;
        Integer id=0;
        while((mail=reader.readLine())!=null){
            if(!mail.contains("@"))continue;
            mailList.add(new Person(id++,mail));
        }
        return mailList;
            
        }
        }

