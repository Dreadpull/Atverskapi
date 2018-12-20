package delfi_atverskapi;

import javax.mail.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class JavaMail {

    private BaseFunc baseFunc;

    public JavaMail(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    public static String checkInboxForResetLink() {
        String myMail = "";

        String host = "imap.gmail.com";// change accordingly
        String username = "andris.test.agda@gmail.com";// change accordingly
        String password = "2Expense@";// change accordingly
        String resetText = "https://atverskapi.delfi.lv/password/reset";
        String resetLinkNew;
        try {

            Properties properties = new Properties();
            properties.put("mail.imap.ssl.enable", "true");
            Session session = Session.getInstance(properties);
            Store store = session.getStore("imap");

            store.connect(host, username, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();


           for (int i = messages.length-1, n = 0; i >= n; i--)
            {
                Message message = messages[i];


                Part messagePart = message;
                Object content = messagePart.getContent();
                if (content instanceof Multipart) {
                    messagePart = ((Multipart) content).getBodyPart(0);

                }
                String contentType = messagePart.getContentType();

                if (contentType.startsWith("TEXT/PLAIN")
                        || contentType.startsWith("TEXT/HTML")) {
                    InputStream is = messagePart.getInputStream();
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(is));
                    String thisLine = reader.readLine();

                    while (thisLine != null) {

                        if (thisLine.contains(resetText)) {
                            String str = new String(thisLine);

                            String array1[] = str.split(" ");

                            for (int j = 0; j < array1.length; j++) {

                                resetLinkNew = array1[j];

                                if (resetLinkNew.contains(resetText)) {

                                    return resetLinkNew;


                                }

                            }
                        }


                        myMail = myMail + thisLine;
                        thisLine = reader.readLine();
                    }

                }
//                System.out.println(myMail);


            }


            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

//    public static void main(String[] args) {
//        checkInbox();
//    }


}