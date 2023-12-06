public class ContactBST<T> {
	private BSTNode<Contact> root,current;
	
	
	 public ContactBST() {
	        this.root = null;
	        this.current = null;
	    }

	 public Contact getCurrentContact() {
	        return (current != null) ? current.getData() : null;
	    }
	 
	 public BSTNode<Contact> getRoot(){
		 return root;
	 }
	 
	 public boolean isEmpty() {
		 return root == null;
	 }
	 
	    public void insert(Contact contact) {
	        if (!contactExists(contact)) {
	            if (root == null) {
	                root = new BSTNode<>(contact);
	                current = root;
	            } else {
	                insertRec(root, contact);
	            }
	        } else {
	            System.out.println("Contact with this name or phone number already exists.");
	        }
	    }
	
	    private BSTNode<Contact> insertRec(BSTNode<Contact> current, Contact contact) {
	        if (current == null) {
	            return new BSTNode<>(contact);
	        }
	        if (contact.compareTo(current.getData()) < 0) {
	            current.setLeft(insertRec(current.getLeft(), contact));
	        } else if (contact.compareTo(current.getData()) > 0) {
	            current.setRight(insertRec(current.getRight(), contact));
	        }
	        return current;
	    }
	
	    private boolean contactExists(Contact contact) {
	        return findRec(root, contact.getName()) != null || phoneNumberExistsRec(root, contact.getPhoneNumber());
	    }
	   
	    public T find(String name) {
	    	if(root.getData().getName().equalsIgnoreCase(name))
	    		return (T)root.getData();
	        current = root;
	        return (T)findRec(current, name);
	    }
	    
	    private Contact findRec(BSTNode<Contact> current, String name) {
	        if (current == null) {
	            return null;
	        }
	        int cmp = name.compareToIgnoreCase(current.getData().getName());
	        if (cmp < 0) {
	            return findRec(current.getLeft(), name);
	        } else if (cmp > 0) {
	            return findRec(current.getRight(), name);
	        } else {
	            return current.getData(); // Found
	        }
	    }
	
	    private boolean phoneNumberExistsRec(BSTNode<Contact> current, String phoneNumber) {
	        if (current == null) {
	            return false;
	        }
	        if (current.getData().getPhoneNumber().equals(phoneNumber)) {
	            return true;
	        }
	        return phoneNumberExistsRec(current.getLeft(), phoneNumber) || phoneNumberExistsRec(current.getRight(), phoneNumber);
	    }
	    
	    
	    public boolean delete(String name) {
	        boolean[] wasDeleted = new boolean[1]; // To track if the node was actually found and deleted
	        root = deleteRec(root, name, wasDeleted);
	        return wasDeleted[0];
	    }

	    private BSTNode<Contact> deleteRec(BSTNode<Contact> current, String name, boolean[] wasDeleted) {
	        if (current == null) {
	            return null; // Base case: Node not found
	        }

	        int cmp = name.compareToIgnoreCase(current.getData().getName());
	        if (cmp < 0) {
	            current.setLeft(deleteRec(current.getLeft(), name, wasDeleted));
	        } else if (cmp > 0) {
	            current.setRight(deleteRec(current.getRight(), name, wasDeleted));
	        } else {
	            wasDeleted[0] = true; // Node found and will be deleted

	            // Node with only one child or no child
	            if (current.getLeft() == null) {
	                return current.getRight();
	            } else if (current.getRight() == null) {
	                return current.getLeft();
	            }

	            // Node with two children
	            // Get the inorder successor (smallest in the right subtree)
	            Contact successorData = findMin(current.getRight());
	            current.setData(successorData);
	            current.setRight(deleteRec(current.getRight(), successorData.getName(), new boolean[1]));
	        }
	        return current;
	    }

	    private Contact findMin(BSTNode<Contact> current) {
	        while (current.getLeft() != null) {
	            current = current.getLeft();
	        }
	        return current.getData();
	    }
	    
	    
	    
	    public ContactBST<T> searchCriteria(String searchCriteria ,String searchValue) {//value = name, phonenumber, email, address or birthday
	        ContactBST<T> resultTree =  new ContactBST<>();
	        searchCriteriaRec(root, searchCriteria ,searchValue, resultTree);
	        return resultTree;
	    }
	    
	    private void searchCriteriaRec(BSTNode<Contact> current, String searchCriteria, String searchValue, ContactBST<T> resultTree) {
	        if (current == null) {
	            return;
	        }
	        // First, traverse the left subtree
	        searchCriteriaRec(current.getLeft(), searchCriteria, searchValue, resultTree);
	        
	        if (searchCriteria.equalsIgnoreCase("name") && current.getData().getName().equalsIgnoreCase(searchValue)) {
	        	 resultTree.insert(current.getData());
			}
			if (searchCriteria.equalsIgnoreCase("phone") && current.getData().getPhoneNumber().equals(searchValue)) {
				 resultTree.insert(current.getData());
			}
			if (searchCriteria.equalsIgnoreCase("email") && current.getData().getEmailAddress().equalsIgnoreCase(searchValue)) {
				 resultTree.insert(current.getData());
			}
			if (searchCriteria.equalsIgnoreCase("address") && current.getData().getAddress().equalsIgnoreCase(searchValue)) {
				 resultTree.insert(current.getData());
			}
			if (searchCriteria.equalsIgnoreCase("birthday") && current.getData().getBirthday().equals(searchValue)) {
				 resultTree.insert(current.getData());
			}
			
	        
	        searchCriteriaRec(current.getRight(), searchCriteria, searchValue, resultTree);
	    }
	    
	    public String getParticipantNames() {
	        StringBuilder namesBuilder = new StringBuilder();
	        getParticipantNamesRec(root, namesBuilder);
	        return namesBuilder.toString();
	    }

	    private void getParticipantNamesRec(BSTNode<Contact> node, StringBuilder namesBuilder) {
	        if (node == null) {
	            return;
	        }
	        getParticipantNamesRec(node.getLeft(), namesBuilder); // Traverse left subtree
	        if (namesBuilder.length() > 0) {
	            namesBuilder.append(", ");
	        }
	        namesBuilder.append(node.getData().getName());       // Process node
	        getParticipantNamesRec(node.getRight(), namesBuilder); // Traverse right subtree
	    }


	    
	    
	    
	    
}