/*
 * This file is part of the QuickServer library
 * Copyright (C) QuickServer.org
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
package echoserver;

import org.quickserver.net.AppException;
import org.quickserver.net.server.QuickServer;


public class EchoServer {

	public static String version = "1.3";

	public static void main(String s[]) {
		QuickServer echoServer = new QuickServer("echoserver.EchoCommandHandler");
		echoServer.setPort(4123);
		echoServer.setName("EchoServer");
		try {
			echoServer.startServer();
		} catch (AppException e) {
			System.out.println("Error in server : " + e);
			e.printStackTrace();
		}
	}


	public static void startFromCode(String s[]) {
		QuickServer echoServer = new QuickServer("echoserver.EchoCommandHandler");
		echoServer.setPort(5102);
		echoServer.setName("EchoServer");

		try {
			echoServer.startServer();
		} catch (AppException e) {
			System.out.println("Error in server : " + e);
			e.printStackTrace();
		}
	}
}
