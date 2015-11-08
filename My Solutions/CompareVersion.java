public class CompareVersion {

	public static void main(String[] args) {
		String v1 = "1.0";
		String v2 = "1";
		System.out.println(compareVersion(v1, v2));
	}

	public static int compareVersion(String version1, String version2) {

		if (version1.equals("") || version2.equals("")) {
			return 0;
		}

		String[] versions1 = version1.split("\\.");
		String[] versions2 = version2.split("\\.");
		int len = versions1.length > versions2.length? versions1.length: versions2.length;
		
		return 0;

	}
}