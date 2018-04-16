/**
 * 
 */
package com.java.algorithmicproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Feb 16, 2018
 */
public class MergeRanges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Meeting> mergeRanges(List<Meeting> meetings) {

		// make a copy so we don't destroy the input
		List<Meeting> sortedMeetings = new ArrayList<>();
		for (Meeting meeting : meetings) {
			Meeting meetingCopy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
			sortedMeetings.add(meetingCopy);
		}

		// sort by start time
		Collections.sort(sortedMeetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting m1, Meeting m2) {
				return m1.getStartTime() - m2.getStartTime();
			}
		});

		// initialize mergedMeetings with the earliest meeting
		List<Meeting> mergedMeetings = new ArrayList<>();
		mergedMeetings.add(sortedMeetings.get(0));

		for (Meeting currentMeeting : sortedMeetings) {

			Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

			// if the current meeting overlaps with the last merged meeting, use
			// the
			// later end time of the two
			if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
				lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));

				// add the current meeting since it doesn't overlap
			} else {
				mergedMeetings.add(currentMeeting);
			}
		}

		return mergedMeetings;
	}

	public static class Meeting {

		private int startTime;
		private int endTime;

		public Meeting(int startTime, int endTime) {
			// number of 30 min blocks past 9:00 am
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
	}

}
