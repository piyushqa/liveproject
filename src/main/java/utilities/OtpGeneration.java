//package utilities;
//
//import org.testng.annotations.Test;
//
//public class OtpGeneration {
//
//	@Test
//	public void sendSMS() throws Exception {
//		OutboundNotification outboundNotification = new OutboundNotification();
//		SerialModemGateway gateway = new SerialModemGateway("modem.com5", "COM5", 9600, "ZTE", "COM5");
//		gateway.setInbound(true);
//		gateway.setOutbound(true);
//		gateway.setSmscNumber("+91XXXXXXXXXX"); // 10-digit Mobile Number
//		Service.getInstance().setOutboundMessageNotification(outboundNotification);
//		Service.getInstance().addGateway(gateway);
//		Service.getInstance().startService();
//		OutboundMessage msg = new OutboundMessage(ExcelConnect.strSMSTo, ExcelConnect.strSMSText);
//		Service.getInstance().sendMessage(msg);
//		System.out.println(msg);
//		System.out.println(ExcelConnect.strSMSTo + "-" + ExcelConnect.strSMSText);
//		Service.getInstance().stopService();
//		Service.getInstance().removeGateway(gateway);
//	}
//}
