
package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

/**
 * Created by Yulia on 08.09.2018.
 */
public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("37.110.116.218");
    System.out.println(ipLocation);
  }

  @Test
  public void testInvalidIp() {
 String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("37.110.116.xxx");
    System.out.println(ipLocation);

}
}

