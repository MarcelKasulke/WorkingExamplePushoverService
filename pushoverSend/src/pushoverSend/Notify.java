package pushoverSend;
/*###############################################*/
/*#   Imported classes                         #*/
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

/**
 * Test class for Pushover
 * @author Marcel Kasulke
 *
 */
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
   * This method generates a test message for your device and sends it via internet and the pushover service to you mobile phone
   * @author MarcelKasulke 
   * 
   */
  public  void pushoverNotify(String message, String device, String title, String url, String titleurl, String music) throws IOException, PushoverException {
    //Creating instance
	PushoverRestClient pushoverRestClient = new PushoverRestClient();
    //Creating instance
	Status result = pushoverRestClient.pushMessage(PushoverMessage.builderWithApiToken("xxx")
        .setUserId("xxx")
        .setMessage(message)
        .setDevice(device)
        .setPriority(MessagePriority.HIGH)
        .setTitle(title)
        .setUrl(url)
        .setTitleForURL(titleurl)
        .setSound(music)
        .build());
    System.out.println(String.format("status: %d, request id: %s", new Object[] { Integer.valueOf(result.getStatus()), result.getRequestId() }));
    for (PushOverSound sound : pushoverRestClient.getSounds()) {
      System.out.println(String.format("name: %s, id: %s", new Object[] { sound.getName(), sound.getId() }));
    } 
  }
}

  