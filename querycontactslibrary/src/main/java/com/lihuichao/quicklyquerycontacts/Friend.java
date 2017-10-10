package com.lihuichao.quicklyquerycontacts;

public abstract class Friend implements Comparable<Friend>{
	private String name;
	private String pinyin;
	private boolean firstChar;//首个特殊字符开头的联系人

	public String getName() {
		return name;
	}

	public void setName(String name) {
		setPinyin(name);
		this.name = name;
	}

	@Override
	public int compareTo(Friend another) {
		String prePinyin = another.getPinyin().toUpperCase();
		String pinyin = getPinyin().toUpperCase();
		if(!((64<prePinyin.charAt(0)&&prePinyin.charAt(0)<91))){
			return -1;
		}
		if(!(64<pinyin.charAt(0)&&pinyin.charAt(0)<91)){
			return 1;
		}
		return pinyin.compareTo(prePinyin);
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = PinYinUtil.getPinyin(pinyin);
	}

	public boolean isFirstChar() {
		return firstChar;
	}

	public void setFirstChar(boolean firstChar) {
		this.firstChar = firstChar;
	}

}
