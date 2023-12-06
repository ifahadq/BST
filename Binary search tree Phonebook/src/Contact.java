public class Contact implements Comparable<Contact> {

	private String firstName;
	private String lastName;
	private String name;
	private String phoneNumber;
	private String emailAddress;
	private String address;
	private String birthday;
	private String notes;

	public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
			String notes) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;

		String[] nameParts = name.split(" ");

		if (nameParts.length >= 2) {
			firstName = nameParts[0];
			lastName = nameParts[1];
		}
	}

	@Override
	public int compareTo(Contact other) {

		int result = this.firstName.compareToIgnoreCase(other.getFirstName());
		if (result == 0) {
			result = this.lastName.compareToIgnoreCase(other.getLastName());
		}
		return result;
	}

	public boolean equals(Object e) {
		Contact contact = (Contact) e;
		return contact.getName().equalsIgnoreCase(name) || contact.getPhoneNumber().equalsIgnoreCase(phoneNumber);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}