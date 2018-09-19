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
         assertarrayequals
         
     }
}
