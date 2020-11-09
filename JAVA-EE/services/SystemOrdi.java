/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 *
 * @author mbaye
 */
public class SystemOrdi {

    public static String getMAC() {
        try {
            InetAddress inetaddress = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(inetaddress);
            byte[] macArray = network.getHardwareAddress();  //get Harware address Array
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < macArray.length; i++) {
                str.append(String.format("%02X%s", macArray[i], (i < macArray.length - 1) ? "-" : ""));
            }
            String macAddress = str.toString();
            return macAddress;
        } catch (Exception E) {
            E.printStackTrace();
            return null;
        }
    }

    public static String getIPAddress() {
        try {
            InetAddress inetaddress = InetAddress.getLocalHost();
            String ip = inetaddress.getHostAddress();
            return ip;
        } catch (Exception E) {
            E.printStackTrace();
            return null;
        }
    }

    public static String getSystemName() {
        try {
            InetAddress inetaddress = InetAddress.getLocalHost();
            String name = inetaddress.getHostName();
            return name;
        } catch (Exception E) {
            E.printStackTrace();
            return null;
        }
    }

    public static void shutDownComputer() throws IOException {
        String shutdownCommand = null;
        String operatingSystem = System.getProperty("os.name");

        try {
            if (operatingSystem.contains("Linux")) {
            } else if (operatingSystem.contains("Mac OS X")) {
                shutdownCommand = "shutdown -h now";
            } else if (operatingSystem.contains("Windows")) {
                shutdownCommand = "shutdown.exe -s -t 0";
            } else {
                throw new RuntimeException("Unsupported operating system.");
            }
            Runtime.getRuntime().exec(shutdownCommand);
            System.exit(0);
        } catch (RuntimeException | IOException runtimeException) {
        }
    }

}
