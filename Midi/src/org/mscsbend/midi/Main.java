package org.mscsbend.midi;

import java.io.File;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Main {

	public static void main(String[] args) throws Exception {
		Sequence sequence = new Sequence(Sequence.PPQ, 1);
		Track track1 = sequence.createTrack();
		setInstrument(0, track1, 1);
		add(0, track1, 0, 64, 2);
		add(0, track1, 1, 60, 2);
		add(0, track1, 1, 64, 2);
		add(0, track1, 1, 68, 1);
		add(0, track1, 2, 72, 1);
		add(0, track1, 2, 76, 1);
		add(0, track1, 2, 80, 1);
		add(0, track1, 3, 72, 2);
		add(0, track1, 3, 76, 2);
		add(0, track1, 3, 82, 2);
		add(0, track1, 4, 72, 4);
		add(0, track1, 4, 76, 4);
		add(0, track1, 4, 82, 4);
		add(0, track1, 4, 84, 4);

		Track track2 = sequence.createTrack();
		setInstrument(1, track2, 42);
		add(1, track2, 2, 84, 2);
		add(1, track2, 4, 72, 2);

		File file = new File("test.midi");
		MidiSystem.write(sequence, 1, file);
	}
	/**
	 * http://en.wikipedia.org/wiki/General_MIDI#Program_change_events
	 * @param track
	 * @param instrument
	 * @throws Exception
	 */
	private static void setInstrument(int channel, Track track, int instrument) throws Exception {
		ShortMessage instrumentChange = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument, 0);
        track.add(new MidiEvent(instrumentChange, 0));
	}
	
	private static void add(int channel, Track track, int tick, int note, int length) throws Exception {
		ShortMessage onMessage = new ShortMessage(ShortMessage.NOTE_ON, channel, note, 64);
		MidiEvent onEvent = new MidiEvent(onMessage, tick);
		track.add(onEvent);		
		ShortMessage offMessage = new ShortMessage(ShortMessage.NOTE_OFF, channel, note, 64);
		MidiEvent offEvent = new MidiEvent(offMessage, tick+length);
		track.add(offEvent);
	}
	
}
