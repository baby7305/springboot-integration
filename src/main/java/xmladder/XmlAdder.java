/*
 * This file is part of the QuickServer library
 * Copyright (C) 2003-2005 QuickServer.org
 *
 * Use, modification, copying and distribution of this software is subject to
 * the terms and conditions of the GNU Lesser General Public License.
 * You should have received a copy of the GNU LGP License along with this
 * library; if not, you can download a copy from <http://www.quickserver.org/>.
 *
 * For questions, suggestions, bug-reports, enhancement-requests etc.
 * visit http://www.quickserver.org
 *
 */

package xmladder;

import org.quickserver.net.AppException;
import org.quickserver.net.server.QuickServer;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple XML adding server.
 */
public class XmlAdder {
	public static void main(String args[]) {
		Logger logger = Logger.getLogger("");
		//logger.setLevel(Level.FINEST);
		logger.setLevel(Level.FINE);

		QuickServer myServer = new QuickServer();

		String confFile = "conf" + File.separator + "XmlAdder.xml";

		Object config[] = new Object[]{confFile};
		if (myServer.initService(config) == true) {
			try {
				myServer.startServer();
				myServer.startQSAdminServer();
			} catch (AppException e) {
				System.err.println("Error in server : " + e);
				e.printStackTrace();
			}
		}
	}
}
