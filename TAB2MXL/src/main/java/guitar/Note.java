package guitar;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="note")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"grace","pitch","duration","voice","type","notations","chord"})

public class Note {
	
	@XmlElement
	Pitch pitch = new Pitch();
	
	@XmlElement
	int duration;
	
	@XmlElement
	final int voice = 1;
	
	@XmlElement
	String type = "eighth";
	
	@XmlElement
	Notations notations = new Notations();
	

	@XmlElement
	Chord chord;
	
	@XmlElement
	Grace grace;
	
	public Note() {
		super();
	}
	
	public Note(Pitch pitch, int duration, int voice, String type, Notations notations) {
		super();
		this.pitch = pitch;
		this.duration = duration;
		//this.voice = voice;
		this.type = type;
		this.notations = notations;
	}
	public Note(int s, int f) {
		// TODO Auto-generated constructor stub
	}

	public Pitch getPitch() {
		return pitch;
	}
	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Notations getNotations() {
		return notations;
	}
	public void setNotations(Notations notations) {
		this.notations = notations;
	}

	public int getVoice() {
		return voice;
	}
	
	public Grace getGrace() {
		return grace;
	}

	public void setGrace(Grace grace) {
		this.grace = grace;
	}

//	public void setVoice(int voice) {
//		this.voice = voice;
//	}
//	
	public void setDefaultStep(Note n) {

		int string = n.getNotations().getTechnical().getString();		
		
		if(string == 1) {
			n.getPitch().setStep("E");
			n.getPitch().setOctave(4);
		}
		else if(string == 2) {
			n.getPitch().setStep("B");
			n.getPitch().setOctave(3);
		}
		else if(string == 3) {
			n.getPitch().setStep("G");
			n.getPitch().setOctave(3);
		}
		else if(string == 4) {
			n.getPitch().setStep("D");
			n.getPitch().setOctave(3);
		}
		else if(string == 5) {
			n.getPitch().setStep("A");
			n.getPitch().setOctave(2);
			
		}
		else if(string == 6) {
			n.getPitch().setStep("E");
			n.getPitch().setOctave(2);
		}
		
	}
	
		/*
		 * Updated the pitch of a given note based on fret number
		 * @para n note whose pitch needs to be updated
		 * @return note whose pitch has been updated 
		 * @pre only called if fret number is 0
		 */
		public Note updatePitch(Note n) {
			int octave; //an integer number 
			
			int fret = n.getNotations().getTechnical().getFret(); // fret has already been stored while parsing the 2D char array
			
			
			String defaultStep = n.getPitch().getStep(); // the step was set to what it would be if fret is 0 
			
			String[] rData = new String[24]; // to store the sequence of steps
			
			/*finding the relevantData*/
			
			if (defaultStep == "E") { // if the default step is E, then this is the array that contains the right order 
				
			String[] relevantData = {"F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E"};
			rData = relevantData;
			
			
			}else if (defaultStep == "B") {
				
			String[] relevantData = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
			rData = relevantData;	
			
			}else if(defaultStep == "G") {
				
			String[] relevantData = {"G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"};
			rData = relevantData;	
			
			}else if(defaultStep == "D") {
				
			String[] relevantData = {"D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D"};
			rData = relevantData;	
			
			}else if(defaultStep == "A") {
				
			String[] relevantData = {"A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E","F", "F#", "G", "G#", "A"};
			rData = relevantData;	
			
			}
			
			/*Setting the Step*/
						
			String actualStep = rData[fret-1]; // the actual step should be within the array 
			
			char cStep = actualStep.charAt(0); // steps can contain 2 chars, for example C#, here the step will be C
			
			String aStep = String.valueOf(cStep); // converting from char to string
			
			
			if (actualStep.length() == 1) // if the actual step is not a #
				n.getPitch().setStep(aStep);
			
			
			else { // if the actual step is a #
				n.getPitch().setAlter("1"); // sharps have alter of positive 1
				n.getPitch().setStep(aStep); // step will just be the char 
			}
			
			/*Setting the Octave*/
			
			int octaveCounter = n.getPitch().getOctave();
			
			for(int i = 0; i < rData.length; i++) {
				if (rData[i] == "C") octaveCounter++;
				char c = rData[i].charAt(0);
				String d = String.valueOf(c);
				if (d == n.getPitch().getStep() &&  fret == i+1)
					n.getPitch().setOctave(octaveCounter);
			}
			
			
			return n;
			
		}
		
	

}
