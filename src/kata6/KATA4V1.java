/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;





import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author usuario
 */
public class KATA4V1 {

 /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {

      String name="C:\\Users\\usuario\\Desktop\\emails.txt";
        ArrayList<Person>mailArray=MailListReader.read(name);
        ArrayList<Person1> person=PersonLoader.read();
        
        System.out.println(mailArray.size());
        
        HistogramBuilder<Person> builder= new HistogramBuilder<>(mailArray);
        HistogramBuilder<Person1> builder1= new HistogramBuilder<>(person);
        
        Histogram<String> domains=builder.build(new Attribute<Person, String>() {

          @Override
          public String get(Person item) {
           return item.getMail().split("@")[1];
          }
      });
       

       
        
        Histogram<Character> letters=builder.build(new Attribute<Person, Character>(){
          @Override
          public Character get(Person item){
              return item.getMail().charAt(0);
          }
            //"org.sqlite.JDBC"
          //jdbc:sqlite:KATA.sDB"
        });

        Histogram<String> domains1=builder1.build(new Attribute<Person1,String>() {

          @Override
          public String get(Person1 item) {
              return item.getMail().split("@")[1]; //To change body of generated methods, choose Tools | Templates.
          }
      });
        Histogram<Float> pesos=builder1.build(new Attribute<Person1,Float>() {

          @Override
          public Float get(Person1 item) {
              return item.getPerso(); //To change body of generated methods, choose Tools | Templates.
          }
      });
        Histogram<Character> genero=builder1.build(new Attribute<Person1,Character>() {

          @Override
          public Character get(Person1 item) {
              return item.getGenero().charAt(0); //To change body of generated methods, choose Tools | Templates.
          }
      });
        
new HistogramaDisplay(domains,"DOMINIOS").execute();
new HistogramaDisplay(letters,"CHARACTER").execute();
new HistogramaDisplay(domains1,"DOMINIOS").execute();
new HistogramaDisplay(pesos,"PESOS").execute();
new HistogramaDisplay(genero,"GENERO").execute();
System.out.println("Fin");
        //Histogram<String> histogram = MailHistogramBuilder.build(mailArray);
        
        
        
        //new HistogramaDisplay(histogram).execute();
    }
}
