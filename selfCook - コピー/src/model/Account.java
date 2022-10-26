package model;

import java.io.Serializable;

//利用者のアカウント情報を保存するデータモデル。
public class Account implements Serializable {
	private String id;
	private String pass;
	private String name;

	public Account() {
	}

	//ビュー表示用
	public Account(String name) {
		this.name = name;
	}

	//ログイン用
	public Account(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	//アカウント登録用
	public Account(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

}
