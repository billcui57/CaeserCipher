/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import caeser.cipher.assignment.CaeserCipherAssignment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 348848128
 */
public class tester {
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    CaeserCipherAssignment cipher = new CaeserCipherAssignment();
     @Test
     public void hello() {
         assertEquals(cipher.encode("never going to give you up", 13),"arire tbvat gb tvir lbh hc");
         assertEquals(cipher.encode("never going to let you down", 1000),"zqhqd sauzs fa xqf kag paiz");
         assertEquals(cipher.encode("NEVER GOING TO TURN AROUND", 9),"WNENA PXRWP CX CDAW JAXDWM");
         assertEquals(cipher.encode("aNd DeSerT yOu", 17),"rEu UvJviK pFl");
         assertEquals(cipher.decode("zqhqd sazzm ymwq kag odk", 12),"never gonna make you cry");
         assertEquals(cipher.decode("duluh weddq iqo weetrou", 10000),"never gonna say goodbye");
         assertEquals(cipher.decode("KBSBO DLKKX QBII X IFB", 23),"NEVER GONNA TELL A LIE");
         assertEquals(cipher.decode("uHx bOlN sIo", 20),"aNd hUrT yOu");
         String[] arrayCorrect = {"Somebody once told me the world is gonna roll me, I ani't the sharpest tool in the shed. She was lookin' kinda dumb with her finger and her thumb, In the shape of an \"L\" on her forehead." ,
                                  "Kgewtgvq gfuw lgdv ew lzw ogjdv ak ygffs jgdd ew, A sfa'l lzw kzsjhwkl lggd af lzw kzwv. Kzw osk dggcaf' cafvs vmet oalz zwj xafywj sfv zwj lzmet, Af lzw kzshw gx sf \"D\" gf zwj xgjwzwsv." ,
                                  "Gcaspcrm cbqs hczr as hvs kcfzr wg ucbbo fczz as, W obw'h hvs gvofdsgh hccz wb hvs gvsr. Gvs kog zccywb' ywbro riap kwhv vsf twbusf obr vsf hviap, Wb hvs gvods ct ob \"Z\" cb vsf tcfsvsor."};
         assertArrayEquals(cipher.breakCode("Fbzrobql bapr gbyq zr gur jbeyq vf tbaan ebyy zr, V nav'g gur funecrfg gbby va gur furq. Fur jnf ybbxva' xvaqn qhzo jvgu ure svatre naq ure guhzo, Va gur funcr bs na \"Y\" ba ure sberurnq."),arrayCorrect);
         
         
     }
}
