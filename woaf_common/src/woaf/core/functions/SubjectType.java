package woaf.core.functions;

public enum SubjectType {
	CONTRACT(1), 
	CUSTOMER(2);
	
	private int id;
	private SubjectType(int i){
		this.id = i;
	}
	
	public int getSubjectId(){
		return id;
	}
	
	public static SubjectType getSubjectById(int id) throws IllegalArgumentException{
		for(SubjectType st : SubjectType.values()){
			if(st.getSubjectId() == id){
				return st;
			}
		}
		throw new java.lang.IllegalArgumentException("id not found: " + id);
	}
}