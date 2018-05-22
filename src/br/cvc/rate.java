package br.cvc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import javax.swing.JOptionPane;

public class rate {

	public static void main(String[] args) throws UnsupportedEncodingException {
		try {
			String token = JOptionPane.showInputDialog("entre com rateToken");
			if (!token.toLowerCase().contains("token") && token.length()>20) {
				byte[] asBytes = Base64.getDecoder().decode(token);
				token = new String(asBytes, "utf-8");
			}
	
			System.out.println(replaceStr(token)+ "\n");
			System.exit(0);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " +e.getMessage());
			System.exit(0);

		}


	}

	public static String replaceStr(String token) throws UnsupportedEncodingException {
		if (token.length()==3) {
			token = "\""+token+"\"";
		}
		String encod = token;
		
		List<String> list = new ArrayList<>();

		list.add("ags|agentSign");
		list.add("bde|baseDestination");
		list.add("bet|bedTypeId");
		list.add("bri|branchId");
		list.add("cat|category");
		list.add("cmi|channelManagerId");
		list.add("cpp|convertionPerPoint");
		list.add("cmz|channelManagerZoneId");
		list.add("com|commission");
		list.add("cdn|corporateDiscountCode");
		list.add("cid|credencialId");
		list.add("cur|currency");
		list.add("dod|documentDate");
		list.add("ebk|earlyBooking");
		list.add("ect|endCountry");
		list.add("dtf|endDate");
		list.add("exn|endExtraNigths");
		list.add("rli|endLocationCode");
		list.add("est|endState");
		list.add("ezi|endZoneId");
		list.add("eia|endIata");
		list.add("exd|expirationDate");
		list.add("fgr|flightGroupUserId");
		list.add("mon|honeymoon");
		list.add("hot|hotelId");
		list.add("lan|language");
		list.add("mec|merchand");
		list.add("mkp|markup");
		list.add("mki|markupId");
		list.add("rdi|roundingId");
		list.add("nmt|notMarkupTax");
		list.add("ofd|offerId");
		list.add("feb|onRequest");
		list.add("pcq|playerCurrencyQuotation");
		list.add("pkg|packageGroup");
		list.add("pxs|paxes");
		list.add("ppy|personPayment");
		list.add("pup|pickupPoint");
		list.add("plc|playerCurrency");
		list.add("ftp|playerFareType");
		list.add("pla|playerId");
		list.add("ppt|playerPaymentType");
		list.add("pot|playerPriceWithoutTax");
		list.add("pwt|playerPriceWithTax");
		list.add("pmc|playerPromotionCode");
		list.add("prm|promoCodes");
		list.add("prd|productType");
		list.add("pid|productId");
		list.add("prf|profit");
		list.add("pro|profitOriginal");
		list.add("rtc|rateCode");
		list.add("rtk|rateKey");
		list.add("res|reservationToken");
		list.add("rom|roomId");
		list.add("sdt|searchDate");
		list.add("sgk|segmentKey");
		list.add("sot|sellPriceWithoutTax");
		list.add("swt|sellPriceWithTax");
		list.add("sct|startCountry");
		list.add("dti|startDate");
		list.add("sen|startExtraNigths");
		list.add("pli|startLocationCode");
		list.add("sst|startState");
		list.add("szi|startZoneId");
		list.add("sia|startIata");
		list.add("trc|tourCode");
		list.add("vpf|vendorCode");
		list.add("vou|voucherCode");
		list.add("wek|weeks");
		list.add("rph|rph");
		list.add("typ|type");
		list.add("act|action");
		list.add("txs|taxes");
		for (String var : list) {
			String antes = var.substring(0, var.lastIndexOf("|"));
			String depois = var.substring(var.lastIndexOf("|") + 1);
			token = token.replaceAll("\""+antes+"\"", "\""+depois+"\"");
			encod = encod.replaceAll("\""+depois+"\"", "\""+antes+"\"");
		}
		if (token.length()>20) {
			encod = encod.replaceAll("decodedRateToken", "rateToken");
			System.out.println("\n"+ encod+ "\n");
		
		
			String asB64 = Base64.getEncoder().encodeToString(encod.getBytes("utf-8"));
			System.out.println("\n" +asB64+ "\n");
		}
		else {
			token = token + " = " + encod;
		}
		return token;
	}

}
