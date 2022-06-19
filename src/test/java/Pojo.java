import java.util.List;

public class Pojo {
	private String squadName;
	private String secretBase;
	private String homeTown;
	private List<MembersItem> members;
	private boolean active;
	private int formed;

	public String getSquadName(){
		return squadName;
	}

	public String getSecretBase(){
		return secretBase;
	}

	public String getHomeTown(){
		return homeTown;
	}

	public List<MembersItem> getMembers(){
		return members;
	}

	public boolean isActive(){
		return active;
	}

	public int getFormed(){
		return formed;
	}

	static class MembersItem{
		private String secretIdentity;
		private String name;
		private List<String> powers;
		private int age;

		public String getSecretIdentity(){
			return secretIdentity;
		}

		public String getName(){
			return name;
		}

		public List<String> getPowers(){
			return powers;
		}

		public int getAge(){
			return age;
		}
	}
}
