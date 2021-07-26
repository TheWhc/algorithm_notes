package CodeTop;

/**
 * @ClassName: _468_验证IP地址
 * @Author: whc
 * @Date: 2021/07/26/10:00
 */
public class _468_验证IP地址 {

	public String validIPAddress(String IP) {
		if(IP == null || IP.length() == 0) {
			return "Neither";
		}

		if(IP.contains(".")) {
			if(IP.charAt(IP.length()-1) == '.') {
				return "Neither";
			}
			String[] strings = IP.split("\\.");
			if(strings.length != 4) {
				return "Neither";
			}

			for (String string : strings) {
				if(!isValidIpv4(string)) {
					return "Neither";
				}
			}
			return "IPv4";
		} else if(IP.contains(":")) {
			if(IP.charAt(IP.length()-1) == ':') {
				return "Neither";
			}
			String[] strings = IP.split(":");
			if(strings.length != 8) {
				return "Neither";
			}

			for (String string : strings) {
				if(!isValidIpv6(string)) {
					return "Neither";
				}
			}

			return "IPv6";
		}

		return "Neither";
	}

	private boolean isValidIpv6(String string) {
		if(string == null || string.length() == 0 || string.length() > 4) {
			return false;
		}

		for (int i = 0; i < string.length(); i++) {
			if(!(string.charAt(i) >= '0' && string.charAt(i) <= '9'
			|| string.charAt(i) >= 'a' && string.charAt(i) <= 'f'
			|| string.charAt(i) >= 'A' && string.charAt(i) <= 'F')) {
				return false;
			}
		}

		return true;
	}

	private boolean isValidIpv4(String string) {
		if(string == null || string.length() == 0 || string.length() > 3) {
			return false;
		}
		if(string.length() == 1) {
			return true;
		}

		// 012、013
		if(string.charAt(0) == '0') {
			return false;
		}

		int sum = 0;
		for (int i = 0; i < string.length(); i++) {
			if(!(string.charAt(i) >= '0' && string.charAt(i) <= '9')) {
				return false;
			}
			sum = sum * 10 + (string.charAt(i) - '0');
			if(sum > 255) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		_468_验证IP地址 _468_验证IP地址 = new _468_验证IP地址();
		System.out.println(_468_验证IP地址.validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
	}

}
