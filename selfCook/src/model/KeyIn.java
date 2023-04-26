package model;

import java.io.Serializable;

//検索時に入力された食材のデータを保持するデータモデル
public class KeyIn implements Serializable {
	private String food1;
	private String food2;
	private String food3;

	public KeyIn() {
	}

	public KeyIn(String food1) {
		this.food1 = food1;
	}

	public KeyIn(String food1, String food2) {
		this.food1 = food1;
		this.food2 = food2;
	}

	public KeyIn(String food1, String food2, String food3) {
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
	}

	public String getFood1() {
		return food1;
	}

	public void setFood1(String food1) {
		this.food1 = food1;
	}

	public String getFood2() {
		return food2;
	}

	public void setFood2(String food2) {
		this.food2 = food2;
	}

	public String getFood3() {
		return food3;
	}

	public void setFood3(String food3) {
		this.food3 = food3;
	}
}
