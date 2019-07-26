
public class BuilderPattern {

	private final int item1;
	private final int item2;
	private final int item3;
	private final int item4;
	private final int item5;

	public static class Builder {

		private final int item1;
		private final int item2;

		private int item3=0;
		private int item4=0;
		private int item5=0;

		public Builder(int item1, int item2){
			this.item1=item1;
			this.item2=item2;
		}

		public Builder item3(int val){
			item3=val;
			return this;
		}
		public Builder item4(int val){
			item4=val;
			return this;
		}
		public Builder item5(int val){
			item5=val;
			return this;
		}

		public Information builder(){
			return new Information(this);
		}

	}

	private Information(Builder builder){
		item1 = builder.item1;
		item2 = builder.item2;
		item3 = builder.item3;
		item4 = builder.item4;
		item5 = builder.item5;
	}

	public String toString(){
		return " item1 = " + item1  + ", item2 = " + item2 + ", item3 = " + item3 + ", item4 = " + item4 + ", item5 = " + item5;
	}
}
