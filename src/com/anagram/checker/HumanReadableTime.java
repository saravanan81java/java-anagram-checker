package com.anagram.checker;

public class HumanReadableTime {

	public static void main(String[] args) {
	      // Test cases
      System.out.println(formatDuration(0));        // 00:00:00
      System.out.println(formatDuration(5));        // 00:00:05
      System.out.println(formatDuration(60));       // 00:01:00
      System.out.println(formatDuration(86399));    // 23:59:59
      System.out.println(formatDuration(359999));   // 99:59:59

	}

	private static String formatDuration(int seconds) {
		// Calculate hours, minutes, and remaining seconds
      int hours = seconds / 3600;
      int minutes = (seconds % 3600) / 60;
      int remainingSeconds = seconds % 60;

      // Format each component to be two digits, padding with zeros if necessary
      String hoursString = String.format("%02d", hours);
      String minutesString = String.format("%02d", minutes);
      String secondsString = String.format("%02d", remainingSeconds);

      // Combine the components into the final format
      return hoursString + ":" + minutesString + ":" + secondsString;
		
	}
}
