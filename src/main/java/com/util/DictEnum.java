package com.util;

import java.util.ArrayList;
import java.util.List;

public enum DictEnum {
	/**/
	;

	private String type;
	private String code;
	private String value;
	private Integer index;
	
	private DictEnum(String type, String code, String value) {
	    this.type = type;
        this.code = code;
        this.value = value;
	}
	
	private DictEnum(String type, String code, String value, Integer index) {
	    this.type = type;
        this.code = code;
        this.value = value;
        this.index = index;
    }
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public static List<DictEnum> getDictList(String type) {
		List<DictEnum> result = new ArrayList<>();
		DictEnum[] dicts = DictEnum.values();
		for(DictEnum dict : dicts) {
			if (dict.getType()!=null && dict.getType().equals(type)) {
				result.add(dict);
			}
		}
		return result;
	}
    
	
	public static DictEnum getDict(String type,String code){
		List<DictEnum> list = getDictList(type);
		for(DictEnum dict : list) {
			if (dict.getCode().equals(code)) {
				return dict;
			}
		}
		return null;
	}
	
	public static String getDictCode(String type,String value){
		List<DictEnum> list = getDictList(type);
		for(DictEnum dict : list) {
			if (dict.getValue().equals(value)) {
				return dict.getCode();
			}
		}
		return null;
	}

	public static String getDictCode(String type, Integer index) {
		List<DictEnum> list = getDictList(type);
		for (DictEnum dict : list) {
			if (dict.getIndex() == index) {
				return dict.getCode();
			}
		}
		return null;
	}

	public static String getDictValue(String code, String dictType) {
		DictEnum dict = getDict(dictType, code);
		if (dict != null) {
			return dict.getValue();
		}
		return null;
	}

    public static String getDictValue(String type, Integer index) {
        List<DictEnum> list = getDictList(type);
        for (DictEnum dict : list) {
            if (dict.getIndex() == index) {
                return dict.getValue();
            }
        }
        return null;
    }
}
