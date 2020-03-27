package pushoverSend;
/*###############################################*/
/*#   Imported classes                          #*/
/*###############################################*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import net.pushover.client.MessagePriority;
import net.pushover.client.PushOverSound;
import net.pushover.client.PushoverException;
import net.pushover.client.PushoverMessage;
import net.pushover.client.PushoverRestClient;
import net.pushover.client.Status;

/*###########################################################################################*/
/*#   Classname                                                                             #*/
/*###########################################################################################*/
public class Notify {
	
    /**
	* Testmethod for Proxy-Connection, is mapping your Proxy-Settings
	* @author MarcelKasulke
	*
	*/
  public void notifySoft() throws IOException, PushoverException {
    PushoverRestClient pushoverRestClient = new PushoverRestClient();
    System.clearProperty("http.proxyHost");
    System.clearProperty("http.proxyPort");
  }
  
  /**
   * This method generates a test message for your device. It's sends it via internet using the pushover service that is sending it to you mobile phone,
   * @author MarcelKasulke
   * 
   */
  public  void pushoverNotify(String message, String device, String title, String url, String titleurl, String notifySound) throws IOException, PushoverException {
    //Creating instance
	PushoverRestClient pushoverRestClient = new PushoverRestClient();
    //Creating instance
	//You get the Token from the Pushoversite after you registered. You have to create a service in the Pushover Portal first.
	//Then insert the token here.
	Status result = pushoverRestClient.pushMessage(PushoverMessage.builderWithApiToken("xxx")
		 //Insert your user from Pushover.com
        .setUserId("xxx")
        .setMessage(message)
        .setDevice(device)
        .setPriority(MessagePriority.HIGH)
        .setTitle(title)
        .setUrl(url)
        .setTitleForURL(titleurl)
        .setSound(notifySound)
        .build());
	//Send a message to the commandline. It's used to test if there are network problems. Therefore you can start the jar in the commandline.
    System.out.println(String.format("status: %d, request id: %s", new Object[] { Integer.valueOf(result.getStatus()), result.getRequestId() }));
    for (PushOverSound sound : pushoverRestClient.getSounds()) {
    	//Send the message
      System.out.println(String.format("name: %s, id: %s", new Object[] { sound.getName(), sound.getId() }));
    } 
  }
}

  