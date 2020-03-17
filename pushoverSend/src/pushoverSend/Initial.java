package pushoverSend;
import java.io.IOException;

import net.pushover.client.PushoverException;
/*###########################################################################################*/
/*#   Classname                                                                             #*/
/*###########################################################################################*/
public class Initial{
	/* ################################################### */
	/* # Main-Method                                     # */
	/* ################################################### */
	public static void main(String[] args) throws PushoverException, IOException{
		//Create Instance
		Notify notify = new Notify();
		//Show me some data on my phone and on my Galaxy Watch
		notify.pushoverNotify("Testnachricht","Handy","Testprotokoll","www.github/MarcelKasulke","GitHub Account","magic");
	}
}


