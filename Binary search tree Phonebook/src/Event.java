public class Event {

	private Boolean appointment;
	private String title;
	private String date;
	private String location;
	private ContactBST<Contact> participants;

	public Event(Boolean appointment, String title, String date, String location) {
		this.appointment = appointment;
		this.title = title;
		this.date = date;
		this.location = location;
		this.participants = new ContactBST<Contact>();

	}

	public void addParticipant(Contact contact) {
		if (this.appointment == true && !this.participants.isEmpty()) {
			throw new IllegalStateException("An appointment can only have one participant.");
		}
		this.participants.insert(contact);
	}

	public void removeParticipant(String contact) {
		this.participants.delete(contact);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ContactBST<Contact> getParticipants() {
		return participants;
	}

	public Boolean getAppointment() {
		return appointment;
	}

	public void setAppointment(Boolean appointment) {
		this.appointment = appointment;
	}

	public void setParticipants(ContactBST<Contact> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		String participantNames = participants.getParticipantNames();

		return "-----------------------\n" + "Event Type: " + (appointment ? "Appointment" : "Event") + "\nTitle: "
				+ title + "\ndate and time (MM/DD/YYYY HH:MM): " + date + "\nLocation: " + location
				+ "\nParticipants: " + participantNames + "\n-----------------------";
	}

	
}
