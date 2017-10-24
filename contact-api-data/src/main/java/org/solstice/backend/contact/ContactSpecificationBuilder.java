package org.solstice.backend.contact;

public class ContactSpecificationBuilder {

	/*
	     
	    private final List<SearchCriteria> params;
	 
	    public ContactSpecificationsBuilder() {
	        params = new ArrayList<SearchCriteria>();
	    }
	 
	    public ContactSpecificationsBuilder with(String key, String operation, Object value) {
	        params.add(new SearchCriteria(key, operation, value));
	        return this;
	    }
	 
	    public Specification<Contact> build() {
	        if (params.size() == 0) {
	            return null;
	        }
	 
	        List<Specification<Contact>> specs = new ArrayList<Specification<Contact>>();
	        for (SearchCriteria param : params) {
	            specs.add(new ContactSpecification(param));
	        }
	 
	        Specification<Contact> result = specs.get(0);
	        for (int i = 1; i < specs.size(); i++) {
	            result = Specifications.where(result).and(specs.get(i));
	        }
	        return result;
	    }*/
	
}
