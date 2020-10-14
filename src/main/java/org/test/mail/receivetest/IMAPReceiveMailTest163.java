package org.test.mail.receivetest;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;

import org.test.mail.mymail.MailHelper;

import com.sun.mail.imap.IMAPStore;

public class IMAPReceiveMailTest163 {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props);

		IMAPStore store = (IMAPStore) session.getStore("imap");
//		store.connect("imap.163.com", "reception2020@163.com", "GIGWBFMKSOWCVZYU");
		store.connect("imap.163.com", "receptionmail@163.com", "LFFSMPPOPYIRZJGK");
		
		//------------------------------163 imap 認証---------------------------
		Map<String, String> clientParams = new HashMap<String, String>();
		clientParams.put("name","myname");      
		clientParams.put("version","1.0.0");      
		clientParams.put("vendor","myclient");      
		clientParams.put("support-email","testmail@test.com");  
		store.id(clientParams);
		//------------------------------------------------------------------------

		Folder folder = store.getFolder("INBOX");
		MailHelper.openFolderRW(folder);

		Message[] msgs = folder.getMessages();

		if (null != msgs && msgs.length != 0) {
			System.out.println("有"+msgs.length+"封邮件");
			
			for (int i = 0; i < msgs.length; i++) {
				Message msg = msgs[i];
				System.out.println("这封邮件的状态是"+msg.getFlags());
			}
			
		}

		MailHelper.closeFolder(folder, false);
		MailHelper.closeStore(store);

	}
}